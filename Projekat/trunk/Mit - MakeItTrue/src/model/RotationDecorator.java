/***********************************************************************
 * Module:  RotationDecorator.java
 * Author:  G1
 ***********************************************************************/

package model;

import java.awt.Graphics;
/**Klasa koja definiše dekoraciju za objekat koji se rotira.**/
public class RotationDecorator extends ObjectDecorator {
   public RotationDecorator(Objects object) {
		super(object);
		// TODO Auto-generated constructor stub
	}

   @Override
   public void draw(Graphics g) {
   	// TODO Auto-generated method stub
   	
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