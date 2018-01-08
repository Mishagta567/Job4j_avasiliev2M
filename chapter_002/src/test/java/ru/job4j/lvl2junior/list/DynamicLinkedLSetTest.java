package ru.job4j.lvl2junior.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicLinkedLSetTest {
	@Test
	public void alreadyExist() throws Exception {
		DynamicLinkedLSet<String> ss = new DynamicLinkedLSet<String>();
		ss.add("A1");
		assertThat(ss.alreadyExist("A1"), is(true));
		assertThat(ss.alreadyExist("B2"), is(false));
	}

	@Test
	public void add() throws Exception {
		DynamicLinkedLSet<String> dll = new DynamicLinkedLSet<String>();
		dll.add("A1");
		dll.add("A1");
		dll.add("A1");
		dll.add("B2");
		dll.add("C3");
		assertThat(dll.get(1), is("A1"));
		assertThat(dll.get(2), is("B2"));
		assertThat(dll.get(3), is("C3"));
	}

	@Test
	public void delete() throws Exception {
		DynamicLinkedLSet<String> dll = new DynamicLinkedLSet<String>();
		dll.add("A1");
		dll.add("B2");
		dll.add("C3");
		dll.delete(1);
		assertThat(dll.get(1), is("A1"));
		assertThat(dll.get(2), is("C3"));
	}

	@Test
	public void iterator() throws Exception {
		DynamicLinkedLSet<String> dll = new DynamicLinkedLSet<String>();

		dll.add("A1");  //  1   X1
		dll.add("B2");  //  2
		dll.add("C3");  //  3   X2
		String result = new String();

		dll.delete(dll.getForwardRealIndex(2));
		Iterator<String> it2 = dll.iterator();
		while (it2.hasNext()) {
			result = result + it2.next();
		}
		assertThat(result, is("A1C3"));
	}

}