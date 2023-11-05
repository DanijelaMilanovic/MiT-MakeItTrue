/***********************************************************************
 * Module:  XMLPropertyStrategy.java
 * Author:  G1
 ***********************************************************************/

package model;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
/**Klasa koja definiše strategiju za parsiranje xml dokumenta. Sadrži sve metode od implementiranog interfejsa.**/
public class XMLPropertyStrategy implements PropertyParserStrategy {
	public HashMap<String, String> parse() {

		HashMap<String, String> properties = new HashMap<String, String>();
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document dom = documentBuilder.parse(new File(".\\Configure.xml"));
			
			Element xml = dom.getDocumentElement();
			
			String lang = xml.getElementsByTagName("lang").item(0).getTextContent();
			String height = xml.getElementsByTagName("height").item(0).getTextContent();
			String width = xml.getElementsByTagName("width").item(0).getTextContent();
			String state = xml.getElementsByTagName("extended_state").item(0).getTextContent();
			
			properties.put("language", lang);
			properties.put("height", height);
			properties.put("width", width);
			properties.put("extended_state", state);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return properties;
	}

}