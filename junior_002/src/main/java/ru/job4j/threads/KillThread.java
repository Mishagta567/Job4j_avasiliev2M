package ru.job4j.threads;

/**
 * Oracle Example
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class KillThread {
	private static String textString = "Cколько слов в данном предложении? Не успеешь сосчитать.";
	private static long startTime;
	private static long patience = 1000 * 5;

	public static long getStartTime() {
		return KillThread.startTime;
	}

	public long getPatience() {
		return KillThread.patience;
	}

	public String getTextString() {
		return this.textString;
	}

	public KillThread() {
		startTime = System.currentTimeMillis();
	}

	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n",	threadName,	message);
	}

	static class timerThread implements Runnable {
		private Thread threadToKill;
		private long startTimeCopy;

		public timerThread(Thread thrd) {
			this.threadToKill = thrd;
		}

		@Override
		public void run() {
			System.out.println("Стартовал Thread таймер");
			try {
				for (int ind = 0; ind < 10; ind++) {
					if (KillThread.startTime + KillThread.patience < System.currentTimeMillis()) {
						System.out.println("Основная нить должны скоро остановиться");
						threadToKill.interrupt();
						break;
					} else {
						Thread.sleep(1000);
					}
				}
				System.out.println("timerThread закончил работу");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class LettersCount implements Runnable {

		private int count = 1;



		@Override
		public void run() {
			try {
				for (int indx = 0; indx < KillThread.textString.length(); indx++) {
					if (!Thread.interrupted()) {//isInterrupted проверять в любых ключевых точках,
						// где можно обработать прерывание потока
						if (KillThread.textString.charAt(indx) != ' ') {
							Thread.sleep(1000);
							// Print a message
							System.out.printf("Букв: %s%n", count++);
         			}
					} else {
						// в нашем случае можно было бы ничего не делать. Счетчик добежал бы до макс. и все
						System.out.println("Thread LetterCount останавливает себя");
						throw new InterruptedException();
					}
				}
			} catch (InterruptedException e) {
				//e.printStackTrace();    // В нашем случае наверное это сообщение лишнее, т.к. оно вызвается преднамеренно.
			}
		}
	}

	public static void main(String args[]) {
		KillThread ct = new KillThread();

		Thread tLetters = new Thread(new KillThread.LettersCount());
		tLetters.start();

		Thread tSpace = new Thread(new timerThread(tLetters));
		tSpace.start();
	}

}
