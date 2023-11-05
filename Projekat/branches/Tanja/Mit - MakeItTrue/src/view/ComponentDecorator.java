/***********************************************************************
 * Module:  ComponentDecorator.java
 * Author:  Notebook
 * Purpose: Defines the Class ComponentDecorator
 ***********************************************************************/

package view;

public abstract class ComponentDecorator extends Editor {
	protected Editor editor;
	
	public ComponentDecorator(Editor editor) {
		this.editor = editor;
	}

	public abstract void showComponent();

	public abstract void hideComponent();

}