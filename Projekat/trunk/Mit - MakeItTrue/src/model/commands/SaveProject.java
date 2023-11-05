package model.commands;

import model.AbstractExecutableCommand;
import model.ApplicationModel;
import model.Project;

/**
 * 
 * Klasa koja realizuje èuvanje projekta
 *
 */
public class SaveProject extends AbstractExecutableCommand {

	public SaveProject(ApplicationModel applicationModel) {
		super(applicationModel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		for (Project project : applicationModel.getActiveProjects()) {
			if(project.isFocused()) {
				this.applicationModel.saveProject(project);
			}
		}
	}

}
