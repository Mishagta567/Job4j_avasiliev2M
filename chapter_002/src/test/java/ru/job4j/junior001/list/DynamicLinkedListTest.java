package ru.job4j.junior001.list;



import org.junit.Test;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests LinkedList.
 */
public class DynamicLinkedListTest {
	/**
	 * Tests that added items in the list.
	 */
	@Test
	public void addedItemsShouldBeInList() {
		DynamicLinkedList<Integer> list = new DynamicLinkedList<>();
		int expected = 0;
		list.add(expected);
		assertThat(list.get(0), is(expected));
	}

	/**
	 * Tests that removed items not in the list.
	 */
	@Test
	public void removedItemsShouldBeNotInList() {
		DynamicLinkedList<Integer> list = new DynamicLinkedList<>();
		int expected = 0;
		list.add(expected);
		list.remove(0);
		assertThat(list, is(emptyIterable()));
	}

	/**
	 * Tests that list is iterable.
	 */
	@Test
	public void listShouldBeIterable() {
		Integer[] expected = new Integer[] {0, 1, 2, 3};
		DynamicLinkedList<Integer> list = new DynamicLinkedList<>();
		for (Integer i : expected) {
			list.add(i);
		}
		assertThat(list, contains(expected));
	}
}