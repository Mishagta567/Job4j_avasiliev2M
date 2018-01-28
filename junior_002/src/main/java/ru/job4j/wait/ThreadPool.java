package ru.job4j.wait;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
	private List<Thread> threads = new ArrayList<Thread>();


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
		synchronized (this.stopWork) {
			stopWork = true;
			stopWork.notify();
			for (Thread thr : threads) {
			   thr.interrupt();
         }
		}
	}

	public void work() {

		for (int threadIndx = 1; threadIndx <= maxTreadCount; threadIndx++) {
			// Каждый Thread будет либо спать, либо выполнять какую-то работу.
			new Thread() {
				@Override
				public void run() {
					W newWork = null;
               ThreadPool.this.threads.add(Thread.currentThread());


					// Хочется запустить вечный цикл в котором нити будут ждать появления новых задач
					// Понятно что в идеале лучше сделать какой-то параметр, после обнавления которого нити закрываются,
					// но сейчас это не принципиально.
					//while (!stopWork) {
               while (!Thread.currentThread().isInterrupted()) {
						synchronized (stopWork) {
							// этот цикл - запускаем work до тех пор пока они есть в листе работ, или ложиться спать
							while (currentJobList.size() == 0) {
								synchronized (currentJobList) {
									try {
										currentJobList.wait();
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							}

							while (currentJobList.size() > 0 && !stopWork) {
								synchronized (currentJobList) {
									//
									newWork = (W) currentJobList.remove();
									currentJobList.notify();
									// Я исхожу из того что цикл НЕ будет повторяться пока не будет выполнен полностью код в данной работе
									newWork.run();
								}
							}
						}
					}
				}
			}.start();
		}
	}

}
