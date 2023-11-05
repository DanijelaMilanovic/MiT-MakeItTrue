/***********************************************************************
 * Module:  ExportToXML.java
 * Author:  Notebook
 * Purpose: Defines the Class ExportToXML
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

public class ExportToXML implements DataExportInterface {
   /** @param project 
    * @param url */
	// Ovdje ce da se prima appModel pa ce morati da se napravi razlika i za dijagram u slucaju da se cuva samo jedan dijagram
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
	        //ovdje fali provjera da li dijagrami postoje
	        e = dom.createElement("diagrams");
	        rootEle.appendChild(e);
	        
	        Element diagramsRoot = e;
	        
	        for (Diagram diagram : project.getDiagrams()) {
				e = dom.createElement("diagram");
				e.appendChild(dom.createTextNode(diagram.getName()));
				diagramsRoot.appendChild(e);
			}
	        
	        dom.appendChild(rootEle);
	        
	        Transformer tr = TransformerFactory.newInstance().newTransformer();
           tr.setOutputProperty(OutputKeys.INDENT, "yes");
           tr.setOutputProperty(OutputKeys.METHOD, "xml");
           tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

           // send DOM to file
           try {
				tr.transform(new DOMSource(dom), 
				                     new StreamResult(new FileOutputStream(url + FileSystems.getDefault().getSeparator() + ".projectMiT")));
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
