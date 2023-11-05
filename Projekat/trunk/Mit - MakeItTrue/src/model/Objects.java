/***********************************************************************
 * Module:  Objects.java
 * Author:  G1
 ***********************************************************************/

package model;

import java.awt.Graphics;
import java.awt.Point;
/**Apstraktna klasa za definisanje osnovnih komponenti objekata editovanja.**/
public abstract class Objects {

	/**Taèka u gornjem lijevom uglu koja predstavlja poèetnu taèku objekta.**/
	protected Point point;
	/**Taèka u donjem desnom uglu koja predstavlja krajnju taèku objekta.**/
	protected Point endPoint;
	/**Širina objekta.**/
	protected int width;
	/**Visina objekta.**/
	protected int height;
	/**Stanje selektovanja.**/
	protected boolean isSelected;
	/**Pogled objekta**/
	protected DifferentViewObject differentView;

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	/**Apstraktna metoda za iscrtavanje objekta
	 * @param g - grafièki kontekst.**/
	public abstract void draw(Graphics g);

	public void rotate() {
		// TODO: implement
	}

	public void move() {
		// TODO: implement
	}

	public void delete() {
		// TODO: implement
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public float getWidth() {
		return width;
	}

	/** @param newWidth */
	public void setWidth(int newWidth) {
		width = newWidth;
	}

	public float getHeight() {
		return height;
	}

	/** @param newHeight */
	public void setHeight(int newHeight) {
		height = newHeight;
	}

	public void setDifferentView(DifferentViewObject differentView) {
		this.differentView = differentView;
	}

}