package ru.job4j;

import org.junit.platform.commons.logging.LoggerFactory;
import java.sql.*;
// понятно что след. строчку нужно коментировать.
//import java.util.logging.Logger;
// А вот это наоборот. Но где нам взять пакет  org.slf4j и что с ним делать?

import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

//import org.slf4j.Logger;
import sun.rmi.runtime.Log;

/**
 * Пример из видео Петра А.
 * @author   A_Vasiliev
 * @since    26.01.2018
 * @version  1.0.0
 */

public class SQLStorage {

	//private static final Logger log = org.slf4j.LoggerFactory.getLogger(SQLStorage.class);

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/junior003";
		String username = "postgres";
		String password = "raduga";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM item it WHERE it.id > 1");
			while (rs.next())	{
				System.out.print("Column 1 returned ");
				System.out.printf("%s %s %s%n", rs.getString("name"),
						rs.getString("descr"), rs.getString("inserted_date"));
			}
			rs.close();
			st.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					//Log.error(e.getMessage(), e);
				}
			}
		}
	}

}