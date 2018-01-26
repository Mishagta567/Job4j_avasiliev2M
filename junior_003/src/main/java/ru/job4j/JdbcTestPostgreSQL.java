package ru.job4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.SQLException;

/**
 * Пример из видео Петра А.
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */

public class JdbcTestPostgreSQL {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e);
			System.exit(-1);
		}
		try {
			// open connection to database
			Connection connection = DriverManager.getConnection(
					//"jdbc:postgresql://dbhost:port/dbname", "user", "dbpass");
					"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "raduga");

			// build query, here we get info about all databases"
			String query = "SELECT datname FROM pg_database WHERE datistemplate = false";

			// execute query
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			// return query result
			while (rs.next()) {
				// display table name
				System.out.println("PostgreSQL Query result: " + rs.getString("datname"));
			}
			connection.close();
			rs.close();
		} catch (java.sql.SQLException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}

}