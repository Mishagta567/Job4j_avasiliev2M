package ru.job4j.lvl2junior.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *  Тестовое задание на алгоритмы
 *
 * @author    A_Vasiliev
 * @version 13.01.2018
 * @since 0.1
 */
public class Brackets {
	private String testString;
	private List<OneBracket> bracketsList = new ArrayList<OneBracket>();
	private String validORNot; // Valid  / NotValid
	int firstNotValidCharPos;
	char firstNotValidChar;

	public Brackets(String testString) {
		for (int index = 0; index < testString.length(); index++) {
			bracketsList.add(new OneBracket(testString.charAt(index)));
		}

	}

	private boolean itIsCouple(char thisChar, char testChar) {
		boolean result = false;
		if ((thisChar == '(' && testChar == ')')
		 || (thisChar == '{' && testChar == '}')
		 || (thisChar == '[' && testChar == ']')) {
			result = true;
		}
		return result;
	}

	public boolean validate() {
		boolean result = false;
		boolean thereIsUnchecked = true;
		int lngth = this.bracketsList.size();
		OneBracket firstBr = null;
		OneBracket nextBr = null;
		char firstChar;
		char nextChar;

		int count = 0;  // страховка на случай зацикливания в loop-ах


		while (thereIsUnchecked && count < 1000) {
			count++;
			if (count >= 500) {
				count++;
			}
			if (count >= 1000) {
				this.validORNot = "count: " + count;
			}
			thereIsUnchecked = false;
			for (int indx = 0; indx < lngth - 1; indx++) {
				firstBr = this.bracketsList.get(indx);
				if (firstBr.getValid().equals("Valid")) {
					if (indx < lngth - 2) {
						thereIsUnchecked = true;
					} else {
						thereIsUnchecked = false;
					}
					continue;
				} else if (firstBr.getValid().equals("NotValid")) {
					break;		// если есть хоть одна заведом Не-валидная позиция - можно дальше не проверять.
				}
				firstChar = firstBr.getBracket();
				if (firstChar != '(' && firstChar != '{' && firstChar != '['
				 && firstChar != ')' && firstChar != '}' && firstChar != ']') {
					thereIsUnchecked = true;
					continue;		//   проверяем только 1 из 6
				}
				if (firstChar == ')' || firstChar == '}' || firstChar == ']') {
					firstBr.setValid("NotValid");
					this.bracketsList.set(indx, firstBr);
					this.firstNotValidCharPos = indx;
					this.firstNotValidChar = firstChar;
					this.validORNot = "NotValid";
					break;
				}
				result = false;


				for (int nextIndx = indx + 1; nextIndx < lngth; nextIndx++) {
					nextBr = this.bracketsList.get(nextIndx);
					nextChar = nextBr.getBracket();
					if (nextBr.getValid().equals("Valid")) {
						//nextIndx++;
						continue;
					}
					if (nextChar == '(' || nextChar == '{' || nextChar == '[') {
						//indx++;
						thereIsUnchecked = true;
						break;
					}
					if (this.itIsCouple(firstBr.getBracket(), nextBr.getBracket())) {
						firstBr.setValidCouplePosition(nextIndx);
						nextBr.setValidCouplePosition(indx);
						firstBr.setValid("Valid");
						nextBr.setValid("Valid");
						this.bracketsList.set(indx, firstBr);
						this.bracketsList.set(nextIndx, nextBr);
						indx = 0;
						thereIsUnchecked = true;
						result = true;
						this.validORNot = "Valid";
						break;
					} else if (nextChar == ')' || nextChar == '}' || nextChar == ']') {
						// если это закрывающая скобка, но не подошла нам -
						firstBr.setValid("NotValid");
						this.bracketsList.set(indx, firstBr);
						this.firstNotValidCharPos = indx;
						this.firstNotValidChar = nextChar;
						this.validORNot = "NotValid";
						break;
					}
				}
				if (indx == lngth - 2) {		// если мы дошли сюда, зачит все закончили.
					break;
				}
			}
		}
		return result;
	}

	public String getResult() {
		String result = null;
		this.validate();
		if (this.validORNot.equals("Valid")) {
			for (int ind = 0; ind < this.bracketsList.size(); ind++) {
				if (this.bracketsList.get(ind).getType().equals("open")) {
					if (ind == 0) {
						result = String.valueOf(this.bracketsList.get(ind).getBracket());
					} else {
						result = result + String.valueOf(this.bracketsList.get(ind).getBracket());
					}
					result = result + ": " + ind + "+" + this.bracketsList.get(ind).getValidCouplePosition() + " ";
				}
			}
		} else {
			result = "Строка не валидна. Первая пробленая скобка: " + this.firstNotValidChar
					+ "на " + this.firstNotValidCharPos + " позиции";
		}
		return result;
	}



	public static void main(String[] args) {

		Brackets brc = new Brackets("({[]})[]");
		System.out.println("результат: " + brc.validate());
		System.out.println(brc.validORNot + brc.firstNotValidCharPos + brc.firstNotValidChar);
		String result = null;

		//result = getResult();

		for (int ind = 0; ind < brc.bracketsList.size(); ind++) {
			if (ind == 0) {
				result = ind + ": " + String.valueOf(brc.bracketsList.get(ind).getBracket());
			}	else {
				result = result + ind + ": " + String.valueOf(brc.bracketsList.get(ind).getBracket());
			}
		}
		System.out.println(result);

		for (int ind = 0; ind < brc.bracketsList.size(); ind++) {
			if (ind == 0) {
				result = ind + ": " + brc.bracketsList.get(ind).getValid();
			} else {
				result = result + ind + ": " + brc.bracketsList.get(ind).getValid();
			}
		}
		System.out.println(result);

		for (int ind = 0; ind < brc.bracketsList.size(); ind++) {
			if (ind == 0) {
				result = ind + ": " + brc.bracketsList.get(ind).getType();
			}	else {
				result = result + ind + ": " + brc.bracketsList.get(ind).getType();
			}
		}
		System.out.println(result);

		for (int ind = 0; ind < brc.bracketsList.size(); ind++) {
			if (ind == 0) {
				result = ind + ": " + String.valueOf(brc.bracketsList.get(ind).getValidCouplePosition());
			}	else {
				result = result + ind + ": " + brc.bracketsList.get(ind).getValidCouplePosition();
			}
		}
		System.out.println(result); //  */

	}


}