/***********************************************************************
 * Module:  DataImporter.java
 * Author:  Notebook
 * Purpose: Defines the Class DataImporter
 ***********************************************************************/

package model;

import java.util.*;

public class DataImporter {
   private DataImportInterface importer;
   
   public DataImportInterface getImporter() {
      return importer;
   }
   
   /** @param newImporter */
   public void setImporter(DataImportInterface newImporter) {
      importer = newImporter;
   }

}