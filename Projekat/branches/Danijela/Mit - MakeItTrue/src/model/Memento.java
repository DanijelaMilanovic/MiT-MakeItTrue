/***********************************************************************
 * Module:  Memento.java
 * Author:  Notebook
 * Purpose: Defines the Class Memento
 ***********************************************************************/

package model;

import java.util.*;

public class Memento {
   private Diagram state;
   
   public Diagram getState() {
      return state;
   }
   
   /** @param newState */
   public void setState(Diagram newState) {
      state = newState;
   }

}