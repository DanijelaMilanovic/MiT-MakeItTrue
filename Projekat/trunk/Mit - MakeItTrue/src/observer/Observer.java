/***********************************************************************
 * Module:  Observer.java
 * Author:  G1
 ***********************************************************************/

package observer;
/**Interfejs koji definiše metode potrebne za primjenu posmatraèa**/
public interface Observer {
	/**Metoda za ažuriranje subjekta
	 * @param subject - subjekat koji se ažurira
	 * **/
   void update(Subject subject);

}