/***********************************************************************
 * Module:  ExportToXML.java
 * Author:  G1
 ***********************************************************************/

package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;

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

import model.elements.Or;
import model.elements.Xor;
/**Klasa koja definiše izvoz iz aplikacije u odabranu lokaciju na raèunaru u format xml fajla. Sadrži sve metode od implementiranog interfejsa.**/
public class ExportToXML implements DataExportInterface {
	/**
	 * @param project
	 * @param url
	 */
	// Ovdje ce da se prima appModel pa ce morati da se napravi razlika i za
	// dijagram u slucaju da se cuva samo jedan dijagram
	public void exportProject(Project project, String url) {
		Document dom;
		Element e = null;

		// instance of a DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// use factory to get an instance of document builder
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();

			// create instance of DOM
			dom = db.newDocument();

			Element rootEle = dom.createElement("project");

			e = dom.createElement("name");
			e.appendChild(dom.createTextNode(project.getName()));
			rootEle.appendChild(e);
			// ovdje fali provjera da li dijagrami postoje
			e = dom.createElement("diagrams");
			rootEle.appendChild(e);

			Element diagramsRoot = e;

			for (Diagram diagram : project.getDiagrams()) {
				e = dom.createElement("diagram");
				e.appendChild(dom.createTextNode(diagram.getName()));
				diagramsRoot.appendChild(e);
				exportDiagram(diagram, url + FileSystems.getDefault().getSeparator() + diagram.getName() + ".mit");
			}

			dom.appendChild(rootEle);

			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.setOutputProperty(OutputKeys.METHOD, "xml");
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			// send DOM to file
			try {
				tr.transform(new DOMSource(dom), new StreamResult(
						new FileOutputStream(url + FileSystems.getDefault().getSeparator() + ".projectMiT")));
			} catch (FileNotFoundException | TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TransformerConfigurationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (TransformerFactoryConfigurationError e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	public void exportDiagram(Diagram diagram, String url) {
		Document dom;
		Element e = null;

		// instance of a DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// use factory to get an instance of document builder
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();

			// create instance of DOM
			dom = db.newDocument();

			Element rootEle = dom.createElement("diagram");

			e = dom.createElement("name");
			e.appendChild(dom.createTextNode(diagram.getName()));
			rootEle.appendChild(e);
			// ovdje fali provjera da li dijagrami postoje
			e = dom.createElement("elements");
			rootEle.appendChild(e);

			Element elementsRoot = e;

			for (Objects element : diagram.getElements()) {
				if(element instanceof AbstractObject) {
					e = dom.createElement("element");
				
					if(element instanceof Xor) {
						Element el = e;
						el = dom.createElement("type");
						el.appendChild(dom.createTextNode("Xor"));
						e.appendChild(el);
						el = dom.createElement("StartPoint");
						Element point = el;
						point = dom.createElement("x");
						point.appendChild(dom.createTextNode(Integer.toString(element.point.x)));
						el.appendChild(point);
						point = dom.createElement("y");
						point.appendChild(dom.createTextNode(Integer.toString(element.point.y)));
						el.appendChild(point);
						e.appendChild(el);
					}
					else if(element instanceof Or) {
						Element el = e;
						el = dom.createElement("type");
						el.appendChild(dom.createTextNode("Or"));
						e.appendChild(el);
						el = dom.createElement("StartPoint");
						Element point = el;
						point = dom.createElement("x");
						point.appendChild(dom.createTextNode(Integer.toString(element.point.x)));
						el.appendChild(point);
						point = dom.createElement("y");
						point.appendChild(dom.createTextNode(Integer.toString(element.point.y)));
						el.appendChild(point);
						e.appendChild(el);
					}
				}
				else {
					e = dom.createElement("relation");
					if(element instanceof CompositeLine) {
						Element el = e;
						el = dom.createElement("type");
						el.appendChild(dom.createTextNode("CompositeLine"));
						e.appendChild(el);
						
						el = dom.createElement("CompositeLine");
						for(Relation line : ((CompositeLine) element).getSubordinates()) {
							Element composite = el;
							composite = dom.createElement("Line");
							
							Element li = dom.createElement("StartPoint");
							Element point = li;
							point = dom.createElement("x");
							point.appendChild(dom.createTextNode(Integer.toString(line.point.x)));
							li.appendChild(point);
							point = dom.createElement("y");
							point.appendChild(dom.createTextNode(Integer.toString(line.point.y)));
							li.appendChild(point);
							composite.appendChild(li);
							
							li = dom.createElement("EndPoint");
							point = li;
							point = dom.createElement("x");
							point.appendChild(dom.createTextNode(Integer.toString(line.endPoint.x)));
							li.appendChild(point);
							point = dom.createElement("y");
							point.appendChild(dom.createTextNode(Integer.toString(line.endPoint.y)));
							li.appendChild(point);
							composite.appendChild(li);
							el.appendChild(composite);
						}
						e.appendChild(el);

					}
					else if(element instanceof Line) {
						Element el = e;
						el = dom.createElement("type");
						el.appendChild(dom.createTextNode("Line"));
						e.appendChild(el);
						el = dom.createElement("StartPoint");
						Element point = el;
						point = dom.createElement("x");
						point.appendChild(dom.createTextNode(Integer.toString(element.point.x)));
						el.appendChild(point);
						point = dom.createElement("y");
						point.appendChild(dom.createTextNode(Integer.toString(element.point.y)));
						el.appendChild(point);
						e.appendChild(el);
						el = dom.createElement("EndPoint");
						point = el;
						point = dom.createElement("x");
						point.appendChild(dom.createTextNode(Integer.toString(element.endPoint.x)));
						el.appendChild(point);
						point = dom.createElement("y");
						point.appendChild(dom.createTextNode(Integer.toString(element.endPoint.y)));
						el.appendChild(point);
						e.appendChild(el);
					}
				}
				elementsRoot.appendChild(e);
			}

			dom.appendChild(rootEle);

			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.setOutputProperty(OutputKeys.METHOD, "xml");
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			// send DOM to file
			try {
				tr.transform(new DOMSource(dom), new StreamResult(
						new FileOutputStream(url)));
			} catch (FileNotFoundException | TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TransformerConfigurationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (TransformerFactoryConfigurationError e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

}
