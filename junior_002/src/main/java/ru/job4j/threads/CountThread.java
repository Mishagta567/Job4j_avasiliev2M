package ru.job4j.threads;

import ru.job4j.example.Usage;

/**
 * Oracle Example
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class CountThread {
	static private String textString = "Cко льк о про бел ов? ";

	public String getTextString() {
		return this.textString;
	}

	void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n",	threadName,	message);
	}

	static class SpaceCount implements Runnable {
		private String text = textString;
		private int count = 0;

		public SpaceCount() {
			this.text = CountThread.textString;
		}

		@Override
		public void run() {
			for (int indx = 0; indx < text.length(); indx++) {
				if (this.text.charAt(indx) == ' ') {
					//Thread.sleep(900);
					// Print a message
					//System.out.printf("Пробелов: %s%n", count++);
					count++;
				}
			}
         System.out.printf("Пробелов: %s%n", count++);
		}
	}

	static class LettersCount implements Runnable {
		private String text = textString;
		private int count = 0;

		public LettersCount() {
			this.text = textString;
		}

		@Override
		public void run() {
			//try {
				for (int indx = 0; indx < text.length(); indx++) {
					if (this.text.charAt(indx) != ' ') {
						//Thread.sleep(5000);
						// Print a message
						//System.out.printf("Букв: %s%n", count++);
						count++;
					}
				}
			//} catch (InterruptedException e) {
			//	e.printStackTrace();
			//}
         System.out.printf("Букв: %s%n", count++);
		}
	}
		
	public void getAllCounts() {
		Thread tSpace = new Thread(new SpaceCount());
		tSpace.start();
		Thread tLetters = new Thread(new LettersCount());
		tLetters.start();
	}

	public static void main(String[] arg) {
      CountThread ct = new CountThread();
      ct.getAllCounts();
   }

}
