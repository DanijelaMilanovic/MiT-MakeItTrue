/***********************************************************************
 * Module:  ToolBar.java
 * Author:  Notebook
 * Purpose: Defines the Class ToolBar
 ***********************************************************************/

package view;

import javax.swing.JButton;
import javax.swing.JToolBar;

import model.ApplicationModel;

import observer.Subject;
import view.toolbar.ToolBarDiagramButtons;
import view.toolbar.ToolBarEditSelectedElementsButtons;
import view.toolbar.ToolBarProjectButtons;
import view.toolbar.ToolBarSimulationButtons;
import view.toolbar.ToolBarUndoRedoButtons;

public class ToolBar extends JToolBar implements ViewComponents {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ToolBarProjectButtons toolBarProjectButtons = null;
	private ToolBarDiagramButtons toolBarDiagramButtons = null;
	private ToolBarEditSelectedElementsButtons toolBarEditSelectedElementsButtons = null;
	private ToolBarUndoRedoButtons toolBarUndoRedoButtons = null;
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
		// TODO Auto-generated method stub

	}

}