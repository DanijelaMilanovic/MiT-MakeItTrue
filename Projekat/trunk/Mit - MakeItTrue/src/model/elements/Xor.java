/***********************************************************************
 * Module:  Xor.java
 * Author:  Notebook
 * Purpose: Defines the Class Xor
 ***********************************************************************/

package model.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import model.AbstractObject;
import model.DifferentViewObject;

/**
 * 
 * Klasa koja predstavlja logièko XOR kolo
 *
 */
public class Xor extends AbstractObject  {
	   
	   public Xor(int xKoordinata, int yKoordinata, DifferentViewObject differentViewObject) {
		   
		   this.point   = new Point();
		   this.endPoint = new Point();
		   
		   this.pin1    = new Point();
		   this.pin2    = new Point();
		   this.exitPin = new Point();
		   
		   this.point.x   = xKoordinata;
		   this.point.y   = yKoordinata;
		   
		   this.endPoint.x = point.x + 85;
		   this.endPoint.y = point.y + 45;
		   
		   this.pin1.x    = point.x;
		   this.pin1.y    = point.y + 10;
		   
		   this.pin2.x    = point.x;
		   this.pin2.y    = point.y + 30;
		   
		   this.exitPin.x = point.x + 80;
		   this.exitPin.y = point.y + 20;
		   
		   this.differentView = differentViewObject;
		   this.isSelected = false;

	   }
	   
	   @Override
   public void draw(Graphics g) {
		   
		   Graphics2D g2d = (Graphics2D)g.create();
	   
	   String type = differentView.getType();
	   AffineTransform currentAT = g2d.getTransform();

	   g2d.setColor(elementColor);
	   
	   switch(type)
	   {
	   case "toolbox":
		   
		    width = 10;
		    height = 5;
		   
		    input.setLocation(point.x, point.y+20);
			output.setLocation(point.x+140, point.y+30);
			
			g2d.setStroke(new BasicStroke(2));
			
			//g2d.drawString("XOR", xKoordinata + 50, yKoordinata + 35);
			g2d.drawLine(pin1.x, pin1.y, point.x + 15, point.y + 10);//prvi pin
			g2d.drawLine(pin2.x, pin2.y, point.x + 15, point.y + 30);//drugi pin
			g2d.drawArc(point.x -15, point.y -5, 45, 45, 60, -120); //deo od or
			g2d.drawArc(point.x -25, point.y - 5, 45, 45, 60, -120); //deo do pinova
			//g2d.drawLine(xKoordinata + 20, yKoordinata, xKoordinata + 37, yKoordinata); //gornja linija
			//g2d.drawLine(xKoordinata + 19, yKoordinata + 40, xKoordinata + 41, yKoordinata + 40); //donlja linija
			g2d.drawArc(point.x-15, point.y -2, 80, 40, 0, -100);
			g2d.drawArc(point.x-15, point.y -2, 80, 40, 0, 100);
			g2d.drawLine(point.x + 65, point.y + 20, exitPin.x, exitPin.y);
			
	
			g2d.setTransform(currentAT);
			g2d.dispose();
			break;
	   case "canvas":
		   
			g2d.setStroke(new BasicStroke(2));
			
			//g2d.drawString("XOR", xKoordinata + 50, yKoordinata + 35);
			g2d.drawLine(pin1.x, pin1.y, point.x + 15, point.y + 10);//prvi pin
			g2d.drawLine(pin2.x, pin2.y, point.x + 15, point.y + 30);//drugi pin
			g2d.drawArc(point.x -15, point.y -5, 45, 45, 60, -120); //deo od or
			g2d.drawArc(point.x -25, point.y - 5, 45, 45, 60, -120); //deo do pinova
			//g2d.drawLine(xKoordinata + 20, yKoordinata, xKoordinata + 37, yKoordinata); //gornja linija
			//g2d.drawLine(xKoordinata + 19, yKoordinata + 40, xKoordinata + 41, yKoordinata + 40); //donlja linija
			g2d.drawArc(point.x-15, point.y -2, 80, 40, 0, -100);
			g2d.drawArc(point.x-15, point.y -2, 80, 40, 0, 100);
			g2d.drawLine(point.x + 65, point.y + 20, exitPin.x, exitPin.y);
			
			
			AffineTransform transformer = new AffineTransform();
			//transformer.rotate((45)*Math.PI/180);
			
			//donji ulazni pin
			g2d.setPaint(Color.BLUE.brighter());
			g2d.fill(transformer.createTransformedShape(new Ellipse2D.Float(point.x-2, point.y + 6, 9, 9)));
			
			//gornji ulazni pin
			g2d.setPaint(Color.BLUE.brighter());
			g2d.fill(transformer.createTransformedShape(new Ellipse2D.Float(point.x-2, point.y + 26, 9, 9)));

			//izlazni pin
			g2d.setPaint(Color.BLUE.brighter());
			g2d.fill(transformer.createTransformedShape(new Ellipse2D.Float(point.x+80, point.y + 16, 9, 9)));
			
			
			g2d.setTransform(currentAT);
			g2d.dispose();
		   break;
	   }
   }
   
   public void rotate() {
      // TODO: implement
   }
   
   public void delete() {
      // TODO: implement
   }
   
   public int getNumberOfPins() {
      // TODO: implement
      return 0;
   }
   
   /** @param newNumberOfPins */
   public void setNumberOfPins(int newNumberOfPins) {
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

@Override
public void paintIcon(Component c, Graphics g, int x, int y) {
	draw((Graphics2D)g);
	
}

@Override
public int getIconWidth() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int getIconHeight() {
	// TODO Auto-generated method stub
	return 0;
}

public void setDifferentView(DifferentViewObject differentView) {
		this.differentView = differentView;
	}
}