/***********************************************************************
 * Module:  DataImportInterface.java
 * Author:  G1
 ***********************************************************************/

package model;
/**Interfejs koji definiše metode potrebne za uvoz projekta u aplikaciju.**/
public interface DataImportInterface {
/**Metoda za uvoz projekta u aplikaciju.
 * @param url - lokacija sa koje se uvozi
 * @return project - projekat koji je uvezen.**/
   Project importProject(String url);
}