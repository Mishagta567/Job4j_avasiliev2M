package ru.job4j.lvl2junior.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicArrayHashSetTest {
	@Test
	public void getIndexFromHCode() throws Exception {
		DynamicArrayHashSet da = new DynamicArrayHashSet();
		assertThat(da.getIndexFromHCode("E"), is(1));
		assertThat(da.getIndexFromHCode("A"), is(1));
	}

	@Test
	public void add() throws Exception {
		DynamicArrayHashSet da = new DynamicArrayHashSet();
		da.add("A");
		da.add("B");
		da.add("C");
		assertThat(da.get(da.getIndexFromHCode("A")), is("A"));
		assertThat(da.get(da.getIndexFromHCode("B")), is("B"));
		assertThat(da.get(da.getIndexFromHCode("C")), is("C"));

	}

	@Test
	public void remove() throws Exception {
		DynamicArrayHashSet da = new DynamicArrayHashSet();
		da.add("A");
		da.add("B");
		da.add("C");

		assertThat(da.getIndexFromHCode("E"), is(1));
		assertThat(da.getIndexFromHCode("A"), is(1));
		assertThat(da.remove("E"), is(false));
		assertThat(da.remove("A"), is(true));

	}

}