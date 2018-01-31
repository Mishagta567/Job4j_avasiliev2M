package ru.job4j.jdbc20459;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для создания XML файлов
 * @author   A_Vasiliev
 * @since    26.01.2018
 * @version  1.0.0
 */

public class EntryXML {

	private int id;
	/**		просто конструторк.
	 */
	public EntryXML(int id) {
		this.id = id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "field")
	public int getId() {
		return id;
	}

}

/**
 * Entries for JAXB
 */
@XmlRootElement(name = "entries")
class Entries {

	@XmlElement (name = "entry")
	private List<EntryXML> entries = new ArrayList<>();

	public void setEntries(List<EntryXML> entriesXML) {
		this.entries = entriesXML;
	}
}