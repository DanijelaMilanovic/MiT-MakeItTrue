/***********************************************************************
 * Module:  Subject.java
 * Author:  Korisnik
 * Purpose: Defines the Interface Subject
 ***********************************************************************/

package observer;

public interface Subject {
   /** @param observer */
   void attach(Observer observer);
   /** @param observer */
   void detach(Observer observer);
   void notifyObservers();
}