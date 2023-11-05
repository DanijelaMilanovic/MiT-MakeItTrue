/***********************************************************************
 * Module:  AbstractExecutableCommand.java
 * Author:  G1
 ***********************************************************************/

package model;
/**Apstraktna klasa koje definiše metode koje su obavezne da se predefinišu u svakoj izvedenoj klasi komande. **/
public abstract class AbstractExecutableCommand implements ExecutableCommand {
   /**Aplikacioni model nad kojim se izvršava komanda.**/
	protected ApplicationModel applicationModel;
   
   /** @param applicationModel */
   public AbstractExecutableCommand(ApplicationModel applicationModel) {
	   this.applicationModel = applicationModel;
   }
   /**apstraktna metoda izvršavanja komande koju predefinišu sve klase komande. **/
   public abstract void execute();
}