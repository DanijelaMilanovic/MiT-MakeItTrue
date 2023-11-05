/***********************************************************************
 * Module:  Diagram.java
 * Author:  Notebook
 * Purpose: Defines the Class Diagram
 ***********************************************************************/

package model;

import java.util.Collection;

import observer.Observer;

public class Diagram implements observer.Subject {
   private DiagramEditingState currentState;
   private Collection<Objects> elements;
   private String name;
   
   /** @pdGenerated default iterator getter */
   @SuppressWarnings("rawtypes")
   public java.util.Iterator getIteratorElements() {
      if (elements == null)
         elements = new java.util.Vector<Objects>();
      return elements.iterator();
   }
   
   public java.util.Collection<Objects> getElements() {
	return elements;
   }
 
   /** @pdGenerated default setter
     * @param newElements */
   @SuppressWarnings("rawtypes")
   public void setElements(java.util.Collection<Objects> newElements) {
      removeAllElements();
      for (java.util.Iterator iter = newElements.iterator(); iter.hasNext();)
         addElements((Objects)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newObjects */
   public void addElements(Objects newObjects) {
      if (newObjects == null)
         return;
      if (this.elements == null)
         this.elements = new java.util.Vector<Objects>();
      if (!this.elements.contains(newObjects))
         this.elements.add(newObjects);
   }
   
   /** @pdGenerated default remove
     * @param oldObjects */
   public void removeElements(Objects oldObjects) {
      if (oldObjects == null)
         return;
      if (this.elements != null)
         if (this.elements.contains(oldObjects))
            this.elements.remove(oldObjects);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllElements() {
      if (elements != null)
         elements.clear();
   }
   
   public DiagramEditingState getCurrentState() {
      return currentState;
   }
   
   /** @param newCurrentState */
   public void setCurrentState(DiagramEditingState newCurrentState) {
      currentState = newCurrentState;
   }
   
   public String getName() {
	return name;
   }

	public void setName(String name) {
		this.name = name;
	}

	public Diagram() {
      name = "test";
   }
	public Diagram(String name) {
		this.name = name;
		//ovdje treba inicijalizovati kolekciju elemenata
	}
   
   public void drawDiagram() {
      // TODO: implement
   }

   public void setMemento() {
      // TODO: implement
   }
   
   public void createMemento() {
      // TODO: implement
   }
	
	@Override
	public void attach(Observer observer) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void detach(Observer observer) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

}