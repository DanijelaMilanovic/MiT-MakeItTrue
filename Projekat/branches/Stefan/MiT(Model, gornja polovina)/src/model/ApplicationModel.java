/***********************************************************************
 * Module:  ApplicationModel.java
 * Author:  Notebook
 * Purpose: Defines the Class ApplicationModel
 ***********************************************************************/

package model;

import java.util.Iterator;
import java.util.Vector;

import obeserver.IObserver;
import obeserver.ISubject;

public class ApplicationModel implements ISubject {
   private ApplicationState currentState;
   private ApplicationProperty applicationProperty;
   private DataExporter dataExporter;
   private DataImporter dataImporter;
   private java.util.Collection<Project> closedProject;
   private java.util.Collection<Project> activeProjects;
   private java.util.Collection<IObserver> observers = new Vector<IObserver>();
   
   public ApplicationModel() {
	this.currentState = new IdleState();
	activeProjects = new Vector<Project>();
	closedProject = new Vector<Project>();
	dataExporter = new DataExporter();
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorActiveProjects() {
      if (activeProjects == null)
         activeProjects = new java.util.Vector<Project>();
      return activeProjects.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newActiveProjects */
   public void setActiveProjects(java.util.Collection<Project> newActiveProjects) {
      removeAllActiveProjects();
      for (java.util.Iterator iter = newActiveProjects.iterator(); iter.hasNext();)
         addActiveProjects((Project)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProject */
   public void addActiveProjects(Project newProject) {
      if (newProject == null)
         return;
      if (this.activeProjects == null)
         this.activeProjects = new java.util.Vector<Project>();
      if (!this.activeProjects.contains(newProject))
         this.activeProjects.add(newProject);
   }
   
   /** @pdGenerated default remove
     * @param oldProject */
   public void removeActiveProjects(Project oldProject) {
      if (oldProject == null)
         return;
      if (this.activeProjects != null)
         if (this.activeProjects.contains(oldProject))
            this.activeProjects.remove(oldProject);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllActiveProjects() {
      if (activeProjects != null)
         activeProjects.clear();
   }
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorClosedProject() {
      if (closedProject == null)
         closedProject = new java.util.Vector<Project>();
      return closedProject.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newClosedProject */
   public void setClosedProject(java.util.Collection<Project> newClosedProject) {
      removeAllClosedProject();
      for (java.util.Iterator iter = newClosedProject.iterator(); iter.hasNext();)
         addClosedProject((Project)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProject */
   public void addClosedProject(Project newProject) {
      if (newProject == null)
         return;
      if (this.closedProject == null)
         this.closedProject = new java.util.Vector<Project>();
      if (!this.closedProject.contains(newProject))
         this.closedProject.add(newProject);
   }
   
   /** @pdGenerated default remove
     * @param oldProject */
   public void removeClosedProject(Project oldProject) {
      if (oldProject == null)
         return;
      if (this.closedProject != null)
         if (this.closedProject.contains(oldProject))
            this.closedProject.remove(oldProject);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllClosedProject() {
      if (closedProject != null)
         closedProject.clear();
   }
   
   /** @param state */
   public void changeState(ApplicationState state) {
      // TODO: implement
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
   
   public void createProject() {
	   this.currentState.createProject(this);
   }
   
   public void openProject() {
      this.currentState.openProject(this);
   }
   
   public void closeProject() {
      this.currentState.closeProject(this);
   }
   
   public void deleteProject() {
      this.currentState.deleteProject(this);
   }

@Override
public void addObserver(IObserver observer) {
	observers.add(observer);
}

@Override
public void removeObserver(IObserver observer) {
	observers.remove(observer);
}

@Override
public void notifyObservers() {
	for (IObserver observer:observers) {
		observer.update(this);
	}	
}

}