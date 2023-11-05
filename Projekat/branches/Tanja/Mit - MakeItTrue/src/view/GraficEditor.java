/***********************************************************************
 * Module:  GraficEditor.java
 * Author:  Notebook
 * Purpose: Defines the Class GraficEditor
 ***********************************************************************/

package view;

import java.awt.BorderLayout;
import java.util.Vector;

import model.Diagram;
import observer.Subject;
import view.editor.CustomTabEditorPane;

public class GraficEditor extends Editor {
	private Vector<Canvas> canvas;
	private CustomTabEditorPane tabPanel;

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
		tabPanel.addTab(newDiagram.getName(), canvas.size() - 1, canvas.get(canvas.size()-1));
	}

	public GraficEditor() {
		super();
		canvas = new Vector<Canvas>();
		tabPanel = new CustomTabEditorPane();
//		tabPanel.setComponentPopupMenu(super.getContextMenu().getContextMenu());
		getContentPane().add(tabPanel, BorderLayout.CENTER);
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		
	}
	
} 
   
