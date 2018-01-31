package ru.job4j.jdbc20459;


import org.postgresql.util.PSQLState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Класс проверяет наличие таблицы,
 * @author   A_Vasiliev
 * @since    26.01.2018
 * @version  1.0.0
 */


public class CheckTestTable {

	private static final Logger LOG = LoggerFactory.getLogger(PSQLState.class);
	/**
	 * Database URL.
	 */
	private final String url;
	private final String username;
	private final String pass;
	private int amount;

	public CheckTestTable(int amount) {
		MyDB myDB = new MyDB();
		this.url = myDB.getUrl();
		this.username = myDB.getDbUserName();
		this.pass = myDB.getPass();
		this.amount = amount;
	}

	public void createTable() throws SQLException {
		Connection conn = DriverManager.getConnection(this.url, this.username, this.pass);
		ResultSet rs = null;
		try {
			rs = conn.getMetaData().getTables(
					null, null, "test", null);
			if (rs.next()) {
				PreparedStatement st  = conn.prepareStatement("TRUNCATE TABLE test");
				st.executeUpdate();
			} else {
				PreparedStatement st  = conn.prepareStatement("CREATE TABLE test (field INTEGER )");
				st.execute();
			}

			this.fillingTable(conn);

		} catch (SQLException e) {
		   // Полезности, которые у меня пока почему-то генерируют ошибку.
			//LOG.error(e.getMessage(), e);
			System.err.println(e);
		} finally {
			try {
				//if (rs != null)
				assert rs != null;
					rs.close();
			} catch (SQLException e) {
				//LOG.error(e.getMessage(), e);
				System.err.println(e);
			}
			try {
				conn.close();
			} catch (SQLException e) {
				//LOG.error(e.getMessage(), e);
				System.err.println(e);
			}
		}
	}

	private void fillingTable(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		conn.setAutoCommit(false);
		try {
			ps = conn.prepareStatement("INSERT INTO test (field) VALUES (?)");
			for (int index = 1; index <= this.amount; index++) {
				ps.setInt(1, index);
				ps.addBatch();
			}
			ps.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			//LOG.error(e.getMessage(), e);
			System.err.println(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					//LOG.error(e.getMessage(), e);
					System.err.println(e);
				}
			}
			System.out.println("Таблица \'test\' по идее должна быть заполнена");
		}
	}

	public static void main(String[] args) throws SQLException {
		int rslt = 1000;
		CheckTestTable checkTestTable = new CheckTestTable(rslt);
		checkTestTable.createTable();
	}
}