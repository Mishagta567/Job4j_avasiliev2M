package ru.job4j.jdbc20459;

/**
 * Пример из видео Петра А.
 * @author   A_Vasiliev
 * @since    26.01.2018
 * @version  1.0.0
 */

public class MyDB {
	private static final String URL = "jdbc:postgresql://localhost:5432/junior003";
	private static final String USERNAME = "postgres";
	private static final String PASS = "raduga";

	public String getUrl() {
		return URL;
	}

	public String getDbUserName() {
		return USERNAME;
	}

	public String getPass() {
		return PASS;
	}

}