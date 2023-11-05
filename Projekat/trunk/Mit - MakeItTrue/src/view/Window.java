/***********************************************************************
 * Module:  Window.java
 * Author:  G1
 ***********************************************************************/

package view;

import java.util.Vector;
import java.awt.Container;
import java.awt.Image;
import javax.swing.JFrame;

import model.ApplicationModel;
import observer.Observer;
/**Apstraktna klasa koja definiše osnovne elemete potrebne za kreiranje osnovnog izgleda aplikacije.**/
public abstract class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	/**Kontejner za postavljanje osnovne komponente pogleda.**/
	protected Container contentPane = null;
	/**Komponente pogleda koje korisnik vidi.**/
	private Vector<ViewComponents> viewComponents;
	/**Meni koji korisnik vidi**/
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
	
	public Container getContent()
	{
		return contentPane;
	}
	
	public void setContent(Container cp)
	{
		this.contentPane = cp;
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
				Vector<Observer> diagramObservers = new Vector<Observer>();
				diagramObservers.add(menuBar);
				diagramObservers.add(viewComponents.firstElement());
				Editor gf = new GraficEditor(appModel, diagramObservers);
	
				gf = new ObjectBrowser(gf, menuBar.getViewMenu().getMenuItemObjectBrowser());
				gf = new Toolbox(gf, menuBar.getViewMenu().getMenuItemToolbox());
	
				addViewComponent(gf);
	
				break;
			
		}

	}

}