package ru.job4j.threads;

/**
 * Ошбика при многопоточности.
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class MultithreadsErrors {
	private static int moneyBalance = 100;

	public static int getMoneyBalance() {
		return MultithreadsErrors.moneyBalance;
	}

	public static void setMoneyBalance(int moneyBalance) {
		MultithreadsErrors.moneyBalance = moneyBalance;
	}

	static class ThreadOne implements Runnable {
		private int temp = 0;
		@Override
		public void run() {
			System.out.println("Стартовал Thread 1");
			try {
				for (int ind = 0; ind < 10; ind++) {
					temp = MultithreadsErrors.getMoneyBalance();
					System.out.println("Thread-1 был: " + temp);
					Thread.sleep(700);
					temp = temp + 10;
					System.out.println("Thread-1 стал: " + temp);
					MultithreadsErrors.setMoneyBalance(temp);
					Thread.sleep(700);
				}
				System.out.println("timerThread закончил работу");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class ThreadTwo implements Runnable {
		private int temp = 0;
		@Override
		public void run() {
			System.out.println("Стартовал Thread 1");
			try {
				for (int ind = 0; ind < 5; ind++) {
					temp = MultithreadsErrors.getMoneyBalance();
					System.out.println("Thread-2 был: " + temp);
					Thread.sleep(500);
					temp = temp + 10;
					System.out.println("Thread-2 стал: " + temp);
					MultithreadsErrors.setMoneyBalance(temp);
					Thread.sleep(500);
				}
				System.out.println("timerThread закончил работу");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}



	public static void main(String[] args) {
		MultithreadsErrors ct = new MultithreadsErrors();

		Thread trdOne = new Thread(new MultithreadsErrors.ThreadOne());
		trdOne.start();

		Thread trdTwo = new Thread(new MultithreadsErrors.ThreadTwo());
		trdTwo.start();

		System.out.println("Выход из main");



	}

}
