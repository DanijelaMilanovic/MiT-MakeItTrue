/***********************************************************************
 * Module:  Editor.java
 * Author:  Notebook
 * Purpose: Defines the Class Editor
 ***********************************************************************/

package view;

import model.Diagram;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.javadocking.dock.SplitDock;

public abstract class Editor implements ViewComponents {
	private java.util.Collection<Diagram> diagrams;
	private SplitDock contentPane;

	public ContextMenu getContextMenuForCanvas() {
		return new ContextMenu("Canvas");
	}

	public ContextMenu getContextMenuForToolbox() {
		return new ContextMenu("Toolbox");
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Diagram> getDiagrams() {
		if (diagrams == null)
			diagrams = new java.util.Vector<Diagram>();
		return diagrams;
	}

	/** @pdGenerated default iterator getter */
	@SuppressWarnings("rawtypes")
	public java.util.Iterator getIteratorDiagrams() {
		if (diagrams == null)
			diagrams = new java.util.Vector<Diagram>();
		return diagrams.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newDiagrams
	 */
	@SuppressWarnings("rawtypes")
	public void setDiagrams(java.util.Collection<Diagram> newDiagrams) {
		removeAllDiagrams();
		for (java.util.Iterator iter = newDiagrams.iterator(); iter.hasNext();)
			addDiagrams((Diagram) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newDiagram
	 */
	public void addDiagrams(Diagram newDiagram) {
		if (newDiagram == null)
			return;
		if (this.diagrams == null)
			this.diagrams = new java.util.Vector<Diagram>();
		if (!this.diagrams.contains(newDiagram))
			this.diagrams.add(newDiagram);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldDiagram
	 */
	public void removeDiagrams(Diagram oldDiagram) {
		if (oldDiagram == null)
			return;
		if (this.diagrams != null)
			if (this.diagrams.contains(oldDiagram))
				this.diagrams.remove(oldDiagram);
	}

	/** @pdGenerated default removeAll */
	public void removeAllDiagrams() {
		if (diagrams != null)
			diagrams.clear();
	}

	public SplitDock getContentPane() {
		return contentPane;
	}
/*
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
*/
	public Editor() {
		contentPane = new SplitDock();
		//contentPane.setLayout(new BorderLayout());
	}

}