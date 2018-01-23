package ru.job4j.synchroniz;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class CheckFileTest {

	@Test
	public void CheckFileTrue() throws Exception {
		CheckFile ofl = new CheckFile("C:\\projects\\avasiliev2\\junior_002\\src\\main\\java\\ru\\job4j\\synchroniz\\ParallerSearch.java");
		//System.out.println(ofl.checkFile("ParallerSearch"));
		assertThat(ofl.checkFile("ParallerSearch"), is(true));
	}

	@Test
	public void checkFileFalse() throws Exception {
		CheckFile ofl = new CheckFile("C:\\projects\\avasiliev2\\junior_002\\src\\main\\java\\ru\\job4j\\synchroniz\\ParallerSearch.java");
		//System.out.println(ofl.checkFile("ParallerSearch"));
		assertThat(ofl.checkFile("Dadada34534"), is(false));
	}


}