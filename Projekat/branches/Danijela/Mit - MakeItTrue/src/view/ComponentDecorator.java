/***********************************************************************
 * Module:  ComponentDecorator.java
 * Author:  Notebook
 * Purpose: Defines the Class ComponentDecorator
 ***********************************************************************/

package view;

import java.util.Collection;

import com.javadocking.dock.SplitDock;

import model.Diagram;
import observer.Subject;

public abstract class ComponentDecorator extends Editor {
	protected Editor editor;

	public ComponentDecorator(Editor editor) {
		this.editor = editor;
	}

	public abstract void showComponent();

	public abstract void hideComponent();
	
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