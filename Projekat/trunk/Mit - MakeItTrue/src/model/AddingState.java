/***********************************************************************
 * Module:  AddingState.java
 * Author:  G1
 ***********************************************************************/

package model;
/**Klasa koja definiše stanje dodavanja elemenata na kanvas.
 *  U njoj se nalaze sve metode koje su predefinisane iz implementiranog interfejsa na sebi svojstven naèin. **/
public class AddingState implements DiagramEditingState {

	@Override
	public void addElement(Diagram diagram, Objects obj) {
		diagram.getElements().add(obj);
	}
}