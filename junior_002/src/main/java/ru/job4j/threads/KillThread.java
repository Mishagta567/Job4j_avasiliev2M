package ru.job4j.threads;

/**
 * Oracle Example
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class KillThread {
	private String textString = "Cколько слов в данном предложении? Не успеешь сосчитать.";
	private long startTime;
	private long patience = 1000 * 5;

	public long getStartTime() {
		return this.startTime;
	}

	public long getPatience() {
		return this.patience;
	}

	public String getTextString() {
		return this.textString;
	}

	public KillThread() {
		startTime = System.currentTimeMillis();
	}

	void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n",	threadName,	message);
	}

	class TimerThread implements Runnable {
		private Thread threadToKill;
		private long startTimeCopy;

		public TimerThread(Thread thrd) {
			this.threadToKill = thrd;
		}

		@Override
		public void run() {
			System.out.println("Стартовал Thread таймер");
			try {
				for (int ind = 0; ind < 10; ind++) {
					if (startTime + patience < System.currentTimeMillis()) {
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

	class LettersCount implements Runnable {

		private int count = 1;
		@Override
		public void run() {
			try {
				for (int indx = 0; indx < textString.length(); indx++) {
					if (!Thread.interrupted()) { //isInterrupted проверять в любых ключевых точках,
						// где можно обработать прерывание потока
						if (textString.charAt(indx) != ' ') {
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

	public static void main(String[] args) {
		KillThread ct = new KillThread();

		// убрал везде преобразователь static. Запустить Thread для теста теперь не получается.

		//Thread tLetters = new Thread(new KillThread.LettersCount());
		//tLetters.start();
		//
		//Thread tSpace = new Thread(new timerThread(tLetters));
		//tSpace.start();
	}

}
