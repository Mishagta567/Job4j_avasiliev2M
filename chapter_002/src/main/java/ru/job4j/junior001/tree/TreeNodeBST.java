package ru.job4j.junior001.tree;


import java.util.*;

/**
 * Создать cобственную реализация Binary search tree
 *
 * @author  A_Vasiliev
 * @version 10.01.2018
 * @since 0.1
 *
 *
 * С этой задачей вроде все понятно. Сделал эти два требуемых метода и все.
 *   с целью экономии времени тесты, get п все остальное не делаю.
 *   
 */
public class TreeNodeBST<E extends Comparable<E>> {
	TreeNode<E> treeNodeBST;

	public TreeNodeBST(E value) {
		this.treeNodeBST = new TreeNode((E) value);
	}

	public Node<E> getChild(Node<E> parent, E childValue) {
		List<Node<E>> parentChilds = parent.leaves();
		Node<E> tempNode = null;
		if (parentChilds.size() > 0) {	// с parentChilds == null заведомо ничего возвращать
			if (parent.compareTo(childValue) <= 0) {
				for (Node<E> lvs : parentChilds) {
					// нам нужно найти дочернее значение меньше
					if (lvs.compareTo(parent.getValue()) >= 0) {
						//
						tempNode = lvs;
						break;
					}
				}
			} else if (parent.compareTo(childValue) > 0) {
				for (Node<E> lvs : parentChilds) {
					// нам нужно найти дочернее раврное
					if (lvs.compareTo(parent.getValue()) < 0) {
						//
						tempNode = lvs;
						break;
					}
				}
			}
		}
		return tempNode;
	}

	public boolean add(E newValue) {
		boolean result = false;
		Node<E> parentNode = (Node<E>) treeNodeBST.getRoot();
		Node<E> childNode = new Node(newValue);
		boolean foundOne = false;
		if (getChild(parentNode, newValue) == null) {
			parentNode.add(childNode);
			result = true;
		} else {
			while (getChild(parentNode, newValue) != null) {
				parentNode = getChild(parentNode, newValue);
			}
			parentNode.add(childNode);
			result = true;
		}
		return result;
	}

}