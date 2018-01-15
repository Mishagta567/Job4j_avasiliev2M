package ru.job4j.lvl2junior.tree;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BracketsTest {
	@Test
	public void validate() throws Exception {
		Brackets brOne = new Brackets("({[]})[]");
		assertThat(brOne.validate(), is(true));

		Brackets brTwo = new Brackets("({[]}[)]");
		assertThat(brTwo.validate(), is(false));
	}

	@Test
	public void getResult() throws Exception {
		Brackets brOne = new Brackets("({[]})[]");
		assertThat(brOne.getResult(), is("(: 0+5 {: 1+4 [: 2+3 [: 6+7 "));
	}

}