package ru.job4j.junior001.tree;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

/**
 * Tests {@link TreeNodeBST}.
 */
public class TreeNodeBSTTest {
	/**
	 * Tests that added value is in tree.
	 */
	@Test
	public void addedValueShouldBeInTree() {
		TreeNodeBST<Integer> tree = new TreeNodeBST<>();
		int expected = 108;
		tree.add(expected);
		assertThat(tree, hasItem(expected));
	}
}