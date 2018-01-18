package ru.job4j.waitNotify;

import com.sun.xml.internal.ws.api.pipe.FiberContextSwitchInterceptor;

import java.util.LinkedList;
import java.util.Queue;

/**
 * собственную версию bounded blocking queue. Блокирующая очередь,
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
		currentJobList.add(work);
	}


	public void main(String args[]) throws InterruptedException {
		ThreadPool tp = new ThreadPool();
		//tp.add(W tp.workOne());
		//tp.add(tp.workOne());


		// Наш Thread будет запускать требуемое число процессов
		new Thread() {
			@Override
			public void run() {
				W newWork = null;
				// внешний цикл - запускаем work до тех пор пока они есть в листе работ
				while (tp.currentJobList.size() > 0) synchronized (tp.currentJobList) {
					//
					// а как нам вычислять (Threadcounts) сколько из азпущенных работ у нас работает?
					//
					//while (Threadcounts >= tp.maxTreadCount) {
					while (tp.maxTreadCount > tp.maxTreadCount) {
						try {
							tp.currentJobList.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					// Запустим столько процессов, сколько можем: в идеале: for (int indx = 1; tp.maxTreadCount - Threadcounts; indx++)
					//for (int indx = 1; tp.maxTreadCount; indx++) {
					for (int indx = 1; indx < tp.maxTreadCount; indx++) {
						newWork = (W) tp.currentJobList.remove();
						tp.currentJobList.notify();
						newWork.run();
					}
				}
			}
		}.start();
	}


}
