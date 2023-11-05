/***********************************************************************
 * Module:  GraficEditor.java
 * Author:  Notebook
 * Purpose: Defines the Class GraficEditor
 ***********************************************************************/

package view;

import java.util.Vector;
import java.awt.*;

import com.javadocking.dock.LineDock;
import com.javadocking.dock.Position;
import com.javadocking.dock.SingleDock;
import com.javadocking.dock.SplitDock;
import com.javadocking.dock.TabDock;
import com.javadocking.dockable.DefaultDockable;
import com.javadocking.dockable.Dockable;
import com.javadocking.dockable.DockingMode;

import model.Diagram;
import observer.Subject;
import view.editor.CustomTabEditorPane;

public class GraficEditor extends Editor {
	private Vector<Canvas> canvas;
	private CustomTabEditorPane tabPanel;
	private Dockable dock;

	public Vector<Canvas> getCanvas() {
		return canvas;
	}

	public void setCanvas(Vector<Canvas> canvas) {
		this.canvas = canvas;
	}

	public CustomTabEditorPane getTabPanel() {
		return tabPanel;
	}

	public void setTabPanel(CustomTabEditorPane tabPanel) {
		this.tabPanel = tabPanel;
	}

	
	@Override
	public void addDiagrams(Diagram newDiagram) {
		// TODO Auto-generated method stub
		super.addDiagrams(newDiagram);

		canvas.add(new Canvas());
		(canvas.get(canvas.size() - 1)).setComponentPopupMenu(new ContextMenu("Canvas").getContextMenu());
		tabPanel.addTab(newDiagram.getName(), canvas.size() - 1, canvas.get(canvas.size() - 1));
	}

	public GraficEditor() {
		super();
		canvas = new Vector<Canvas>();
		tabPanel = new CustomTabEditorPane();
		dock = new DefaultDockable("dock1", tabPanel, "GraphicEditor", null, DockingMode.ALL);
		LineDock editorTabDock = new LineDock();
		editorTabDock.addDockable(dock, new Position(0));
		editorTabDock.setPreferredSize(new Dimension(600,0));
		editorTabDock.setMaximumSize(new Dimension(600,0));
		//SplitDock center = new SplitDock();
		//center.addChildDock(editorTabDock, new Position(Position.CENTER));
		//center.setDividerLocation((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3);
//		tabPanel.setComponentPopupMenu(super.getContextMenu().getContextMenu());
		getContentPane().addChildDock(editorTabDock, new Position(Position.CENTER));
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub

	}

}
