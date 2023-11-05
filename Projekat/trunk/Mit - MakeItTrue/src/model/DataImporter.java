/***********************************************************************
 * Module:  DataImporter.java
 * Author:  G1
 ***********************************************************************/

package model;
/**Klasa koja definiše uvoz iz eksternog konfiguracionog fajla u aplikaciju.**/
public class DataImporter {
	private DataImportInterface importer;

	public DataImporter(String type) {
		switch (type) {
		case "XML":
			importer = new ImportFromXML();
			break;
		}
	}

	public DataImportInterface getImporter() {
		return importer;
	}

	/** @param newImporter */
	public void setImporter(DataImportInterface newImporter) {
		importer = newImporter;
	}

}