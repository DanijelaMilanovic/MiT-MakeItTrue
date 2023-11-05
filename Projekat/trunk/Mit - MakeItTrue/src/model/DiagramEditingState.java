/***********************************************************************
 * Module:  DiagramEditingState.java
 * Author:  G1
 ***********************************************************************/

package model;
/**Interfejs za definisanje svih metoda potrebnih za ponašanje dijagrama u raznim stanjima.**/
public interface DiagramEditingState {
/**Metoda za dodavanje elementa.
 * @param diagram - dijagram na koji se dodaju objekti
 * @param obj - objekat koji se dodaje**/
	void addElement(Diagram diagram, Objects obj);
}