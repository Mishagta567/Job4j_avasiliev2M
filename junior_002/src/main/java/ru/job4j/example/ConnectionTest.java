package ru.job4j.example;


/**
 * Пример из видео Петра А.
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */

public class ConnectionTest {

	public static final class Counter {
		long count = 0;
		static String name = "String name";

		public void add(long value) {
			count += value;
		}

		// lock = this   Instance объекта counter
		public synchronized void add2(long value) {
			count += value;
		}

		// lock = this   Instance объекта counter
		public void add3(long value) {
			synchronized (this) {
				this.count += value;
			}
		}

		//  lock = class
		public static synchronized void echo() {
			System.out.println(name);

		}

		public synchronized void sum(final Counter a, final Counter b) {
			a.add(b.count);
		}
	}

	public static final class CounterThread extends Thread {
		protected final Counter counter;

		public CounterThread(final Counter counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			counter.add(1);
			/**		// А можно так:
			synchronized (this.counter) {
				counter.add(1);
			}			//  */

		}
	}


	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter);

		threadA.start();
		threadB.start();
		threadA.join();
		threadB.join();
		System.out.println(counter.count);
		System.out.println(Math.abs(Integer.MIN_VALUE));

	}



}