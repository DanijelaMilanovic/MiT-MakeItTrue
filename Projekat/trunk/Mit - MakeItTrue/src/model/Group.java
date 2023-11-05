/***********************************************************************
 * Module:  Group.java
 * Author:  G1
 ***********************************************************************/

package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Vector;
/**Klasa koja definiše komponentu saèinjenu od više ratlièitih objekata. **/
public class Group extends Objects {
   private java.util.Vector<Objects> objects;

   public java.util.Collection<Objects> getObjects() {
	return objects;
}

public void setObjects(java.util.Vector<Objects> objects) {
	this.objects = objects;
}

public Group () {
	   this.objects = new Vector<>();
   }
   
   public void add(Objects obj) {
	   objects.add(obj);
	   
	   this.point = new Point();
	   this.endPoint = new Point();
		
		this.point.x = objects.get(0).point.x;
		this.point.y = objects.get(0).point.y;
		
		this.endPoint.x = objects.lastElement().endPoint.x;
		this.endPoint.y = objects.lastElement().endPoint.y;
   }
   
   public void remove(Objects obj) {
	   objects.remove(obj);
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
   
   public void addObject() {
      // TODO: implement
   }
   
   public int removeObject() {
      // TODO: implement
      return 0;
   }

@Override
public void draw(Graphics g) {
	Graphics2D g2d = (Graphics2D)g.create(); 
	
	for (Objects object : objects) {
		object.draw(g2d);
	}
	
}

}