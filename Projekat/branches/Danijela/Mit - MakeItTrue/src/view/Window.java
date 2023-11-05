/***********************************************************************
 * Module:  Window.java
 * Author:  Notebook
 * Purpose: Defines the Class Window
 ***********************************************************************/

package view;

import java.util.Vector;
import java.awt.Image;
import javax.swing.JFrame;

import model.ApplicationModel;
import model.Diagram;

public abstract class Window extends JFrame {
	private static final long serialVersionUID = 1L;

	private Vector<ViewComponents> viewComponents;
	private MenuBar menuBar;

	public MenuBar getMenu() {
		return menuBar;
	}

	public Vector<ViewComponents> getViewComponents() {
		return viewComponents;
	}

	public void addViewComponent(ViewComponents viewComponent) {
		viewComponents.add(viewComponent);
	}

	public void removeViewComponent(ViewComponents viewComponent) {
		viewComponents.remove(viewComponent);
	}

	public Window(String type, ApplicationModel appModel) {
		// Podesavanja ikonice
		Image icon = java.awt.Toolkit.getDefaultToolkit().getImage("icons/logo1.png").getScaledInstance(800, 800,
				Image.SCALE_SMOOTH);
		viewComponents = new Vector<ViewComponents>();
		setIconImage(icon);

		switch (type) {
			case "mainFrame":
				menuBar = new MenuBar(appModel);
	
				addViewComponent(new ToolBar(appModel));
	
				addViewComponent(new StatusBar());
	
				// sve super u prikazu
				// rjesiti dobijanje dijagrama
	
				Editor gf = new GraficEditor();
	
				gf = new ObjectBrowser(gf, menuBar.getViewMenu().getMenuItemObjectBrowser());
				gf = new Toolbox(gf, menuBar.getViewMenu().getMenuItemToolbox());
	
				gf.addDiagrams(new Diagram());
				gf.addDiagrams(new Diagram());
	
				addViewComponent(gf);
	
				break;
		}

	}

}