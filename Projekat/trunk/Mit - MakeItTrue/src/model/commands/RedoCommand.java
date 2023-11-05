package model.commands;

import model.AbstractExecutableCommand;
import model.ApplicationModel;
import model.Diagram;
import model.Project;

/**
 * 
 * Klasa koja realizuje povratak na poništeni korak
 *
 */
public class RedoCommand extends AbstractExecutableCommand {

	public RedoCommand(ApplicationModel applicationModel) {
		super(applicationModel);
	}

	@Override
	public void execute() {
		for(Project project : applicationModel.getActiveProjects()) {
			for(Diagram diagram : project.getDiagrams()) {
				if(diagram.getCurrentState() != null) {
					diagram.redo();
				}
			}
		}
		applicationModel.notifyObservers();
	}

}
