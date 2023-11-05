/***********************************************************************
 * Module:  ApplicationModel.java
 * Author:  Notebook
 * Purpose: Defines the Class ApplicationModel
 ***********************************************************************/

package model;

import java.util.Vector;
import observer.Observer;
/**Klasa za definisanje modela aplikacije.
 *  Sadrži sve metode koje postavlja interfejs za stanja aplikacije koje se pozivaju kroz ovu klasu. 
 *  Kao I predefinisane sve metode iz interfejsa kog implementira.**/

public class ApplicationModel implements observer.Subject {
	private ApplicationState currentState;
	private ApplicationProperty applicationProperty;
	private DataExporter dataExporter;
	private DataImporter dataImporter;
	private java.util.Vector<Project> closedProjects;
	private java.util.Vector<Project> activeProjects;
	private java.util.Vector<Observer> observers;

	public java.util.Vector<Project> getActiveProjects() {
		return activeProjects;
	}

	public java.util.Vector<Project> getClosedProject() {
		return closedProjects;
	}

	public void addActiveProject(Project newProject) {
		activeProjects.add(newProject);
	}

	public void removeActiveProject(Project project) {
		activeProjects.remove(project);
	}

	public void addClosedProject(Project newClosedProject) {
		closedProjects.add(newClosedProject);
	}

	public void removeClosedProject(Project project) {
		closedProjects.remove(project);
	}

	public ApplicationState getCurrentState() {
		return currentState;
	}

	/** @param newCurrentState */
	public void setCurrentState(ApplicationState newCurrentState) {
		currentState = newCurrentState;
	}

	public ApplicationProperty getApplicationProperty() {
		return applicationProperty;
	}

	/** @param newApplicationProperty */
	public void setApplicationProperty(ApplicationProperty newApplicationProperty) {
		applicationProperty = newApplicationProperty;
	}

	public DataExporter getDataExporter() {
		return dataExporter;
	}

	/** @param newDataExporter */
	public void setDataExporter(DataExporter newDataExporter) {
		dataExporter = newDataExporter;
	}

	public DataImporter getDataImporter() {
		return dataImporter;
	}

	/** @param newDataImporter */
	public void setDataImporter(DataImporter newDataImporter) {
		dataImporter = newDataImporter;
	}

	public ApplicationModel() {
		this.currentState = new IdleState();
		this.activeProjects = new Vector<Project>();
		this.closedProjects = new Vector<Project>();
		this.dataExporter = new DataExporter("XML");
		this.dataImporter = new DataImporter("XML");
		this.applicationProperty = new ApplicationProperty("XML");
		this.observers = new Vector<Observer>();
	}

	public void createProject(String url) {
		this.currentState.createProject(this, url);
	}

	public void openProject(String url) {
		this.currentState.openProject(this, url);
	}

	public void closeProject() {
		this.currentState.closeProject(this);
	}

	public void deleteProject() {
		this.currentState.deleteProject(this);
	}

	public void saveProject(Project project) {
		this.currentState.saveProject(this, project);
	}

	public void saveAsProject() {
		this.currentState.saveAsProject(this);
	}

	public void renameProject() {
		this.currentState.renameProject(this);
	}

	public boolean existProject(String url) {
		for (Project project : activeProjects) {
			if(url.equals(project.getUrl()))
				return true;
		}
		for (Project project : closedProjects) {
			if(url.equals(project.getUrl()))
				return true;
		}
		return false;
	}
	
	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}

}