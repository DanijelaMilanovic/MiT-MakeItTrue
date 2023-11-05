/***********************************************************************
 * Module:  DataExporter.java
 * Author:  G1
 ***********************************************************************/

package model;
/**Klasa koja definiše izvoz u externi konfiguracioni fajl.**/
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