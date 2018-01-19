package ru.job4j.junior001.tree;

/**
 *  Тестовое задание на алгоритмы. Один символ
 *
 * @author    A_Vasiliev
 * @version 13.01.2018
 * @since 0.1
 */
public class OneBracket {
	private char bracket;
	private int validCouplePosition;
	private String type;  // тип: "open" - открывающая, "close" - закрывающая.
	private String valid; // валидность: ? - не известно, NotValid - не валидна, Valid - валидна

	public OneBracket(char bracket) {
		this.bracket = bracket;
		this.validCouplePosition = 0;
		this.type = calcType(bracket);
		this.valid = "?";
	}

	public String calcType(char bracket) {
		String result = "?";
		if (bracket == '(' || bracket == '{' || bracket == '[') {
			result = "open";
		} else if (bracket == ')' || bracket == '}' || bracket == ']') {
			result = "close";
		} else {
			result = "?";
		}
		return result;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public int getValidCouplePosition() {
		return this.validCouplePosition;
	}

	public void setValidCouplePosition(int validCouplePosition) {
		this.validCouplePosition = validCouplePosition;
	}

	public char getBracket() {
		return this.bracket;
	}


}