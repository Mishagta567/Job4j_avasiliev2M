package ru.job4j.lvl2junior.list;

import org.junit.Test;
import ru.job4j.junior001.list.SimpleSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
	@Test
	public void alreadyExist() throws Exception {
		SimpleSet<String> ss = new SimpleSet<String>();
		ss.add("A1");
		assertThat(ss.alreadyExist("A1"), is(true));
		assertThat(ss.alreadyExist("B2"), is(false));
	}

	@Test
	public void add() throws Exception {
		SimpleSet<String> smplSet = new SimpleSet<String>();
		smplSet.add("A1");
		smplSet.add("A1");
		smplSet.add("A1");
		smplSet.add("B2");
		assertThat(smplSet.get(0), is("A1"));
		assertThat(smplSet.get(1), is("B2"));
	}

	@Test
	public void delete() throws Exception {
		SimpleSet<String> smplSet = new SimpleSet<String>();
		smplSet.add("A1");
		smplSet.add("B2");
		smplSet.add("C3");
		smplSet.add("D4");
		assertThat(smplSet.get(0), is("A1"));
		smplSet.delete(0);
		assertThat(smplSet.get(0), is("B2"));
		smplSet.delete(0);
		assertThat(smplSet.get(0), is("C3"));
	}

}