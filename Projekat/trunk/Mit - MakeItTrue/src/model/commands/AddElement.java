package model.commands;

import model.AbstractExecutableCommand;
import model.AddingState;
import model.ApplicationModel;
import model.Diagram;
import model.Objects;
import model.Project;

/**
 * 
 * Klasa koja realizuje dodavanje elementa na dijagram
 *
 */
public class AddElement extends AbstractExecutableCommand {
	
	private Objects object;
	
	public AddElement(ApplicationModel applicationModel, Objects object) {
		super(applicationModel);
		this.object = object;
	}

	@Override
	public void execute() {
		for(Project project : applicationModel.getActiveProjects()) {
			for(Diagram diagram : project.getDiagrams()) {
				if(diagram.getCurrentState() instanceof AddingState) {
					diagram.execute(this);
					diagram.addElement(object);
					diagram.notifyObservers();
				}
			}
		}	
		applicationModel.notifyObservers();
	}

}
