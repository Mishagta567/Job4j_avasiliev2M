package ru.job4j.jdbc20459;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class MainJDBCTest {
	private int amount = 1000;
	private int expected = amount * (amount + 1) / 2;

	/**
	 * Test1.
	 * class UnionXML.
	 * create table "test" and filling the table.
	 * getting the sun of all the numbers in the table
	 */
	@Test
	public void whenDataBaseCreateThenTableTest() throws SQLException, FileNotFoundException {
		MainJDBC mainJDBC = new MainJDBC(amount);
		int result = mainJDBC.start();

		//System.out.format("result: %s %s \n", result, Expected);
		assertThat(result, is(expected));
	}


}