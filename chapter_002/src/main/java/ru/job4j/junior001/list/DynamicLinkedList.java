package ru.job4j.junior001.list;


import java.util.Iterator;
import java.util.LinkedList;

/**
 * Динамический массив (+ итератор, который ходит в обе стороны)
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */


public class DynamicLinkedList<T> implements Iterable<T> {

	/** Yачальный Node.
	 */
	private Node<T> head;

	/** Последний Node.
	 */
	private Node<T> tail;

	/**
	 * Счетчик элементов
	 */
	private int size = 0;

	/**
	 * Добавление Item в хвост списка.
	 *
	 * @param item -- item to add
	 */
	public void add(T item) {
		Node<T> node = new Node<>(item);
		if (this.head == null) {
			this.head = node;
		} else {
			this.connect(this.tail, node);
		}
		this.tail = node;
		this.size++;
	}

	/**
	 * Найти item по данному индексу
	 *
	 * @param index -- index of the item
	 * @return an item at the given index
	 */
	public T get(int index) {
		Node<T> node = this.getNode(index);
		if (node == null) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		return node.item;
	}

	/**
	 * Удалить Node по данному index.
	 *
	 * @param index -- where to remove element
	 */
	public void remove(int index) {
		Node<T> node = this.getNode(index);
		if (node == null) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<T> previous = node.getPrevious();
		Node<T> next = node.getNext();
		if (node == this.head) {
			this.connect(null, next);
			this.head = next;
		}
		if (node == this.tail) {
			this.connect(previous, null);
			this.tail = previous;
		}
		this.connect(previous, next);
		this.size--;
	}

	/**
	 * Соеденить два nodes между собой. Null-safe.
	 *
	 * @param first  -- previous node of the second
	 * @param second -- next node of the first
	 */
	private void connect(Node<T> first, Node<T> second) {
		if (first != null) {
			first.setNext(second);
		}
		if (second != null) {
			second.setPrevious(first);
		}
	}

	/**
	 * Найти Node c данным index.
	 *
	 * @param index -- node's index
	 * @return node at the given index
	 */
	public Node<T> getNode(int index) {
		if (index < 0) {
			return null;
		}
		Node<T> result;
		if (index < this.size / 2) {
			result = this.moveForward(this.head, index);
		} else {
			result = this.moveBackward(this.tail, this.size - index - 1);
		}
		return result;
	}

	/**
	 * Найти Node по счету nodesCount с первого Node
	 *
	 * @param start      -- where to start
	 * @param nodesCount -- nodes count to move
	 * @return reached node
	 */
	private Node<T> moveForward(Node<T> start, int nodesCount) {
		Node<T> current = start;
		for (int i = 0; i < nodesCount; i++) {
			if (current == null) {
				break;
			}
			current = current.getNext();
		}
		return current;
	}

	/**
	 * Найти Node, по счету nodesCount, считая "назад", начиная с данного node (start - Node)
	 * Moves backward by given nodes count starting from start node.
	 *
	 * @param start      -- where to start
	 * @param nodesCount -- nodes count to move
	 * @return reached node
	 */
	private Node<T> moveBackward(Node<T> start, int nodesCount) {
		Node<T> current = start;
		for (int i = 0; i < nodesCount; i++) {
			if (current == null) {
				break;
			}
			current = current.getPrevious();
		}
		return current;
	}

	/**
	 * текущий размер "листа" = count	 *
	 * @return current elements count
	 */
	public int size() {
		return this.size;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			/**
			 * Points to the current node of the list.
			 */
			private Node<T> current = DynamicLinkedList.this.head;

			@Override
			public boolean hasNext() {
				return !(this.current == null);
			}

			@Override
			public T next() {
				T result = this.current.item;
				this.current = this.current.getNext();
				return result;
			}
		};
	}

	/**
	 * Checks whether this list contains given item.
	 *
	 * @param item -- item to search
	 * @return true if item was found, false otherwise
	 */
	public boolean contains(T item) {
		boolean result = false;
		for (T current : this) {
			if (current.equals(item)) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * Represents list's node.
	 *
	 * @param <T> -- type of item
	 */
	private static class Node<T> {
		/**
		 * Stored item.
		 */
		public final T item;
		/**
		 * Previous node.
		 */
		private Node<T> previous;
		/**
		 * Next node.
		 */
		private Node<T> next;

		/**
		 * Constructs a node holding given item.
		 *
		 * @param item -- item to hold
		 */
		Node(T item) {
			this.item = item;
		}

		public Node<T> getPrevious() {
			return this.previous;
		}

		public void setPrevious(Node<T> node) {
			this.previous = node;
		}

		public Node<T> getNext() {
			return this.next;
		}

		public void setNext(Node<T> node) {
			this.next = node;
		}
	}
}