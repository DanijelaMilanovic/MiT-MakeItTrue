/***********************************************************************
 * Module:  AbstractObject.java
 * Author:  G1
 ***********************************************************************/

package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;
/**Apstraktna klasa za definisanje osnovnih komponenti elemenata logièkih kola. **/
public abstract class AbstractObject extends Objects implements Icon {
	/**Prvi pin logièkog kola. **/
	protected Point pin1;
	/**Drugi pin Logilkog kola.**/
	protected Point pin2;
	/**Izlazni pin logièkog kola.**/
	protected Point exitPin;

	public Point getPin1() {
		return pin1;
	}

	public void setPin1(Point pin1) {
		this.pin1 = pin1;
	}

	public Point getPin2() {
		return pin2;
	}

	public void setPin2(Point pin2) {
		this.pin2 = pin2;
	}

	public Point getExitPin() {
		return exitPin;
	}

	public void setExitPin(Point exitPin) {
		this.exitPin = exitPin;
	}

	protected Boolean isSelected = false;

	protected String name;

	Rectangle2D.Double selectionRectangle = new Rectangle2D.Double();

	public Point2D.Double input = new Point2D.Double();
	public Point2D.Double output = new Point2D.Double();

	protected Color elementColor = new Color(0, 0, 0);
	protected Color stringColor = new Color(0, 0, 0);
	protected Color outlineColor = new Color(192, 192, 192);

	public void setPoint(int xKoordinata, int yKoordinata) {
		this.point.x = xKoordinata;
		this.point.y = yKoordinata;
	}

	public void rotate() {
		// TODO: implement
	}

	public void delete() {
		// TODO: implement
	}

	public AbstractObject() {
		// TODO: implement
	}

	public void move() {
		// TODO: implement
	}

	public abstract void paintIcon(Component c, Graphics g, int x, int y);

	public void setDifferentView(DifferentViewObject differentView) {
		this.differentView = differentView;
	}

}