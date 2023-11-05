/***********************************************************************
 * Module:  MenuBar.java
 * Author:  Notebook
 * Purpose: Defines the Class MenuBar
 ***********************************************************************/

package view;

import model.ApplicationModel;
import model.CreateProject;
import view.menu.DiagramMenu;
import view.menu.EditMenu;
import view.menu.HelpMenu;
import view.menu.LanguageMenu;
import view.menu.ProjectMenu;
import view.menu.RepositoryMenu;
import view.menu.SimulationMenu;
import view.menu.ViewMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private ViewMenu viewMenu = null;

	public ViewMenu getViewMenu() {
		return this.viewMenu;
	}

	/** @pdGenerated default getter */
	/*
	 * public java.util.Collection<ExecutableCommand> getExecutableCommand() { if
	 * (executableCommand == null) executableCommand = new
	 * java.util.HashSet<ExecutableCommand>(); return executableCommand; }
	 * 
	 *//** @pdGenerated default iterator getter */
	/*
	 * @SuppressWarnings("rawtypes") public java.util.Iterator
	 * getIteratorExecutableCommand() { if (executableCommand == null)
	 * executableCommand = new java.util.HashSet<ExecutableCommand>(); return
	 * executableCommand.iterator(); }
	 * 
	 *//**
		 * @pdGenerated default setter
		 * @param newExecutableCommand
		 */
	/*
	 * @SuppressWarnings("rawtypes") public void
	 * setExecutableCommand(java.util.Collection<ExecutableCommand>
	 * newExecutableCommand) { removeAllExecutableCommand(); for (java.util.Iterator
	 * iter = newExecutableCommand.iterator(); iter.hasNext();)
	 * addExecutableCommand((ExecutableCommand) iter.next()); }
	 * 
	 *//**
		 * @pdGenerated default add
		 * @param newExecutableCommand
		 */
	/*
	 * public void addExecutableCommand(ExecutableCommand newExecutableCommand) { if
	 * (newExecutableCommand == null) return; if (this.executableCommand == null)
	 * this.executableCommand = new java.util.HashSet<ExecutableCommand>(); if
	 * (!this.executableCommand.contains(newExecutableCommand))
	 * this.executableCommand.add(newExecutableCommand); }
	 * 
	 *//**
		 * @pdGenerated default remove
		 * @param oldExecutableCommand
		 */

	/*
	 * public void removeExecutableCommand(ExecutableCommand oldExecutableCommand) {
	 * if (oldExecutableCommand == null) return; if (this.executableCommand != null)
	 * if (this.executableCommand.contains(oldExecutableCommand))
	 * this.executableCommand.remove(oldExecutableCommand); }
	 * 
	 *//** @pdGenerated default removeAll *//*
											 * public void removeAllExecutableCommand() { if (executableCommand != null)
											 * executableCommand.clear(); }
											 */
	public MenuBar(ApplicationModel appModel) {
		ProjectMenu projectMenu = new ProjectMenu();
		viewMenu = new ViewMenu();

		projectMenu.getMenuItemNoviProjekat().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Provjeriti
				new CreateProject(appModel).execute();
			}
		});
		add(projectMenu);
		add(new DiagramMenu());

		add(viewMenu);
		add(new EditMenu());
		add(new RepositoryMenu());
		add(new SimulationMenu());
		add(new LanguageMenu());
		add(new HelpMenu());
	}

}