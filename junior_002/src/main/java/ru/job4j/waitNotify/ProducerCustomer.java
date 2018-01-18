package ru.job4j.waitNotify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * собственную версию bounded blocking queue. Блокирующая очередь,
 *
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class ProducerCustomer {
	private Queue<Integer> jobList = new LinkedList<Integer>();
	private boolean addLocked = false;
	private boolean removeLocked = true;
	private int count = 0;

	public void add() throws InterruptedException {
		synchronized (this.jobList) {
			// добавляем строки счетчик от 1 до 20 пока размер листа меньше 5 (для теста)
			for (int indAdd = 0; indAdd <= 50; indAdd++) {
				while (jobList.size() >= 5) {
					System.out.println("Add заснул");
					this.jobList.wait();
				}
				System.out.printf("Add добавил %s%n", count);
				this.jobList.add(this.count++);
				this.jobList.notify();
				// if (count < 10) {
				// 	Thread.sleep(500);
				// } else {
				// 	Thread.sleep(2000);
				// }

			}
		}
	}

	public void remove() throws InterruptedException {
		synchronized (this.jobList) {
			// добавляем строки счетчик от 1 до 20 пока размер листа меньше 5 (для теста)
			for (int ind = 0; ind <= 50; ind++) {
				while (jobList.size() == 0) {
					System.out.println("Remove заснул");
					this.jobList.wait();
				}
				System.out.printf("Remove удалил %s%n", this.jobList.peek());
				this.jobList.remove();
				this.jobList.notify();
				//Thread.sleep(1000);
			}
		}
	}


	public static void main(String args[]) {
		ProducerCustomer pc = new ProducerCustomer();

		// Сначала запустим add
		new Thread() {
			@Override
			public void run() {
				try {
					pc.add();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();

		// Теперь запустим remove
		new Thread() {
			@Override
			public void run() {
				try {
					pc.remove();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

}
