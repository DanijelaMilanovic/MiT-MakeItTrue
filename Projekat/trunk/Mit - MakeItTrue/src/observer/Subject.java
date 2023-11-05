/***********************************************************************
 * Module:  Subject.java
 * Author:  G1
 ***********************************************************************/

package observer;
/**Interfjes koji definiše sve metode da odredjena klasa postanje subjekat**/
public interface Subject {
   /** Metoda za dodavanje posmatraèa na subjekat
    *  @param observer Posmatraè koji se dodaje 
    **/
   void attach(Observer observer);
   /** Metoda za odvajanje posmatraèa od subjekata
    *  @param observer Posmatraè koji se odvaja 
    **/
   void detach(Observer observer);
   /** Metoda za obavještavanje svih posmatraèa koji su nalaèeni na subjekat
    *  
    **/
   void notifyObservers();
}