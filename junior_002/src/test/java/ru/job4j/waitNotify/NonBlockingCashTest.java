package ru.job4j.waitNotify;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NonBlockingCashTest {

	@Test
	public void add() throws Exception {
		Model modelIvan = new Model("Ivan");
		NonBlockingCash map = new NonBlockingCash();
		map.add(1, modelIvan);
		//System.out.println();
		assertThat(map.getModel(1).getName(), is("Ivan"));
	}

	@Test
	public void delete() throws Exception {
		Model modelIvan = new Model("Ivan");
		Model modelJhon = new Model("Jhon");
		NonBlockingCash map = new NonBlockingCash();
		map.add(1, modelIvan);
		map.delete(1);
		map.add(1, modelJhon);
		assertThat(map.getModel(1).getName(), is("Jhon"));
	}

	@Test
	public void update() throws Exception {
		Model modelIvan = new Model("Ivan");
		NonBlockingCash map = new NonBlockingCash();
		map.add(1, modelIvan);
		Model modelJhon = new Model("Jhon");

		assertThat(map.getModel(1).getName(), is("Ivan"));
		assertThat(map.getModel(1).getVersion(), is(0));
		map.update(1, modelJhon);
		assertThat(map.getModel(1).getName(), is("Jhon"));
		assertThat(map.getModel(1).getVersion(), is(1));

	}

}