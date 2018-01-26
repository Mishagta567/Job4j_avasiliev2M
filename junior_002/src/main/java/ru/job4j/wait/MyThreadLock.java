package ru.job4j.wait;

/**
 * Реализовать собственный механизм блокировок Lock. [#1100]
 *
 * @author   A_Vasiliev
 * @since    19.01.2018
 * @version  1.0.0
 */


public class MyThreadLock {
	private String lockString;
	private Boolean objectLocked;
	private long lockedThread;

	public void myLock(String value) {
		this.lockString = value;
		this.objectLocked = false;
	}

	public void doSomthing(String value) {
		synchronized (objectLocked) {
			System.out.println("DoSomthing");
			this.lockString = value;
			this.objectLocked.notify();
		}
	}

	public void lock() throws InterruptedException {
		synchronized (objectLocked) {
			while (this.objectLocked) {
				objectLocked.wait();
			}
			objectLocked = true;
			objectLocked.notify();
			lockedThread = Thread.currentThread().getId();
		}
	}

	public void unLock() throws InterruptedException {
		synchronized (objectLocked) {
			// Mы что-то делаем только если это наш поток залочил наш объект
			if (lockedThread == Thread.currentThread().getId()) {
				while (this.objectLocked) {
					objectLocked.wait();
				}
				objectLocked = false;
				objectLocked.notify();
				lockedThread = 0;
			}
		}
	}
}