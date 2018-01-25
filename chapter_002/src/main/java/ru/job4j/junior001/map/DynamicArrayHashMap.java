package ru.job4j.junior001.map;


import java.util.Iterator;

/**
 * Массив HashMap
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

class Node<K, V> {
	K key;
	V value;
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return key.hashCode();
	}

}


public class DynamicArrayHashMap<K, V> implements Iterator<V> {
    private Node[] objects;	// Object[] - object
    //private int tableSize = 4;	// конечно можно делать больше, но для теста этого вполне достаточно
    private int modCount = 0;
    private int fillCellCount = 0;


	public DynamicArrayHashMap() {
		this.objects = new Node[4];      // Для тестов изначально делаем небольшую таблицу
	}

	public int getIndexFromHCode(K key) {
		return Math.abs((key.hashCode()) % this.objects.length);
	}

	public boolean insert(K key, V value) {
		if (fillCellCount * 4 >= objects.length * 3) {  // т.е. если мы заполнили 3/4 массива
			sizeIncrease();
		}
		//
		boolean result = false;
		int expextIndex = getIndexFromHCode(key);
		if (objects[expextIndex] == null) {
			 objects[expextIndex] = new Node(key, value);
			result = true;
			modCount++;
			fillCellCount++;
		}
		return result;
	}

	private void sizeIncrease() {
		// создаем временнй массив
		Node[] tempObject = new Node[this.objects.length * 2];
		for (int indx = 0; indx < objects.length; indx++) {
			if (objects[indx] != null) {
				// перезаписываем во временный массив строки из существующего
				// тут могут быть сложности c индексами....
				//
				int expextedIndex = this.getIndexFromHCode((K) objects[indx].getKey());
				if (tempObject[expextedIndex] == null) {
					 tempObject[expextedIndex] = objects[indx];
				}
			}
		}
		objects = tempObject;
	}

	public boolean delete(K key) {
		boolean result = false;
		int expectIndex = getIndexFromHCode(key);
		if (objects[expectIndex] != null) {   // хеш-коды совпадают
			objects[expectIndex] = null;
			result = true;
			fillCellCount--;
			modCount++;
		}
		return result;
	}

	public V get(K key) {
		V result = null;
		if (this.objects[getIndexFromHCode(key)] != null) {
			result = (V) this.objects[getIndexFromHCode(key)];
		}
		return result;
	}

	int itrIndex = 0;
	int itrCount = 0;
	@Override
	public boolean hasNext() {
		return (itrCount <= this.fillCellCount);
	}

	@Override
	public V next() {
		V result = null;

		while (this.objects[itrIndex] == null && itrCount <= this.fillCellCount && itrIndex < this.objects.length) {
			itrIndex++;
		}
		if (this.objects[itrIndex] != null) {
			result = (V) this.objects[itrIndex].getValue();
			itrCount++;
			itrIndex++;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("YO");
	}

}