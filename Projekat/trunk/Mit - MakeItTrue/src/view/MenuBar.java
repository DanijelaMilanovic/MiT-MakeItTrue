/***********************************************************************
 * Module:  MenuBar.java
 * Author:  G1
 ***********************************************************************/

package view;

import model.ActiveState;
import model.ApplicationModel;
import model.ApplicationState;
import model.Diagram;
import model.EditingState;
import model.IdleState;
import model.memento.History;
import observer.Subject;
import view.menu.DiagramMenu;
import view.menu.EditMenu;
import view.menu.HelpMenu;
import view.menu.LanguageMenu;
import view.menu.ProjectMenu;
import view.menu.RepositoryMenu;
import view.menu.SimulationMenu;
import view.menu.ViewMenu;

import javax.swing.JMenuBar;
/**Klasa koja definiše podmenije koji èine meni **/
public class MenuBar extends JMenuBar implements observer.Observer {

	private static final long serialVersionUID = 1L;
	/**podmeni za rad sa projektima**/
	private ProjectMenu projectMenu = null;
	/**podmeni za rad sa dijagramima**/
	private DiagramMenu diagramMenu = null;
	/**podmeni za rad sa elementima pogleda**/
	private ViewMenu viewMenu = null;
	/**podmeni za rad sa elementima koji se mjenjaju**/
	private EditMenu editMenu = null;
	/**podmeni za rad sa repozitorijumom**/
	private RepositoryMenu repositoryMenu = null;
	/**podmeni za rad sa simulacijom**/
	private SimulationMenu simulationMenu = null;
	/**podmeni za rad sa izborom jezika**/
	private LanguageMenu languageMenu = null;
	/**podmeni za rad sa opcijama za pomoæ**/
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
		languageMenu = new LanguageMenu(appModel);
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

	@Override
	public void update(Subject subject) {
		if(subject instanceof ApplicationModel) {
		ApplicationState state = ((ApplicationModel) subject).getCurrentState();

		if (state.getClass() == IdleState.class) {
			diagramMenu.disableMenu();
			editMenu.disableMenu();
			simulationMenu.disableMenu();
		} else if (state.getClass() == ActiveState.class) {
			diagramMenu.enableMenu();
			editMenu.disableMenu();
			simulationMenu.enableMenu();
		} else if (state.getClass() == EditingState.class) {
			diagramMenu.enableMenu();
			simulationMenu.enableMenu();
		}}
		else if(subject instanceof Diagram) {
			History diagramHistory = ((Diagram) subject).getHistory();
			if(!diagramHistory.isActive()) {
				editMenu.disableMenu();
			}
			else {
				editMenu.enableMenu();
			}
		}
		this.updateUI();
	}

}