/***********************************************************************
 * Module:  DataExportInterface.java
 * Author:  G1
 ***********************************************************************/

package model;
/**Interfejs koji definiše metode potrebne za izvoz iz aplikacije.**/
public interface DataExportInterface {
   /**Metoda za izvoz projekta  
    * @param project - projekat koji se izvozi.
    * @param url - lokacija na koju se izvozi */
   void exportProject(Project project, String url);
   /**Metoda za izvoz projekta  
    * @param diagram - diagram koji se izvozi.
    * @param url - lokacija na koju se izvozi */
   void exportDiagram(Diagram diagram, String url);
}