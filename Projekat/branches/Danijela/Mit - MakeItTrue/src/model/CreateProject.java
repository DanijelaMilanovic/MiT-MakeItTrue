/***********************************************************************
 * Module:  CreateProject.java
 * Author:  Notebook
 * Purpose: Defines the Class CreateProject
 ***********************************************************************/

package model;

public class CreateProject extends AbstractExecutableCommand {
   
	public CreateProject(ApplicationModel applicationModel) {
		super(applicationModel);
	}

	public void execute() {
      this.applicationModel.createProject();
   }

}