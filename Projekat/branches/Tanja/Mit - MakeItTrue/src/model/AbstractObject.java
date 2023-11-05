/***********************************************************************
 * Module:  AbstractObject.java
 * Author:  Notebook
 * Purpose: Defines the Class AbstractObject
 ***********************************************************************/

package model;

import java.util.*;

public abstract class AbstractObject extends Objects {
   private int numberOfPins;
   
   public void draw() {
      // TODO: implement
   }
   
   public void rotate() {
      // TODO: implement
   }
   
   public void delete() {
      // TODO: implement
   }
   
   public int getNumberOfPins() {
      return numberOfPins;
   }
   
   /** @param newNumberOfPins */
   public void setNumberOfPins(int newNumberOfPins) {
      numberOfPins = newNumberOfPins;
   }
   
   public AbstractObject() {
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