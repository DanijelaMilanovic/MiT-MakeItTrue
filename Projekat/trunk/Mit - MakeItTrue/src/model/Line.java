/***********************************************************************
 * Module:  Line.java
 * Author:  G1
 ***********************************************************************/

package model;
/**Klasa koja definiše naèin kreiranja objekta “Linija”. Sadrži sve metode od implementiranog interfejsa.**/
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

public class Line extends Relation {
	
	public Line(int x, int y, int x1, int y1) 
	{
		this.point = new Point();
		this.endPoint = new Point();
		
		this.point.x = x;
		this.point.y = y;
		
		this.endPoint.x = x1;
		this.endPoint.y = y1;
		
	}

	   
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g.create(); 
		AffineTransform currentAT = g2d.getTransform();
		
		g2d.setStroke(new BasicStroke(2));
		Color elementColor = new Color(164, 164, 164);
		g2d.setColor(elementColor);

		g2d.drawLine(point.x, point.y, endPoint.x, endPoint.y);
		
		g2d.setTransform(currentAT);
		g2d.dispose();
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



}