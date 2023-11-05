/***********************************************************************
 * Module:  Editor.java
 * Author:  Notebook
 ***********************************************************************/

package view;

import model.ActiveState;
import model.ApplicationModel;
import model.Diagram;
import model.SelectionState;

import java.util.Vector;

import com.javadocking.dock.LineDock;
/**Apstraktna klasa koja definiše radni prostor.**/
public abstract class Editor implements ViewComponents {
	/**Dijagrami koji se nalaze u radnom prostoru**/
	private java.util.Collection<Diagram> diagrams;
	/**Postavljanje linijskog dokinga za komponente dekoracije**/
	private LineDock contentPane;
	/**Aplikacioni model**/
	private ApplicationModel appModel;

	public abstract Vector<Canvas> getCanvas();

	public ApplicationModel getAppModel() {
		return appModel;
	}

	public void setAppModel(ApplicationModel appModel) {
		this.appModel = appModel;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Diagram> getDiagrams() {
		if (diagrams == null)
			diagrams = new java.util.Vector<Diagram>();
		return diagrams;
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
		if (!this.diagrams.contains(newDiagram)) {
			newDiagram.setCurrentState(new SelectionState());
			this.diagrams.add(newDiagram);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldDiagram
	 */
	public void removeDiagram(Diagram oldDiagram) {
		if (oldDiagram == null)
			return;
		if (this.diagrams != null) {
			if (this.diagrams.contains(oldDiagram))
				this.diagrams.remove(oldDiagram);
			if (diagrams.size() == 0) {
				appModel.setCurrentState(new ActiveState());
				appModel.notifyObservers();
			}
		}
	}

	/** @pdGenerated default removeAll */
	public void removeAllDiagrams() {
		if (diagrams != null)
			diagrams.clear();
	}
	/**Metoda kojom se vraæa dijagram koji je trenutno u fokusu**/
	public abstract Diagram getFocusedDiagram();
	
	public LineDock getContentPane() {
		return contentPane;
	}

	public Editor() {
		contentPane = new LineDock();
	}

}