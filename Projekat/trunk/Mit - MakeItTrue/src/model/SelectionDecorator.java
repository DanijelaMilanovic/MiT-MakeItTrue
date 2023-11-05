/***********************************************************************
 * Module:  SelectionDecorator.java
 * Author:  G1
 ***********************************************************************/

package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
/**Klasa koja definiše dekoraciju za ozanèeni objekat.**/
public class SelectionDecorator extends ObjectDecorator {
   public SelectionDecorator(Objects object) {
		super(object);
		this.point = new Point();
		this.endPoint = new Point();
		
		this.point.x = object.getPoint().x - 20;
		this.point.y = object.getPoint().y - 20;
		
		this.endPoint.x = object.getEndPoint().x + 20;
		this.endPoint.y = object.getEndPoint().y + 20;
		
	   	this.setSelected(true);

	}

   @Override
   public void draw(Graphics g) {
	   
	Graphics2D g2d = (Graphics2D)g.create(); 

	 width = endPoint.x - point.x;
	 height = endPoint.y - point.y;
	
	Color selected = new Color(0,0,255);
   	getObject().draw(g2d);
   	
   	
    Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,0, new float[]{9}, 0);
    g2d.setStroke(dashed);
   	g2d.setColor(selected);
   	
   	g2d.drawRect(this.point.x, this.point.y, width, height);
   }
   
  @Override
	public Objects getObject() {
		return super.getObject();
	}
   public void rotate() {
      // TODO: implement
   }
   
   public void move() {
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

}