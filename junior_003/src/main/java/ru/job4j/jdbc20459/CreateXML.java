package ru.job4j.jdbc20459;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для создания XML файлов
 * @author   A_Vasiliev
 * @since    26.01.2018
 * @version  1.0.0
 */

public class CreateXML {
	//private static final Logger LOG = LoggerFactory.getLogger(PSQLState.class);
	/**
	 * Database URL.
	 */
	private final String url;
	private final String username;
	private final String pass;
	private final File fileOne;

	public CreateXML() {
		MyDB myDB = new MyDB();
		this.url = myDB.getUrl();
		this.username = myDB.getDbUserName();
		this.pass = myDB.getPass();
		this.fileOne = new File("./1.xml");
	}

	void writeFile() throws FileNotFoundException, SQLException {

		Connection conn = DriverManager.getConnection(this.url, this.username, this.pass);
		conn.setAutoCommit(false);

		Statement st = conn.createStatement();

		// Странно, почему не работает так:
		//PreparedStatement st  = conn.prepareStatement("SELECT field FROM ? ");
		//st.setString(1, " field ");
		//st.setString(1, " test ");

		ResultSet rs = st.executeQuery("SELECT field FROM test");
		//ResultSet rs = st.executeQuery();

		StringBuilder xmlText = new StringBuilder();
		xmlText.append("<entries>").append(System.getProperty("line.separator"));

		try {
			while (rs.next()) {
				xmlText.append("    <entry>").
						append(System.getProperty("line.separator")).
						append("        <field>").append(rs.getInt(1)).append("</field>").
						append(System.getProperty("line.separator")).
						append("    </entry>").append(System.getProperty("line.separator"));
			}
			xmlText.append("</entries>");
			conn.rollback();

			PrintWriter input = new PrintWriter(this.fileOne);
			input.print(xmlText.toString());
			input.close();

		} catch (SQLException e) {
			//LOG.error(e.getMessage(), e);
			System.err.println(e);
		} finally {
			try {
				assert rs != null;
				rs.close();
			} catch (SQLException e) {
				// LOG.error(e.getMessage(), e);
				System.err.println(e);
			}
			try {
				st.close();
			} catch (SQLException e) {
				// LOG.error(e.getMessage(), e);
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

	void writeFileThird() throws FileNotFoundException, SQLException {

		Connection conn = DriverManager.getConnection(this.url, this.username, this.pass);
		conn.setAutoCommit(false);
		Statement st = conn.createStatement();
		//PreparedStatement st  = conn.prepareStatement("SELECT ? FROM ?");
		//st.setString(1, "field");
		//st.setString(2, "test");

		//ResultSet rs = st.executeQuery(String.format("SELECT %s FROM %s", "field", "test"));
		ResultSet rs = st.executeQuery("SELECT field FROM test");
		//ResultSet rs = st.executeQuery();



		Entries temp = new Entries();

		List<EntryXML> entries = new ArrayList<>();
		while (rs.next()) {
			entries.add(new EntryXML(rs.getInt(1)));
		}
		temp.setEntries(entries);
		conn.rollback();

		try {
			JAXBContext context = JAXBContext.newInstance(Entries.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			marshaller.marshal(temp, new File("./3.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
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
}