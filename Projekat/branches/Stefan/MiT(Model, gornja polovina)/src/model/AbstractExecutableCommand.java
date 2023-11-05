/***********************************************************************
 * Module:  AbstractExecutableCommand.java
 * Author:  Notebook
 * Purpose: Defines the Class AbstractExecutableCommand
 ***********************************************************************/

package model;

public class AbstractExecutableCommand implements ExecutableCommand {
   private ApplicationModel applicationModel;
   
   /** @param applicationModel */
   public AbstractExecutableCommand(ApplicationModel applicationModel) {
      this.setApplicationModel(applicationModel);
   }
   
   public void execute() {
	   // TODO: implement
   }

public ApplicationModel getApplicationModel() {
	return applicationModel;
}

public void setApplicationModel(ApplicationModel applicationModel) {
	this.applicationModel = applicationModel;
}

}