package ru.job4j;

import sun.rmi.runtime.Log;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * Пример из видео Петра А.
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */

public class SQLStorageTwo {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e);
			System.exit(-1);
		}
		try {
			// open connection to database
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "raduga");

			// build query, here we get info about all databases"
			PreparedStatement st  = conn.prepareStatement("SELECT datname FROM pg_database WHERE datname = ?");
			st.setString(1, "junior003");
			// execute query
			ResultSet rs = st.executeQuery();
			// return query result
			boolean result = false;
			while (rs.next()) {
				// display table name
				System.out.println("PostgreSQL Query result: " + rs.getString("datname"));
				if (rs.getString("datname").equals("junior003")) {
					result = true;
				}
			}
			if (result) {
				System.out.println("Есть БД junior003");
			}
			conn.close();
			rs.close();
		} catch (SQLException e) {
			System.err.println(e);
			//Log.error(e.getMessage(), e);		// не хочет работать.
			System.exit(-1);
		}
	}

}