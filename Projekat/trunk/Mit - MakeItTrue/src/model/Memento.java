/***********************************************************************
 * Module:  Memento.java
 * Author:  Notebook
 * Purpose: Defines the Class Memento
 ***********************************************************************/

package model;

import java.util.Vector;
/**Klasa koja definiše kopiju dijagrama. **/
public class Memento {
	/**kopije svih elemenata u dijagramu**/
	private Vector<Objects> backup;
	/**dijagram od kog se pravi kopija**/
	private Diagram diagram;

	public Memento(Diagram diagram) {
		this.diagram = diagram;
		backup = diagram.backup();
	}
/**Metoda obnavljanja dijagrama**/	
	public void restore() {
		diagram.restore(backup);
	}

}