/***********************************************************************
 * Module:  Group.java
 * Author:  Notebook
 * Purpose: Defines the Class Group
 ***********************************************************************/

package model;

import java.util.*;

public class Group extends Objects {
   private java.util.Collection<Objects> objects;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Objects> getObjects() {
      if (objects == null)
         objects = new java.util.Vector<Objects>();
      return objects;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorObjects() {
      if (objects == null)
         objects = new java.util.Vector<Objects>();
      return objects.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newObjects */
   public void setObjects(java.util.Collection<Objects> newObjects) {
      removeAllObjects();
      for (java.util.Iterator iter = newObjects.iterator(); iter.hasNext();)
         addObjects((Objects)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newObjects */
   public void addObjects(Objects newObjects) {
      if (newObjects == null)
         return;
      if (this.objects == null)
         this.objects = new java.util.Vector<Objects>();
      if (!this.objects.contains(newObjects))
         this.objects.add(newObjects);
   }
   
   /** @pdGenerated default remove
     * @param oldObjects */
   public void removeObjects(Objects oldObjects) {
      if (oldObjects == null)
         return;
      if (this.objects != null)
         if (this.objects.contains(oldObjects))
            this.objects.remove(oldObjects);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllObjects() {
      if (objects != null)
         objects.clear();
   }
   
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

}