package ru.job4j.threads;

/**
 * Oracle Example
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class ThreadWaiting { //} implements  Runnable{
	private String textString = "Cко ль ко про бе лов ? ";

	/**
	// этот метод уже не используется.
	public String getTextString() {
		return this.textString;
	}

	@Override
	public void run() {

		System.out.print("Запустилась наша класс ThreadWaiting");
		Thread mainThread = new Thread(new ThreadWaiting.MainThread());
		mainThread.start();

		// Ждем пока mainThread закончит свою работу. Потом выводим очередное сообщение
		while (mainThread.isAlive()) {
			try {
				//Thread.sleep(1000);
				// можно так:
				mainThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Пока");

	} // */

	private static class MainThread implements Runnable {
		//private String text;
		//private int count = 1;

		@Override
		public void run() {
			try {
				for (int ind = 0; ind < 5; ind++) {
					System.out.printf("Выполняется MainThread- %s %n", ind);
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		//ThreadWaiting ct = new ThreadWaiting();

		//Thread tStart = new Thread(ct);
		//tStart.start();

		Thread main = new Thread(new MainThread());
		main.start();
		int count = 1;

		while (main.isAlive()) {
			System.out.printf("Жду пока main закончит %s раз %n", count++);
			main.join(1200);
		}
		System.out.printf("Ну наконец-то то дождался. Выход.");

	}

}
