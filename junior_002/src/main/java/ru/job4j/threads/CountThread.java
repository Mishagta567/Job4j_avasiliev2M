package ru.job4j.threads;

import ru.job4j.example.SimpleThreads;

/**
 * Oracle Example
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class CountThread {
	private String textString = "Cко ль ко про бе лов ? ";

	public String getTextString() {
		return this.textString;
	}

	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n",	threadName,	message);
	}

	static class SpaceCount implements Runnable {
		private String text;
		private int count = 1;

		public SpaceCount(String text) {
			this.text = text;
		}

		@Override
		public void run() {
			try {
				for (int indx = 0; indx < text.length(); indx++) {
					if (this.text.charAt(indx) == ' ') {
						Thread.sleep(1900);
						// Print a message
						System.out.printf("Пробелов: %s%n", count++);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class LettersCount implements Runnable {
		private String text;
		private int count = 1;

		public LettersCount(String text) {
			this.text = text;
		}

		@Override
		public void run() {
			try {
				for (int indx = 0; indx < text.length(); indx++) {
					if (this.text.charAt(indx) != ' ') {
						Thread.sleep(1000);
						// Print a message
						System.out.printf("Букв: %s%n", count++);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		CountThread ct = new CountThread();

		Thread tLetters = new Thread(new CountThread.LettersCount(ct.textString));
		tLetters.start();

		Thread tSpace = new Thread(new CountThread.SpaceCount(ct.textString));
		tSpace.start();
	}

}
