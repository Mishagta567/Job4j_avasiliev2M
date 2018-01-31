package ru.job4j.jdbc20459;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс для ConvertingXML. Должен конвертировать xml используя xsl template
 * @author   A_Vasiliev
 * @since    26.01.2018
 * @version  1.0.0
 */

public class ConvertingXML {

	private int sum = 0;
	private final File styleXSL = new File("./styles.xsl");
	private final File fileTwo = new File("./2.xml");

	public int getSum() {
		return sum;
	}

	public void converting(String file) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Source xslt = new StreamSource(this.styleXSL);
			Transformer transformer = transformerFactory.newTransformer(xslt);
			Source original = new StreamSource(file);
			transformer.transform(original, new StreamResult(this.fileTwo));
		} catch (TransformerException te) {
			te.printStackTrace();
		}
	}

	/**
	 * line reading of a file.
	 * getting the sun of all the numbers in the file
	 * @throws FileNotFoundException - file not find
	 */
	protected void readFile() throws FileNotFoundException {
		try (BufferedReader br = new BufferedReader(new FileReader(this.fileTwo))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("    <entry ")) {
					this.sum += this.parse(line);
				}
			}
		}
		catch (IOException e) {
			System.out.println("file not find");
		}
	}

	/**
	 * finding Integer class variable in one line.
	 * @param text - the one line
	 * @return the number of this line
	 */
	private int parse(final String text) {
		boolean start = false;
		int pos = 0;
		String values = "";
		for (int i = 0; i != text.length(); ++i) {
			if (text.charAt(i) == '\"') {
				if (start) {
					values = text.substring(pos + 1, i);
					start = false;
				} else {
					start = true;
				}
				pos = i;
			}
		}
		return Integer.parseInt(values);
	}

	/**
	 * reading an XML file using DOMBuilder, StAX parser and SAXParser.
	 * @return the sum or elements from file "./2.xml"
	 */

	protected int parseTwo() {
		int sum = 0;
		SAXBuilder saxBuilder = new SAXBuilder();
		File xmlFile = new File("./2.xml");
		try {
			Document document = saxBuilder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List<Element> staffList = rootNode.getChildren("entry");
			for (Element nextStaff : staffList) {
				sum += Integer.parseInt(nextStaff.getAttributeValue("field"));
			}
		} catch (JDOMException | IOException ex) {
			Logger.getLogger(ConvertingXML.class.getName())
					.log(Level.SEVERE, null, ex);
		}
		return sum;
	}
}