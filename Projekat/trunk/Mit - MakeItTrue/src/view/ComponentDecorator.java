/***********************************************************************
 * Module:  ComponentDecorator.java
 * Author:  G1
 ***********************************************************************/

package view;

import java.util.Collection;
import java.util.Vector;

import com.javadocking.dock.LineDock;

import model.ApplicationModel;
import model.Diagram;
import observer.Subject;
/** Apstraktna klasa koja definiše dekoracije radne površine**/
public abstract class ComponentDecorator extends Editor {
	/**Radna površina na koju se stavljaju dekoracije**/
	protected Editor editor;

	public ComponentDecorator(Editor editor) {
		this.editor = editor;
	}
	/**Metoda za prikaz komponenti dekorcije**/
	public abstract void showComponent();
	/**Metoda za skrivanje komponeti dekoracije**/
	public abstract void hideComponent();

	@Override
	public Diagram getFocusedDiagram() {
		return editor.getFocusedDiagram();
	}
	
	@Override
	public ApplicationModel getAppModel() {
		// TODO Auto-generated method stub
		return editor.getAppModel();
	}
	
	@Override
	public LineDock getContentPane() {
		// TODO Auto-generated method stub
		return editor.getContentPane();
	}
	
	@Override
	public Vector<Canvas> getCanvas() {
		return editor.getCanvas();
	}
	
	@Override
	public void addDiagrams(Diagram newDiagram) {
		editor.addDiagrams(newDiagram);
	}
	
	@Override
	public Collection<Diagram> getDiagrams() {
		return editor.getDiagrams();
	}
	
	@Override
	public void update(Subject subject) {
		editor.update(subject);		
	}

}