/***********************************************************************
 * Module:  DataExporter.java
 * Author:  Notebook
 * Purpose: Defines the Class DataExporter
 ***********************************************************************/

package model;

public class DataExporter {
   private DataExportInterface exporter;
	   
	   public DataExportInterface getExporter() {
		return exporter;
	}

	public void setExporter(DataExportInterface exporter) {
		this.exporter = exporter;
	}

	public DataExporter() {
	   this.exporter = new ExportToXML();
   }
}