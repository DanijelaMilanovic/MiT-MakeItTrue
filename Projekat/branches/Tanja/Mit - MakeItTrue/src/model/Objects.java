/***********************************************************************
 * Module:  Objects.java
 * Author:  Notebook
 * Purpose: Defines the Class Objects
 ***********************************************************************/

package model;

public abstract class Objects {
   private float width;
   private float height;
   private DifferentViewObject differentView;
   
   public void draw() {
      // TODO: implement
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
      return width;
   }
   
   /** @param newWidth */
   public void setWidth(float newWidth) {
      width = newWidth;
   }
   
   public float getHeight() {
      return height;
   }
   
   /** @param newHeight */
   public void setHeight(float newHeight) {
      height = newHeight;
   }

}