/***********************************************************************
 * Module:  Xor.java
 * Author:  Notebook
 * Purpose: Defines the Class Xor
 ***********************************************************************/

package model;

import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import javax.swing.Icon;

public class Xor extends AbstractObject implements Icon {
	private int xKoordinata;
	private int yKoordinata;
	   
	   public Xor(int xKoordinata, int yKoordinata, DifferentViewObject differentViewObject) {
		   
		   this.xKoordinata = xKoordinata;
		   this.yKoordinata = yKoordinata;
		   this.differentView = differentViewObject;
	   }
	   
	   @Override
   public void draw(Graphics g) {
		   
		   Graphics2D g2d = (Graphics2D)g.create();
	   
	   String type = differentView.getType();
	   AffineTransform currentAT = g2d.getTransform();
	   
	   g2d.scale(scaleFactorX, scaleFactorY);
	   g2d.rotate(rotateFactor, xKoordinata + (width / 2), yKoordinata + (height / 2));
	   g2d.setColor(elementColor);
	   
	   switch(type)
	   {
	   case "toolbox":
		   
		    width = 10;
		    height = 5;
		   
		    input.setLocation(xKoordinata, yKoordinata+20);
			output.setLocation(xKoordinata+140, yKoordinata+30);
			
			g2d.setStroke(new BasicStroke(2));
			
			//g2d.drawString("XOR", xKoordinata + 50, yKoordinata + 35);
			g2d.drawLine(xKoordinata, yKoordinata + 10, xKoordinata + 15, yKoordinata + 10);//prvi pin
			g2d.drawLine(xKoordinata, yKoordinata + 30, xKoordinata + 15, yKoordinata + 30);//drugi pin
			g2d.drawArc(xKoordinata -15, yKoordinata -5, 45, 45, 60, -120); //deo od or
			g2d.drawArc(xKoordinata -25, yKoordinata - 5, 45, 45, 60, -120); //deo do pinova
			//g2d.drawLine(xKoordinata + 20, yKoordinata, xKoordinata + 37, yKoordinata); //gornja linija
			//g2d.drawLine(xKoordinata + 19, yKoordinata + 40, xKoordinata + 41, yKoordinata + 40); //donlja linija
			g2d.drawArc(xKoordinata-15, yKoordinata -2, 80, 40, 0, -100);
			g2d.drawArc(xKoordinata-15, yKoordinata -2, 80, 40, 0, 100);
			g2d.drawLine(xKoordinata + 65, yKoordinata + 20, xKoordinata + 80, yKoordinata + 20);

			g2d.setTransform(currentAT);
			g2d.dispose();
			break;
	   case "canvas":
		   
			g2d.setStroke(new BasicStroke(1));
			
			g2d.drawString("XOR", xKoordinata + 35, yKoordinata + 25);
			g2d.drawLine(xKoordinata, yKoordinata + 10, xKoordinata + 15, yKoordinata + 10);//prvi pin
			g2d.drawLine(xKoordinata, yKoordinata + 30, xKoordinata + 15, yKoordinata + 30);//drugi pin
			g2d.drawArc(xKoordinata -15, yKoordinata -5, 45, 45, 60, -120); //deo od or
			g2d.drawArc(xKoordinata -25, yKoordinata - 5, 45, 45, 60, -120); //deo do pinova
			//g2d.drawLine(xKoordinata + 20, yKoordinata, xKoordinata + 37, yKoordinata); //gornja linija
			//g2d.drawLine(xKoordinata + 19, yKoordinata + 40, xKoordinata + 41, yKoordinata + 40); //donlja linija
			g2d.drawArc(xKoordinata-15, yKoordinata -2, 80, 40, 0, -100);
			g2d.drawArc(xKoordinata-15, yKoordinata -2, 80, 40, 0, 100);
			g2d.drawLine(xKoordinata + 65, yKoordinata + 20, xKoordinata + 80, yKoordinata + 20);
			
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


}