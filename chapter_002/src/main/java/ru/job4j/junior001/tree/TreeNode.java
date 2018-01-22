package ru.job4j.junior001.tree;


import java.util.*;

/**
 * Создать элементарную структуру дерева [#1711]
 * 2. Добавить метод boolean isBinary() [#1712]
 *
 * @author  A_Vasiliev
 * @version 10.01.2018
 * @since 0.1
 */
public class TreeNode<E extends Comparable<E>> implements SimpleTree<E> {
	private Node<E> root;
	private E searchValue = null;
	private Node<E> searchNode = null;

	public void setSearchValue(E searchValue) {
		this.searchValue = searchValue;
		this.searchNode = this.root;
	}

	public TreeNode(E value) {
		this.root = new Node(value);
	}

	public Node<E> getRoot() {
		return this.root;
	}

	public Node<E> getChild(Node<E> parent, E childValue) {
		List<Node<E>> parentChilds = parent.leaves();
		Node<E> tempNode = null;
		if (parentChilds.size() > 0) {	// с parentChilds == null заведомо ничего возвращать
			if (parent.compareTo(childValue) < 0) {
				for (Node<E> lvs : parentChilds) {
					// нам нужно найти дочернее значение меньше
					if (lvs.compareTo(parent.getValue()) > 0) {
						//
						tempNode = lvs;
						break;
					}
				}
			} else if (parent.compareTo(childValue) == 0) {
				for (Node<E> lvs : parentChilds) {
					// нам нужно найти дочернее раврное
					if (lvs.compareTo(parent.getValue()) == 0) {
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

	public int checkLeaves() {
		Optional<Node<E>> rsl = Optional.empty();
		Queue<Node<E>> data = new LinkedList<>();
		int result = 0;
		int leavesAmmount;
		data.offer(this.root);
		while (!data.isEmpty()) {
			Node<E> el = data.poll();
			leavesAmmount = el.leaves().size();

			if (leavesAmmount > result) {
				result = leavesAmmount;
			}
			for (Node<E> child : el.leaves()) {
				data.offer(child);
			}
		}
		return result;
	}

		public boolean isBinary() {
			return (this.checkLeaves() <= 2);
		}


	//@Override
	public boolean add(Node<E> parent, Node<E> child) {
		boolean result = false;
		String testStr = null;
		Node<E> parentNode = (Node<E>) parent;
		Node<E> childNode = (Node<E>) child;
		boolean foundOne = false;
		if (getChild(parentNode, childNode.getValue()) == null) {
			parentNode.add(childNode);
			result = true;
		} else {

			while (getChild(parentNode, childNode.getValue()) != null) {
				parentNode = getChild(parentNode, childNode.getValue());
			}
			parentNode.add(childNode);
			testStr = "К " + parentNode.getValue() + " лепим " + childNode.getValue();
			result = true;
		}
		return result;
	}

	@Override
	public Iterator iterator() {
		return new TreeNode.DnmcIterator();
	}

	public class DnmcIterator implements Iterator<E> {

		@Override
		public boolean hasNext() {
			return (TreeNode.this.searchValue != null
				&& getChild(TreeNode.this.searchNode, TreeNode.this.searchValue) != null);  // false;
		}

		@Override
		public E next() {
			Node<E> resultNode = TreeNode.this.searchNode;
			TreeNode.this.searchNode = getChild(TreeNode.this.searchNode, TreeNode.this.searchValue);
			return resultNode.getValue();
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> treeN = new TreeNode<Integer>(100);
		//System.out.println(treeN.checkLeaves());
		treeN.add(treeN.getRoot(), new Node<Integer>(200));
		//System.out.println(treeN.checkLeaves());
		treeN.add(treeN.getRoot(), new Node<Integer>(150));
		System.out.println(treeN.checkLeaves());
	}

	@Override
	public boolean add(E parent, E child) {
		return false;
	}

	//**
	@Override
	public Optional<Node<E>> findBy(E value) {
		Optional<Node<E>> rsl = Optional.empty();
		Queue<Node<E>> data = new LinkedList<>();
		data.offer(this.root);
		while (!data.isEmpty()) {
			Node<E> el = data.poll();
			if (el.eqValue(value)) {
				rsl = Optional.of(el);
				break;
			}
			for (Node<E> child : el.leaves()) {
				data.offer(child);
			}
		}
		return rsl;
	} //*/

}