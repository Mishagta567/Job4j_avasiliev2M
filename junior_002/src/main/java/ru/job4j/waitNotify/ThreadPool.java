package ru.job4j.waitNotify;

import com.sun.xml.internal.ws.api.pipe.FiberContextSwitchInterceptor;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ThreadPool [#1099]
 *
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class ThreadPool<W extends Runnable> {
	private static Queue currentJobList = new LinkedList();
	private static int count = 0;
	private final int maxTreadCount = Runtime.getRuntime().availableProcessors();


	public static void workOne() throws InterruptedException {
			for (int indx = 0; indx < 5; indx++) {
			System.out.printf("work-%S, indx: %s%n", ThreadPool.count++, indx);
			Thread.sleep(1000);
		}
	}

	public void add(W work) {
		synchronized (this.currentJobList) {
			this.currentJobList.add(work);
			this.currentJobList.notify();
		}
	}


	public void main(String args[]) throws InterruptedException {
		ThreadPool tp = new ThreadPool();
		//tp.add(W tp.workOne());
		//tp.add(tp.workOne());

		// А кто нам мешает сделать loop и запустить столько нитей, сколько у нас maxTreadCount ?

		for (int threadIndx = 1; threadIndx <= maxTreadCount; threadIndx++) {

			// Каждый Thread будет либо спать, либо выполнять какую-то работу.
			new Thread() {
				@Override
				public void run() {
					W newWork = null;

					// Хочется запустить вечный цикл в котором нити будут ждать появления новых задач
					// Понятно что в идеале лучше сделать какой-то параметр, после обнавления которого нити закрываются,
					// но сейчас это не принципиально.
					while (2 > 1) {

						// этот цикл - запускаем work до тех пор пока они есть в листе работ, или ложиться спать
						while (tp.currentJobList.size() == 0) synchronized (tp.currentJobList) {
							try {
								tp.currentJobList.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						while (tp.currentJobList.size() > 0) synchronized (tp.currentJobList) {
							//
							newWork = (W) tp.currentJobList.remove();
							tp.currentJobList.notify();
							// Я исхожу из того что цикл НЕ будет повторяться пока не будет выполнен полностью код в данной работе
							newWork.run();
						}
					}
				}
			}.start();
		}
	}


}
