package ru.job4j.example;


/**
 * Пример Петра ProducerCustomer
 *
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */

public class WaitNotify {

	private final Object lock = new Object();
	private boolean blockCustomer = true;

	public void doSomething() throws InterruptedException {
		synchronized (this.lock) {
			while (this.blockCustomer) {
				System.out.println(String.format("%s wait", Thread.currentThread().getId()));
				lock.wait();
			}
			System.out.println(String.format("%s userful work", Thread.currentThread().getId()));
		}
	}

	public void changeBlock(boolean enable) {
		synchronized (this.lock) {
			System.out.println(String.format("%s enable", Thread.currentThread().getId()));
			this.blockCustomer = enable;
			this.lock.notify();
		}
	}

	public static void main(String[] args) {
		final WaitNotify blockingWork = new WaitNotify();
		// producer
		new Thread() {
			@Override
			public void run() {
				blockingWork.changeBlock(false);
			}
		}.start();

		// customer
		new Thread() {
			@Override
			public void run() {
				try {
					blockingWork.doSomething();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();

	}
}