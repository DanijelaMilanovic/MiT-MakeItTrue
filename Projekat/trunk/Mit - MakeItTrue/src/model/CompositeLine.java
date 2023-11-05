/***********************************************************************
 * Module:  CompositeLine.java
 * Author:  G1
 ***********************************************************************/

package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Vector;
/**Klasa koja definiše izlomljenu liniju. **/
public class CompositeLine extends Relation {
	private java.util.Vector<Relation> relations;

	public CompositeLine() {
		relations = new Vector<Relation>();

	}
	/**Metoda koja dodaje liniju na veæ postojeæu komozitnu
	 *  liniju i preraèunava njene parametre.
	 *  @param line - linija koja se dodaje. **/
	public void add(Relation line) {
		relations.add(line);
		this.point = new Point();
		this.endPoint = new Point();
		
		this.point.x = relations.get(0).point.x;
		this.point.y = relations.get(0).point.y;
		
		this.endPoint.x = relations.lastElement().endPoint.x;
		this.endPoint.y = relations.lastElement().endPoint.y;
		
		//System.out.println("Pocetna " +this.point+" i krajnnja " + this.endPoint);
	}
	/**Metoda koja uklanja liniju sa veæ postojeæe kompozitne linije.
	 *  @param line - linija koja se uklanja. **/
	public void remove(Relation line) {
		relations.remove(line);
	}

	public java.util.Vector<Relation> getSubordinates() {
		return relations;
	}

	public void rotate() {
		// TODO: implement
	}

	public void delete() {
		// TODO: implement
	}

	public float getWidth() {
		// TODO: implement
		return 0;
	}

	/** @param newWidth */
	public void setWidth(float newWidth) {
		// TODO: implement
	}

	public float getHeight() {
		// TODO: implement
		return 0;
	}

	/** @param newHeight */
	public void setHeight(float newHeight) {
		// TODO: implement
	}

	public void move() {
		// TODO: implement
	}

	public void addRelation() {
		// TODO: implement
	}

	public void removeRelation() {
		// TODO: implement
	}

	@Override
	public void draw(Graphics g) {

		Graphics2D g2d = (Graphics2D) g.create();

		for (Relation relation : relations) {
			relation.draw(g2d);
		}

	}

}