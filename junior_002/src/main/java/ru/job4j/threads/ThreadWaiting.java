package ru.job4j.threads;

/**
 * Oracle Example
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class ThreadWaiting implements  Runnable{
	private String textString = "Cко ль ко про бе лов ? ";

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
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Пока");

	}

	static class MainThread implements Runnable {
		private String text;
		private int count = 1;

		@Override
		public void run() {
			try {
				for (int ind = 0; ind < 5; ind++) {
					System.out.println("Выполняется MainThread");
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		ThreadWaiting ct = new ThreadWaiting();

		Thread tStart = new Thread(ct);
		tStart.start();

	}

}
