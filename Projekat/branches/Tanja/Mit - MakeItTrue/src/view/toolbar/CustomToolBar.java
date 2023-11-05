package view.toolbar;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class CustomToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ToolBarProjectButtons toolBarProjectButtons = null;
	private ToolBarDiagramButtons toolBarDiagramButtons = null;
	private ToolBarEditSelectedElementsButtons toolBarEditSelectedElementsButtons = null;
	private ToolBarUndoRedoButtons toolBarUndoRedoButtons = null;
	private ToolBarSimulationButtons toolBarSimulationButtons = null;

	public ToolBarProjectButtons getToolBarProjectButtons() {
		return toolBarProjectButtons;
	}

	public ToolBarDiagramButtons getToolBarDiagramButtons() {
		return toolBarDiagramButtons;
	}

	public ToolBarEditSelectedElementsButtons getToolBarEditSelectedElementsButtons() {
		return toolBarEditSelectedElementsButtons;
	}

	public ToolBarUndoRedoButtons getToolBarUndoRedoButtons() {
		return toolBarUndoRedoButtons;
	}

	public ToolBarSimulationButtons getToolBarSimulationButtons() {
		return toolBarSimulationButtons;
	}

	public CustomToolBar() {
		toolBarProjectButtons = new ToolBarProjectButtons();
		toolBarDiagramButtons = new ToolBarDiagramButtons();
		toolBarEditSelectedElementsButtons = new ToolBarEditSelectedElementsButtons();
		toolBarUndoRedoButtons = new ToolBarUndoRedoButtons();
		toolBarSimulationButtons = new ToolBarSimulationButtons();

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
}
