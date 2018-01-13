package ru.job4j.lvl2junior.tree;

import java.util.*;

/**
 * @author    A_Vasiliev
 * @version 10.01.2018
 * @since 0.1
 */
public class Node<E> implements Comparable<E> {
	private final E value;
	private final List<Node<E>> children = new ArrayList<>();

	public Node(final E value) {
		this.value = value;
	}

	public void add(Node<E> child) {
		this.children.add(child);
	}

	public List<Node<E>> leaves() {
		return this.children;
	}

	public boolean eqValue(E that) {
		return this.value.equals(that);
	}

	public E getValue() {
		return this.value;
	}

	@Override
	public int compareTo(E value) {
		return this.value.hashCode() - value.hashCode();
	}

}