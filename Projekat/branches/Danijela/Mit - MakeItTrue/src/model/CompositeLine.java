/***********************************************************************
 * Module:  CompositeLine.java
 * Author:  Notebook
 * Purpose: Defines the Class CompositeLine
 ***********************************************************************/

package model;

import java.util.*;

public class CompositeLine extends Relation {
   private java.util.Collection<Relation> relations;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Relation> getRelations() {
      if (relations == null)
         relations = new java.util.Vector<Relation>();
      return relations;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorRelations() {
      if (relations == null)
         relations = new java.util.Vector<Relation>();
      return relations.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newRelations */
   public void setRelations(java.util.Collection<Relation> newRelations) {
      removeAllRelations();
      for (java.util.Iterator iter = newRelations.iterator(); iter.hasNext();)
         addRelations((Relation)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newRelation */
   public void addRelations(Relation newRelation) {
      if (newRelation == null)
         return;
      if (this.relations == null)
         this.relations = new java.util.Vector<Relation>();
      if (!this.relations.contains(newRelation))
         this.relations.add(newRelation);
   }
   
   /** @pdGenerated default remove
     * @param oldRelation */
   public void removeRelations(Relation oldRelation) {
      if (oldRelation == null)
         return;
      if (this.relations != null)
         if (this.relations.contains(oldRelation))
            this.relations.remove(oldRelation);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllRelations() {
      if (relations != null)
         relations.clear();
   }
   
   public void draw() {
      // TODO: implement
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
   
   public void addRelation() {
      // TODO: implement
   }
   
   public void removeRelation() {
      // TODO: implement
   }

}