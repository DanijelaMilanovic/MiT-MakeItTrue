/***********************************************************************
 * Module:  ImportFromXML.java
 * Author:  G1
 ***********************************************************************/

package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import model.elements.Or;
import model.elements.Xor;

/**Klasa koja definiše uvoz u aplikaciju iz izabranog projekta. Sadrži sve metode od implementiranog interfejsa.**/
public class ImportFromXML implements DataImportInterface {
	public Project importProject(String url) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		Project project = null;
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document dom = documentBuilder.parse(new File(url + "\\.projectMiT"));

			Element xml = dom.getDocumentElement();

			String name = xml.getElementsByTagName("name").item(0).getTextContent();
			project = new Project(name, url);

			Vector<Diagram> diagrams = new Vector<Diagram>();

			NodeList diagramsNode = xml.getElementsByTagName("diagrams").item(0).getChildNodes();

			for (int i = 0; i < diagramsNode.getLength(); i++) {
				Node diagramNode = diagramsNode.item(i);
				if (diagramNode instanceof Element) {
					Element diagramEl = (Element) diagramNode;
					if (diagramEl.getTagName().equalsIgnoreCase("diagram")) {
						Diagram diagram = new Diagram(diagramEl.getTextContent());

						importDiagram(diagram, url);

						diagrams.add(diagram);

					}

				}
			}
			project.setDiagrams(diagrams);

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

		return project;
	}

	// Importovanje dijagrama nije zavrseno
	private void importDiagram(Diagram diagram, String projectUrl) {
		String type = "";
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document dom = documentBuilder
					.parse(new File(projectUrl + FileSystems.getDefault().getSeparator() + diagram.getName() + ".mit"));

			Element xml = dom.getDocumentElement();
			// Vector<Objects> elements = new Vector<Objects>();
			NodeList elementsNode = xml.getElementsByTagName("elements").item(0).getChildNodes();

			for (int i = 0; i < elementsNode.getLength(); i++) {
				Node elementNode = elementsNode.item(i);
				if (elementNode instanceof Element) {
					Element elementEl = (Element) elementNode;

					NodeList infoElementa = elementEl.getChildNodes();

					for (int j = 0; j < infoElementa.getLength(); j++) {
						Node infoOdElementa = infoElementa.item(j);

						if (infoOdElementa instanceof Element) {
							Element infoOdElementaEl = (Element) infoOdElementa;

							if (infoOdElementaEl.getTagName().equalsIgnoreCase("type")) {
								if (infoOdElementaEl.getTextContent().equals("Xor")) {
									type = "Xor";
								} else if (infoOdElementaEl.getTextContent().equals("Or")) {
									type = "Or";
								}
							}

							if (infoOdElementaEl.getTagName().equalsIgnoreCase("StartPoint")) {
								NodeList infoPointi = infoOdElementaEl.getChildNodes();
								int x = 0, y = 0;

								for (int k = 0; k < infoPointi.getLength(); k++) {
									Node infoPoint = infoPointi.item(k);
									if (infoPoint instanceof Element) {
										Element koordinata = (Element) infoPoint;
										if (koordinata.getTagName().equalsIgnoreCase("x")) {
											x = Integer.parseInt(koordinata.getTextContent());
										}
										if (koordinata.getTagName().equalsIgnoreCase("y")) {
											y = Integer.parseInt(koordinata.getTextContent());

											if (type.equals("Xor")) {
												diagram.getElements().add(new Xor(x, y, new CanvasObject()));
												type = "";
											}
											if (type.equals("Or")) {
												diagram.getElements().add(new Or(x, y, new CanvasObject()));
												type = "";
											}
										}

									}
								}
							}

						}

					}
				}
			}

		}
		catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
