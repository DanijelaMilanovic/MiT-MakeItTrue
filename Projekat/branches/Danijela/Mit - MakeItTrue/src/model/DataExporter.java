/***********************************************************************
 * Module:  DataExporter.java
 * Author:  Notebook
 * Purpose: Defines the Class DataExporter
 ***********************************************************************/

package model;

public class DataExporter {
   private DataExportInterface exporter;
   
   public DataExporter(String type) {
      switch(type) {
      	case "XML":
      		exporter = new ExportToXML();
      		break;
      }
   }
   
   public DataExportInterface getExporter() {
      return exporter;
   }
   
   /** @param newExporter */
   public void setExporter(DataExportInterface newExporter) {
      exporter = newExporter;
   }

}