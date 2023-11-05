/***********************************************************************
 * Module:  MenuBar.java
 * Author:  Notebook
 * Purpose: Defines the Class MenuBar
 ***********************************************************************/

package view;

import model.ApplicationModel;

import view.menu.DiagramMenu;
import view.menu.EditMenu;
import view.menu.HelpMenu;
import view.menu.LanguageMenu;
import view.menu.ProjectMenu;
import view.menu.RepositoryMenu;
import view.menu.SimulationMenu;
import view.menu.ViewMenu;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	private ProjectMenu projectMenu = null;
	private DiagramMenu diagramMenu = null;
	private ViewMenu viewMenu = null;
	private EditMenu editMenu = null;
	private RepositoryMenu repositoryMenu = null;
	private SimulationMenu simulationMenu = null;
	private LanguageMenu languageMenu = null;
	private HelpMenu helpMenu = null;

	public ProjectMenu getProjectMenu() {
		return projectMenu;
	}

	public DiagramMenu getDiagramMenu() {
		return diagramMenu;
	}

	public ViewMenu getViewMenu() {
		return viewMenu;
	}

	public EditMenu getEditMenu() {
		return editMenu;
	}

	public RepositoryMenu getRepositoryMenu() {
		return repositoryMenu;
	}

	public SimulationMenu getSimulationMenu() {
		return simulationMenu;
	}

	public LanguageMenu getLanguageMenu() {
		return languageMenu;
	}

	public HelpMenu getHelpMenu() {
		return helpMenu;
	}

	public MenuBar(ApplicationModel appModel) {
		projectMenu = new ProjectMenu(appModel);
		diagramMenu = new DiagramMenu(appModel);
		viewMenu = new ViewMenu();
		editMenu = new EditMenu(appModel);
		repositoryMenu = new RepositoryMenu();
		simulationMenu = new SimulationMenu();
		languageMenu = new LanguageMenu();
		helpMenu = new HelpMenu();

		add(projectMenu);
		add(diagramMenu);
		add(viewMenu);
		add(editMenu);
		add(repositoryMenu);
		add(simulationMenu);
		add(languageMenu);
		add(helpMenu);
	}

}