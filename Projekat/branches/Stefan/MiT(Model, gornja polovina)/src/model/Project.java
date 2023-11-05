/***********************************************************************
 * Module:  Project.java
 * Author:  Notebook
 * Purpose: Defines the Class Project
 ***********************************************************************/

package model;

import java.util.Vector;

public class Project {
   private String name;
   private String url;
   private java.util.Collection<Diagram> diagrams;

/** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorDiagrams() {
      if (diagrams == null)
         diagrams = new java.util.Vector<Diagram>();
      return diagrams.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newDiagrams */
   public void setDiagrams(java.util.Collection<Diagram> newDiagrams) {
      removeAllDiagrams();
      for (java.util.Iterator iter = newDiagrams.iterator(); iter.hasNext();)
         addDiagram((Diagram)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newDiagram */
   public void addDiagram(Diagram newDiagram) {
      if (newDiagram == null)
         return;
      if (this.diagrams == null)
         this.diagrams = new java.util.Vector<Diagram>();
      if (!this.diagrams.contains(newDiagram))
         this.diagrams.add(newDiagram);
   }
   
   /** @pdGenerated default remove
     * @param oldDiagram */
   public void removeDiagram(Diagram oldDiagram) {
      if (oldDiagram == null)
         return;
      if (this.diagrams != null)
         if (this.diagrams.contains(oldDiagram))
            this.diagrams.remove(oldDiagram);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllDiagrams() {
      if (diagrams != null)
         diagrams.clear();
   }
   
   public String getName() {
      return name;
   }
   
   /** @param newName */
   public void setName(String newName) {
      name = newName;
   }
   
   
	   public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

public Project(String name, String url) {
	   this.name = name;
	   this.url = url;
	   diagrams = new Vector<Diagram>();
   }
  

}