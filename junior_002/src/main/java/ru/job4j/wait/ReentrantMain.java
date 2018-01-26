package ru.job4j.wait;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Тестовое задание. [#1108]
 * Реализовать игру бомбермен. Без графики
 *
 * @author   A_Vasiliev
 * @since    20.01.2018
 * @version  1.0.0
 */


public final class ReentrantMain {
	static final private int BORDSSIZE = 10;
	static private long startTime = System.currentTimeMillis();
	static private boolean stopPlay = false;			// По идее изменив на true - выходим из вечного игры.
	static boolean playerStillAlive = true;  // В каком случае проигрывает не определено. Значит не реализовал. Значит пока бегают бесконечно
	static int monstersCount = 4;  // кол-во монстров.
	ReentrantCell[][] board = new ReentrantCell[BORDSSIZE][BORDSSIZE];

	// Направление движения игрока - для того что бы в будущем пользователь мог управлять.
	private int playerDirection = 0;  // 0-3: 0-север=вверх, 1-восток=вправо, 2-юг=вниз, 3-запад=влево

	public void setPlayerDirection(int playerDirection) {
		this.playerDirection = playerDirection;
	}

	public ReentrantMain() {
		this.startTime = System.currentTimeMillis();
		this.stopPlay = false;
		// проинициалзируем наш двухмерный массив
		for (int indxHorizon = 0; indxHorizon < BORDSSIZE; indxHorizon++) {
			for (int indxVertical = 0; indxVertical < BORDSSIZE; indxVertical++) {
				board[indxHorizon][indxVertical] = new ReentrantCell();
			}
		}
		// ради прикола несколько ячеек можно сделать недоступные для входа
		board[2][4].setEnterable(false);
		board[8][7].setEnterable(false);
		board[7][3].setEnterable(false);
		board[3][8].setEnterable(false);

	}

	public void playerMove() throws InterruptedException {
		synchronized (this.board) {
			int horizontPos = 3;  // На данном этапе можно начинать из центра
			int verticalPos = 3;
			int horizontNextPos = 3;  // На данном этапе можно начинать из центра
			int verticalNextPos = 3;

			boolean nextCellEnterable = false;
			long lastMoveTime = ReentrantMain.startTime;

			while (ReentrantMain.playerStillAlive && !ReentrantMain.stopPlay) {

				nextCellEnterable = false;  //
				// 	находим другую клетку, на которую перейдем в следующий ход.
				while (!nextCellEnterable) {
					if (this.playerDirection == 0) {
						horizontNextPos = horizontPos;
						verticalNextPos = verticalPos - 1;
					} else if (this.playerDirection == 1) {
						horizontNextPos = horizontPos + 1;
						verticalNextPos = verticalPos;
					} else if (this.playerDirection == 2) {
						horizontNextPos = horizontPos;
						verticalNextPos = verticalPos + 1;
					} else if (this.playerDirection == 3) {
						horizontNextPos = horizontPos - 1;
						verticalNextPos = verticalPos;
					} else {  // исключительно для дебагинга. Такого быть не должно.
						horizontNextPos = horizontPos + 1;
						verticalNextPos = verticalPos + 1;
					}
					if (verticalNextPos >= 0 && verticalNextPos < ReentrantMain.BORDSSIZE
							&& horizontNextPos >= 0 && horizontNextPos < ReentrantMain.BORDSSIZE) {
						// только внутр данного if можно проверять матрицу на занятость, иначе можем получить ошибочное обращение
						if (board[horizontNextPos][verticalNextPos].getEnterable() && !board[horizontNextPos][verticalNextPos].getNowBusy()) {
							// займем позицию
							board[horizontNextPos][verticalNextPos].setNowBusy(true);
							board[horizontNextPos][verticalNextPos].setCurrentOwner("Player");
							this.board.notify();
							nextCellEnterable = true;
						} else {
							// Если прошло меньше 500 млс - повторяем попытки
							if (System.currentTimeMillis() - lastMoveTime < 500) {
								Thread.sleep(100);
								continue;
							}

							// необходимо поменять направление движения
							this.playerDirection++;
							if (this.playerDirection >= 4) {
								this.playerDirection = 0;
							}
						}
					} else {
						// Опять же: меняем направление движения:
						this.playerDirection++;
						if (this.playerDirection >= 4) {
							this.playerDirection = 0;
						}
					}
				}
				// По идее здесь мы можем оказаться только если все нашли место куда двигаться на следующий ход
				// Не даем плееру скакать чаще чем раз в секунду
				if (System.currentTimeMillis() - lastMoveTime < 1000) {
					Thread.sleep(1000 - (System.currentTimeMillis() - lastMoveTime));
				}

				board[horizontPos][verticalPos].setNowBusy(false);
				board[horizontPos][verticalPos].setCurrentOwner(null);
				this.board.notify();
				horizontPos = horizontNextPos;
				verticalPos = verticalNextPos;
				System.out.printf("%nPlayer: %s-%s. %n", horizontPos, verticalPos);
				lastMoveTime = System.currentTimeMillis();
			}
		}
	}

	public void monsterMove(int monsterNum) throws InterruptedException {
		synchronized (this.board) {
			int horizontPos = 5;  // На данном этапе можно начинать из центра
			int verticalPos = 5;
			int horizontNextPos = 5;  // На данном этапе можно начинать из центра
			int verticalNextPos = 5;
			boolean nextCellEnterable = false;
			long lastMoveTime = ReentrantMain.startTime;
			int monsterDirection = 0;

			while (!ReentrantMain.stopPlay && ReentrantMain.playerStillAlive) {
				monsterDirection = ThreadLocalRandom.current().nextInt(0, 4);


				nextCellEnterable = false;  //
				// 	находим другую клетку, на которую перейдем в следующий ход.
				while (!nextCellEnterable) {
					if (monsterDirection == 0) {
						horizontNextPos = horizontPos;
						verticalNextPos = verticalPos - 1;
					} else if (monsterDirection == 1) {
						horizontNextPos = horizontPos + 1;
						verticalNextPos = verticalPos;
					} else if (monsterDirection == 2) {
						horizontNextPos = horizontPos;
						verticalNextPos = verticalPos + 1;
					} else if (monsterDirection == 3) {
						horizontNextPos = horizontPos - 1;
						verticalNextPos = verticalPos;
					} else {
						horizontNextPos = horizontPos + 1;
						verticalNextPos = verticalPos + 1;
					}
					if (verticalNextPos >= 0 && verticalNextPos < ReentrantMain.BORDSSIZE
							&& horizontNextPos >= 0 && horizontNextPos < ReentrantMain.BORDSSIZE) {
						// только внутр данного if можно проверять матрицу на занятость, иначе можем получить ошибочное обращение
						if (board[horizontNextPos][verticalNextPos].getEnterable() && !board[horizontNextPos][verticalNextPos].getNowBusy()) {
							// займем позицию
							board[horizontNextPos][verticalNextPos].setNowBusy(true);
							board[horizontNextPos][verticalNextPos].setCurrentOwner("Monster");
							this.board.notify();
							nextCellEnterable = true;
						} else {
							// Если прошло меньше 5.000 млс - повторяем попытки
							if (System.currentTimeMillis() - lastMoveTime < 5000) {
								Thread.sleep(100);
								continue;
							}
							// необходимо поменять направление движения
							monsterDirection = ThreadLocalRandom.current().nextInt(0, 4);
						}
					} else {
						// Опять же: меняем направление движения:
						monsterDirection = ThreadLocalRandom.current().nextInt(0, 4);
					}
				}
				// По идее здесь мы можем оказаться только если все нашли место куда двигаться на следующий ход
				// Не даем монстру скакать чаще чем раз в секунду
				if (System.currentTimeMillis() - lastMoveTime < 1000) {
					Thread.sleep(1000 - (System.currentTimeMillis() - lastMoveTime));
				}

				board[horizontPos][verticalPos].setNowBusy(false);
				board[horizontPos][verticalPos].setCurrentOwner(null);
				this.board.notify();
				horizontPos = horizontNextPos;
				verticalPos = verticalNextPos;
				System.out.printf(" Monster-%s: %s-%s. ", monsterNum, horizontPos, verticalPos);
				if (ReentrantMain.monstersCount == monsterNum) {
					System.out.println();
				}
				lastMoveTime = System.currentTimeMillis();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");
		ReentrantMain rnt = new ReentrantMain();

		// Запускаем игрока

		new Thread() {
			@Override
			public void run() {
				try {
					rnt.playerMove();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();  // */


		// Запускаем монстров а колличестве monstersCount
		//for (int ind = 1; ind <= ReentrantMain.monstersCount; ind++) {
		//	int finalInd1 = ind;
			new Thread() {
				@Override
				public void run() {
					try {
						rnt.monsterMove(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}.start();  // */
		//}
	}
}