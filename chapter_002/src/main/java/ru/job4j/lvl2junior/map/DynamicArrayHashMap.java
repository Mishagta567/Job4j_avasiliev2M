package ru.job4j.lvl2junior.map;


/**
 * Массив HashMap
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class DynamicArrayHashMap<T, K> {
    private Object[][] objects;	// Object[][0] - object, Object[][1] - HashCode
    private int tableSize = 4;	// конечно можно делать больше, но для теста этого вполне достаточно
    private int modCount = 0;
    private int fillCellCount = 0;

	public DynamicArrayHashMap() {
		this.objects = new Object[tableSize][2];      // Для тестов изначально делаем небольшую таблицу
	}

	public int getIndexFromHCode(T value) {
		return value.hashCode() % tableSize;
	}

	public boolean insert(T value, int key) {
		if (fillCellCount * 4 >= objects.length * 3) {  // т.е. если мы заполнили 3/4 массива
			sizeIncrease();
		}
		//
		boolean result = false;
		int expextIndex = (int) key % tableSize;
		if (objects[expextIndex][1] == null) {
			objects[expextIndex][1] = value.hashCode();
			objects[expextIndex][0] = value;
			result = true;
			modCount++;
			fillCellCount++;
		}
		return result;
	}

	private void sizeIncrease() {
		this.tableSize = this.tableSize * 2;
		// создаем временнй массив
		Object[][] tempObject = new Object[this.tableSize + 1][2];
		for (int indx = 0; indx < objects.length; indx++) {
			if (objects[indx][1] != null) {
				// перезаписываем во временный массив строки из существующего
				int expextedIndex = this.getIndexFromHCode((T) objects[indx][0]);
				if (tempObject[expextedIndex][1] == null) {
					tempObject[expextedIndex][1] = objects[indx][1];
					tempObject[expextedIndex][0] = objects[indx][0];
				}
			}
		}
		objects = tempObject;
	}

	public boolean remove(T value) {
		boolean result = false;
		int expectIndex = this.getIndexFromHCode(value);
		if (objects[expectIndex][1] != null && objects[expectIndex][0].equals(value)) {   // хеккод может быть НЕ уникальным  :-(
				objects[expectIndex][1] = null;
				objects[expectIndex][0] = null;
				result = true;
		}
		return result;
	}

	public boolean delete(int key) {
		boolean result = false;
		int expectIndex = (int) key % tableSize;
		if (objects[expectIndex][1] != null && (int) objects[expectIndex][1] == key) {   // хеш-коды совпадают
			objects[expectIndex][1] = null;
			objects[expectIndex][0] = null;
			result = true;
		}
		return result;
	}

	public T get(int key) {
		T result;
		result = (T) this.objects[(int) key % tableSize][0].toString();
		return result;
	}


}