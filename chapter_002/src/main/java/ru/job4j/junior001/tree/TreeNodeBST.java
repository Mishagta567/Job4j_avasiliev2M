package ru.job4j.junior001.tree;


import java.util.*;

/**
 * Создать cобственную реализация Binary search tree
 *
 * @author  A_Vasiliev
 * @version 10.01.2018
 * @since 0.1
 *
 */
public class TreeNodeBST<T extends Comparable<T>> implements Iterable<T> {
	private final NodeBST root = new NodeBST(null);

	private final Comparator<T> nullSafeComparator = Comparator.nullsFirst(Comparator.naturalOrder());

	public void add(T value) {
		this.root.addChild(value);
	}

	private class NodeBST {
		private final T value;
		private NodeBST left;
		private NodeBST right;

		private NodeBST(T value) {
			this.value = value;
		}

		private void addChild(T value) {
			if (TreeNodeBST.this.nullSafeComparator.compare(value, this.value) <= 0) {
				if (this.left == null) {
					this.left = new NodeBST(value);
				} else {
					this.left.addChild(value);
				}
			} else {
				if (this.right == null) {
					this.right = new NodeBST(value);
				} else {
					this.right.addChild(value);
				}
			}
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private final Queue<NodeBST> nodeList;

			{
				this.nodeList = new LinkedList<>(Collections.singletonList(TreeNodeBST.this.root));
				this.next();
			}

			@Override
			public boolean hasNext() {
				return !this.nodeList.isEmpty();
			}

			@Override
			public T next() {
				NodeBST current = this.nodeList.poll();
				T result = current.value;
				if (current.left != null) {
					this.nodeList.add(current.left);
				}
				if (current.right != null) {
					this.nodeList.add(current.right);
				}
				return result;
			}
		};
	}
}