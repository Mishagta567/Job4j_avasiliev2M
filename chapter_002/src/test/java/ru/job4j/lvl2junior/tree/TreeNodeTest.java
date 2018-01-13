package ru.job4j.lvl2junior.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.Optional;
import java.util.TreeMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TreeNodeTest {

	@Test
	public void getChild() throws Exception {
	}

	@Test
	public void add() throws Exception {
		TreeNode<Integer> treeN = new TreeNode<Integer>(100);
		assertThat((treeN.getChild(treeN.getRoot(), 300) == null), is(true));
		treeN.add(treeN.getRoot(), new Node<Integer>(200));
		assertThat((treeN.getChild(treeN.getRoot(), 300) == null), is(false));
	}

	@Test
	public void findBy() throws Exception {
		TreeNode<Integer> treeN = new TreeNode<Integer>(100);
		boolean rslt = treeN.findBy(new Node(250)).equals(Optional.empty());
		assertThat(rslt, is(true));
		treeN.add(treeN.getRoot(), new Node<Integer>(200));
		rslt = treeN.findBy(new Node(250)).equals(Optional.empty());
		assertThat(rslt, is(false));
	}

	@Test
	public void iterator() throws Exception {
		TreeNode<Integer> treeN = new TreeNode<Integer>(100);
		treeN.setSearchValue(250);
		Iterator<String> it = treeN.iterator();
		//assertThat(it.hasNext(), is(false));
		treeN.add(treeN.getRoot(), new Node<Integer>(200));
		assertThat(it.hasNext(), is(true));
		assertThat(it.next(), is(100));
		assertThat(it.next(), is(200));
	}

}