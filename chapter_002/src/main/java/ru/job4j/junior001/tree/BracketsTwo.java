package ru.job4j.junior001.tree;

import java.util.Stack;

/**
 *  Тестовое задание на алгоритмы. В2
 *
 * @author    A_Vasiliev
 * @version 13.01.2018
 * @since 0.1
 */

public class BracketsTwo {
	private Stack<Bracket> bracketsList = new Stack<Bracket>();
	private Stack<Bracket> resultList = new Stack<Bracket>();

	public BracketsTwo(String testString) {
		for (int index = 0; index < testString.length(); index++) {
			bracketsList.push(new Bracket(testString.charAt(index), index));
		}

	}

	public boolean checkList() {
		boolean result = false;
		// проверяем только если у нас четное число знаков
		Bracket firstBr = null;
		Bracket secondBr = null;
		Stack<Bracket> tempList = new Stack<Bracket>();
		if (bracketsList.size() % 2 == 0 && bracketsList.size() >= 2) {

			while (!bracketsList.isEmpty()) {
				if (secondBr == null) {
					secondBr = bracketsList.pop();
				}
				if (firstBr == null) {
					firstBr = bracketsList.pop();
				}

				if (firstBr.compareTo(secondBr) == 0) {
					resultList.push(firstBr);
					resultList.push(secondBr);
					firstBr = null;
					secondBr = null;
					// возвращаем все в стек:
					if (!tempList.isEmpty()) {
						while (!tempList.isEmpty()) {
							firstBr = tempList.pop();
							bracketsList.push(firstBr);
						}
						firstBr = null;
						continue;
					}
				} else {
					tempList.push(secondBr);
					if (!bracketsList.isEmpty()) {
						secondBr = firstBr;
						firstBr = bracketsList.pop();
					}
				}
			}
		}
		if (tempList.isEmpty()) {
			result = true;
			result = true;
		}
		return result;
	}



	class Bracket implements Comparable {
		char value;
		int position;

		public Bracket(char value, int postion)  {
			this.value = value;
			this.position = postion;
		}
		public char getValue() {
			return value;
		}
		public int getPosition() {
			return position;
		}

		@Override
		public int compareTo(Object o) {
			int result = -1;
			Bracket br = (Bracket) o;
			if (this.value == '(' && br.getValue() == ')') {
				result = 0;
			} else if (this.value == '{' && br.getValue() == '}') {
				result = 0;
			} else if (this.value == '[' && br.getValue() == ']') {
				result = 0;
			}
			return result;
		}
	}

}