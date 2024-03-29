package ru.job4j.junior001.list;


/**
 * Простой массив
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class DynamicArrayHashSet {
    private Object[] objects;	// Object[] - object
    //private int tableSize = 4;	// конечно можно делать больше, но для теста этого вполне достаточно
    private int modCount = 0;
    private int fillCellCount = 0;

	public DynamicArrayHashSet() {
		this.objects = new Object[4];      // Для тестов изначально делаем небольшую таблицу
	}

	public int getIndexFromHCode(Object value) {
		return Math.abs((value.hashCode()) % objects.length);
	}

	public boolean add(String value) {
		if (fillCellCount * 4 >= objects.length * 3) {  // т.е. если мы заполнили 3/4 массива
			sizeIncrease();
		}

		boolean result = false;
		int expextIndex = this.getIndexFromHCode(value);
		if (objects[expextIndex] == null) {
			objects[expextIndex] = value;
			result = true;
			modCount++;
			fillCellCount++;
		}
		return result;
	}

	private void sizeIncrease() {
		// создаем временнй массив
		Object[] tempObject = new Object[this.objects.length * 2];
		for (int indx = 0; indx < objects.length; indx++) {
			if (objects[indx] != null) {
				// перезаписываем во временный массив строки из существующего
				// тут могут быть сложности c индексами....
				int expextIndex = this.getIndexFromHCode(objects[indx]);
				if (tempObject[expextIndex] == null) {
					tempObject[expextIndex] = objects[indx];
				}
			}
		}
		objects = tempObject;
	}

	public boolean remove(Object value) {
		boolean result = false;
		int expectIndex = this.getIndexFromHCode(value);
		if (objects[expectIndex] != null) { //&& objects[expectIndex].equals(value)) {   // хеккод может быть НЕ уникальным  :-(
				objects[expectIndex] = null;
				result = true;
		}
		return result;
	}

	public Object get(int realIndex) {
		Object result;
		result =  this.objects[realIndex];
		return result;
	}

}