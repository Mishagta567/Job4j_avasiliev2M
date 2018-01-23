package ru.job4j.junior001.tree;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class BracketsTwoTest {

	@Test
	public void checkListWHenTrue() throws Exception {
		BracketsTwo br = new BracketsTwo("[{([])}][]");
		//System.out.println(br.checkList());
		assertThat(br.checkList(), is(true));
	}

	@Test
	public void checkListWHenFalse() throws Exception {
		BracketsTwo br = new BracketsTwo("[{]}");
		//System.out.println(br.checkList());
		assertThat(br.checkList(), is(false));
	}

}