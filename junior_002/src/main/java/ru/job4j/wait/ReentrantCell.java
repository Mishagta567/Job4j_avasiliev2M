package ru.job4j.wait;

/**
 * Тестовое задание. [#1108]
 * Реализовать игру бомбермен. Без графики
 *
 * @author   A_Vasiliev
 * @since    20.01.2018
 * @version  1.0.0
 *
 */


public final class ReentrantCell {
	private boolean enterable;    // если делаю final - перестают работать set...
	private boolean nowBusy;
	private String currentOwner;

	public ReentrantCell() {
		this.enterable = true;
		this.nowBusy = false;
		this.currentOwner = null;
	}

	public boolean getEnterable() {
		return enterable;
	}

	public void setEnterable(boolean enterabl) {
		this.enterable = enterabl;
	}

	public boolean getNowBusy() {
		return nowBusy;
	}

	public void setNowBusy(boolean nowBusy) {
		this.nowBusy = nowBusy;
	}

	public String getCurrentOwner() {
		return currentOwner;
	}

	public void setCurrentOwner(String currentOwner) {
		this.currentOwner = currentOwner;
	}

}