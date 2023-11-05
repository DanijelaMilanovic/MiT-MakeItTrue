/***********************************************************************
 * Module:  Window.java
 * Author:  Notebook
 * Purpose: Defines the Class Window
 ***********************************************************************/

package view;

import java.awt.Image;
import javax.swing.JFrame;

import model.ApplicationModel;
import model.Diagram;

public abstract class Window extends JFrame {
	private static final long serialVersionUID = 1L;

	private java.util.Collection<ViewComponents> viewComponents;
	private MenuBar menuBar;

	public MenuBar getMenu() {
		return menuBar;
	}

	public void setMenu(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<ViewComponents> getViewComponents() {
		if (viewComponents == null)
			viewComponents = new java.util.Vector<ViewComponents>();
		return viewComponents;
	}

	/** @pdGenerated default iterator getter */
	@SuppressWarnings("rawtypes")
	public java.util.Iterator getIteratorViewComponents() {
		if (viewComponents == null)
			viewComponents = new java.util.Vector<ViewComponents>();
		return viewComponents.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newViewComponents
	 */
	@SuppressWarnings("rawtypes")
	public void setViewComponents(java.util.Collection<ViewComponents> newViewComponents) {
		removeAllViewComponents();
		for (java.util.Iterator iter = newViewComponents.iterator(); iter.hasNext();)
			addViewComponents((ViewComponents) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newViewComponents
	 */
	public void addViewComponents(ViewComponents newViewComponents) {
		if (newViewComponents == null)
			return;
		if (this.viewComponents == null)
			this.viewComponents = new java.util.Vector<ViewComponents>();
		if (!this.viewComponents.contains(newViewComponents))
			this.viewComponents.add(newViewComponents);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldViewComponents
	 */
	public void removeViewComponents(ViewComponents oldViewComponents) {
		if (oldViewComponents == null)
			return;
		if (this.viewComponents != null)
			if (this.viewComponents.contains(oldViewComponents))
				this.viewComponents.remove(oldViewComponents);
	}

	/** @pdGenerated default removeAll */
	public void removeAllViewComponents() {
		if (viewComponents != null)
			viewComponents.clear();
	}

	public Window(String type, ApplicationModel appModel) {
		// Podesavanja ikonice
		Image icon = java.awt.Toolkit.getDefaultToolkit().getImage("icons/logo1.png").getScaledInstance(800, 800,
				Image.SCALE_SMOOTH);
		setIconImage(icon);

		switch (type) {
		case "mainFrame":
			menuBar = new MenuBar(appModel);

			addViewComponents(new ToolBar(appModel));

			addViewComponents(new StatusBar());

			// promjeniti imena: varijabla gf sadrzi samo kanvas
			// varijabla toolbox sadrzi i kanvas i toolbox
			// varijabla ob sadrzi sve isto sto i varijabla toolbox plus object browser

			Editor gf = new GraficEditor();

			gf.addDiagrams(new Diagram());
			gf.addDiagrams(new Diagram());
			gf = new Toolbox(gf, menuBar.getViewMenu().getMenuItemToolbox());
			gf = new ObjectBrowser(gf, menuBar.getViewMenu().getMenuItemObjectBrowser());

			addViewComponents(gf);

			break;
		}

	}

}