/***********************************************************************
 * Module:  AbstractExecutableCommand.java
 * Author:  Notebook
 * Purpose: Defines the Class AbstractExecutableCommand
 ***********************************************************************/

package model;

public class AbstractExecutableCommand implements ExecutableCommand {
   private ApplicationModel applicationModel;
   
   public AbstractExecutableCommand(ApplicationModel app) {
	this.applicationModel = app;
}
   public void execute() {
	   applicationModel.createProject();
   }
}