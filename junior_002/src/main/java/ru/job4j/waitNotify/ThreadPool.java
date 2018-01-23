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
	private Queue currentJobList = new LinkedList();
	private int count = 0;
	private final int maxTreadCount = Runtime.getRuntime().availableProcessors();
	private Boolean stopWork = false;


	public void workOne() throws InterruptedException {
			for (int indx = 0; indx < 5; indx++) {
			System.out.printf("work-%S, indx: %s%n", count++, indx);
			Thread.sleep(1000);
		}
	}

	public void add(W work) {
		synchronized (this.currentJobList) {
			this.currentJobList.add(work);
			this.currentJobList.notify();
		}
	}

	public void stop() {
		synchronized (this.currentJobList) {
			stopWork = true;
			stopWork.notify();
		}
	}

	public void work() {

		for (int threadIndx = 1; threadIndx <= maxTreadCount; threadIndx++) {
			// Каждый Thread будет либо спать, либо выполнять какую-то работу.
			new Thread() {
				@Override
				public void run() {
					W newWork = null;

					// Хочется запустить вечный цикл в котором нити будут ждать появления новых задач
					// Понятно что в идеале лучше сделать какой-то параметр, после обнавления которого нити закрываются,
					// но сейчас это не принципиально.
					while (stopWork) synchronized (stopWork){

						// этот цикл - запускаем work до тех пор пока они есть в листе работ, или ложиться спать
						while (currentJobList.size() == 0) synchronized (currentJobList) {
							try {
								currentJobList.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						while (currentJobList.size() > 0 && !stopWork) synchronized (currentJobList) {
							//
							newWork = (W) currentJobList.remove();
							currentJobList.notify();
							// Я исхожу из того что цикл НЕ будет повторяться пока не будет выполнен полностью код в данной работе
							newWork.run();
						}
					}
				}
			}.start();
		}
	}

	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool();
		//pool.add(new Work());
		pool.stop();
	}

}
