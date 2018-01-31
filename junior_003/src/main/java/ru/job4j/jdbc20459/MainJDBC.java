package ru.job4j.jdbc20459;


import org.postgresql.util.PSQLState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.sql.*;

/**
 * Класс собирает всю задачу
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class MainJDBC {

	/**
	 * Database URL.
	 */
	private final String url;
	private final String username;
	private final String pass;
	private int amount;

	public MainJDBC(int amount) {
		MyDB myDB = new MyDB();
		this.url = myDB.getUrl();
		this.username = myDB.getDbUserName();
		this.pass = myDB.getPass();
		this.amount = amount;
	}

	protected int start() throws SQLException, FileNotFoundException {

		CheckTestTable checjTestTable = new CheckTestTable(this.amount);
		try {
			checjTestTable.createTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		CreateXML createXML = new CreateXML();
		createXML.writeFile();
		ConvertingXML convert = new ConvertingXML();
		convert.converting("./1.xml");
		convert.readFile();
		return convert.getSum();
	}

}