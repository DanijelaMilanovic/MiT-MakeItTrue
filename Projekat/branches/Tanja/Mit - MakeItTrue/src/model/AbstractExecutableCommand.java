/***********************************************************************
 * Module:  AbstractExecutableCommand.java
 * Author:  Notebook
 * Purpose: Defines the Class AbstractExecutableCommand
 ***********************************************************************/

package model;

public class AbstractExecutableCommand implements ExecutableCommand {
   protected ApplicationModel applicationModel;
   
   /** @param applicationModel */
   public AbstractExecutableCommand(ApplicationModel applicationModel) {
	   this.applicationModel = applicationModel;
   }
   
   public void execute() {
   }
}