/***********************************************************************
 * Module:  ObjectDecorator.java
 * Author:  G1
 ***********************************************************************/

package model;

import java.awt.Graphics;
/**Klasa koja definiše osnovne postavke za dekoraciju objekta.**/
public class ObjectDecorator extends Objects {
   private Objects object;

   public Objects getObject() {
	return object;
   }

public ObjectDecorator(Objects object) {
	   this.object = object;
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
   
   public void setObject() {
      // TODO: implement
   }

@Override
public void draw(Graphics g) {
	// TODO Auto-generated method stub
	
}



}