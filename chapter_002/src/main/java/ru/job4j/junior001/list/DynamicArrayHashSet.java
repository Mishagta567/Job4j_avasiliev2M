package ru.job4j.junior001.list;


/**
 * Простой массив
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class DynamicArrayHashSet {
    private Object[][] objects;	// Object[][0] - object, Object[][1] - HashCode
    private int tableSize = 4;	// конечно можно делать больше, но для теста этого вполне достаточно
    private int modCount = 0;
    private int fillCellCount = 0;

	public DynamicArrayHashSet() {
		this.objects = new Object[tableSize][2];      // Для тестов изначально делаем небольшую таблицу
	}

	public int getIndexFromHCode(String str) {
		return str.hashCode() % tableSize;
	}

	public boolean add(String value) {
		if (fillCellCount * 4 >= objects.length * 3) {  // т.е. если мы заполнили 3/4 массива
			sizeIncrease();
		}

		boolean result = false;
		int expextIndex = this.getIndexFromHCode(value);
		if (objects[expextIndex][1] == null) {
			objects[expextIndex][0] = value;
			objects[expextIndex][1] = value.hashCode();
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
				int expextIndex = this.getIndexFromHCode((String) objects[indx][0]);
				if (tempObject[expextIndex][1] == null) {
					tempObject[expextIndex][0] = objects[indx][0];
					tempObject[expextIndex][1] = objects[indx][1];
				}
			}
		}
		objects = tempObject;
	}

	public boolean remove(String value) {
		boolean result = false;
		int expectIndex = this.getIndexFromHCode(value);
		if (objects[expectIndex][1] != null && objects[expectIndex][0].equals(value)) {   // хеккод может быть НЕ уникальным  :-(
				objects[expectIndex][1] = null;
				objects[expectIndex][0] = null;
				result = true;
		}
		return result;
	}

	public String get(int realIndex) {
		String result;
		result = (String) this.objects[realIndex][0].toString();
		return result;
	}

	public static void main() {
		DynamicArrayHashSet da = new DynamicArrayHashSet();
		da.add("A");
		da.add("B");
		da.add("C");
		da.add("D");
	}

}