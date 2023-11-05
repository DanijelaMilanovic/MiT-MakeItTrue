/***********************************************************************
 * Module:  ApplicationProperty.java
 * Author:  G1
 ***********************************************************************/

package model;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**Klasa za definisanje modela aplikacije.
 *  Sadrži sve metode koje postavlja interfejs za stanja aplikacije koje se pozivaju kroz ovu klasu.
 *  Kao I predefinisane sve metode iz interfejsa kog implementira.**/
public class ApplicationProperty {
	private Dimension dimension;
	private String language;
	private int state;

	private PropertyParserStrategy parser;

	public Dimension getDimension() {
		return dimension;
	}

	/** @param newDimension */
	public void setDimension(Dimension newDimension) {
		dimension = newDimension;
	}

	public String getLanguage() {
		return language;
	}

	/** @param newLanguage */
	public void setLanguage(String newLanguage) {
		language = newLanguage;
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public PropertyParserStrategy getParser() {
		return parser;
	}

	public void setParser(PropertyParserStrategy parser) {
		this.parser = parser;
	}

	public ApplicationProperty(String type) {
		switch (type) {
		case "XML":
			parser = new XMLPropertyStrategy();
			break;
		}
		HashMap<String, String> properties = parser.parse();

		setLanguage(properties.get("language"));
		setDimension(
				new Dimension(Integer.parseInt(properties.get("width")), Integer.parseInt(properties.get("height"))));
		setState(Integer.parseInt(properties.get("extended_state")));
	}
	/**Metoda koja èuva postavljenu konfiguraciju.**/
	public void saveConfig() {
		Document dom;
		Element e = null;

		// instance of a DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;

		try {
			db = dbf.newDocumentBuilder();

			// create instance of DOM
			dom = db.newDocument();

			Element rootEle = dom.createElement("config");

			e = dom.createElement("lang");
			e.appendChild(dom.createTextNode(getLanguage()));

			rootEle.appendChild(e);

			e = dom.createElement("extended_state");
			e.appendChild(dom.createTextNode(String.valueOf(getState())));
			
			rootEle.appendChild(e);
			
			e = dom.createElement("dimension");
			rootEle.appendChild(e);

			Element dimensionRoot = e;
			e = dom.createElement("width");
			e.appendChild(dom.createTextNode(String.valueOf((int)getDimension().getWidth())));
			dimensionRoot.appendChild(e);

			e = dom.createElement("height");
			e.appendChild(dom.createTextNode(String.valueOf((int)getDimension().getHeight())));
			dimensionRoot.appendChild(e);

			dom.appendChild(rootEle);

			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.setOutputProperty(OutputKeys.METHOD, "xml");
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			// send DOM to file
			try {
				tr.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(".\\Configure.xml")));
			} catch (FileNotFoundException | TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TransformerFactoryConfigurationError e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (TransformerConfigurationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

}