/***********************************************************************
 * Module:  ToolBar.java
 * Author:  G1
 ***********************************************************************/

package view;

import javax.swing.JButton;
import javax.swing.JToolBar;

import model.ActiveState;
import model.ApplicationModel;
import model.ApplicationState;
import model.Diagram;
import model.EditingState;
import model.IdleState;
import model.memento.History;
import observer.Subject;
import view.toolbar.ToolBarDiagramButtons;
import view.toolbar.ToolBarEditSelectedElementsButtons;
import view.toolbar.ToolBarProjectButtons;
import view.toolbar.ToolBarSimulationButtons;
import view.toolbar.ToolBarUndoRedoButtons;
/**Klasa koja definiše paletu alatki**/
public class ToolBar extends JToolBar implements ViewComponents {

	private static final long serialVersionUID = 1L;
	/**element palete alatki za projekte**/
	private ToolBarProjectButtons toolBarProjectButtons = null;
	/**element palete alatki za dijagrame**/
	private ToolBarDiagramButtons toolBarDiagramButtons = null;
	/**element palete alatki za uedjivanje oznaèenog elementa**/
	private ToolBarEditSelectedElementsButtons toolBarEditSelectedElementsButtons = null;
	/**element palete alatki za kontrolu elemenata**/
	private ToolBarUndoRedoButtons toolBarUndoRedoButtons = null;
	/**element palete alatki za simulaciju**/
	private ToolBarSimulationButtons toolBarSimulationButtons = null;

	public ToolBar(ApplicationModel appModel) {
		toolBarProjectButtons = new ToolBarProjectButtons(appModel);
		toolBarDiagramButtons = new ToolBarDiagramButtons(appModel);
		toolBarEditSelectedElementsButtons = new ToolBarEditSelectedElementsButtons(appModel);
		toolBarUndoRedoButtons = new ToolBarUndoRedoButtons(appModel);
		toolBarSimulationButtons = new ToolBarSimulationButtons(appModel);

		setRollover(true);
		setBorderPainted(true);
		setFloatable(true);

		for (JButton btn : toolBarProjectButtons.getToolBarProjectButtons()) {
			add(btn);
		}
		addSeparator();
		for (JButton btn : toolBarDiagramButtons.getToolBarDiagramButtons()) {
			add(btn);
		}
		addSeparator();
		for (JButton btn : toolBarEditSelectedElementsButtons.getToolBarEditSelectedElementsButtons()) {
			add(btn);
		}
		addSeparator();
		for (JButton btn : toolBarUndoRedoButtons.getToolBarUndoRedoButtons()) {
			add(btn);
		}
		addSeparator();
		for (JButton btn : toolBarSimulationButtons.getToolBarSimulationButtons()) {
			add(btn);
		}

	}

	@Override
	public void update(Subject subject) {
		if (subject instanceof ApplicationModel) {
			ApplicationState state = ((ApplicationModel) subject).getCurrentState();

			if (state.getClass() == IdleState.class) {
				toolBarDiagramButtons.disableButtons();
				toolBarEditSelectedElementsButtons.disableButtons();
				toolBarSimulationButtons.disableButtons();
				toolBarUndoRedoButtons.disableButtons();
			} else if (state.getClass() == ActiveState.class) {
				toolBarDiagramButtons.enableButtons();
				toolBarEditSelectedElementsButtons.disableButtons();
				toolBarSimulationButtons.disableButtons();
				toolBarUndoRedoButtons.disableButtons();
			} else if (state.getClass() == EditingState.class) {
				toolBarDiagramButtons.enableButtons();
				toolBarEditSelectedElementsButtons.enableButtons();
				toolBarSimulationButtons.enableButtons();
			}
		}
		else if (subject instanceof Diagram){
			History diagramHistory = ((Diagram) subject).getHistory();
			if(!diagramHistory.isActive()) {
				for (JButton btn : toolBarUndoRedoButtons.getToolBarUndoRedoButtons()) {
					btn.setEnabled(false);
				}
			}
			else {
				for (JButton btn : toolBarUndoRedoButtons.getToolBarUndoRedoButtons()) {
					btn.setEnabled(true);
				}
			}
		}
	}

}