package ru.job4j.junior001.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests SimpleQueue
 */
public class SimpleQueueTest {
	/**
	 * Первый вошел, первый вышел
	 */
	@Test
	public void getedItemsShouldBeInSameOrder() {
		int[] items = new int[] {0, 1, 2, 3};
		int[] expected = new int[] {0, 1, 2, 3};
		SimpleQueue<Integer> queue = new SimpleQueue<>();
		for (int i : items) {
			queue.add(i);
		}
		int[] actual = new int[items.length];
		for (int i = 0; i < items.length; i++) {
			actual[i] = queue.get();
		}
		assertThat(actual, is(expected));
	}
}