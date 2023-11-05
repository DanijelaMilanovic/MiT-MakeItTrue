/***********************************************************************
 * Module:  CompositeComponent.java
 * Author:  Notebook
 * Purpose: Defines the Class CompositeComponent
 ***********************************************************************/

package view;

import observer.Subject;

public class CompositeComponent extends ViewComponents {
	private java.util.Collection<ViewComponents> components;

	/** @pdGenerated default getter */
	public java.util.Collection<ViewComponents> getComponents() {
		if (components == null)
			components = new java.util.Vector<ViewComponents>();
		return components;
	}

	/** @pdGenerated default iterator getter */
	@SuppressWarnings("rawtypes")
	public java.util.Iterator getIteratorComponents() {
		if (components == null)
			components = new java.util.Vector<ViewComponents>();
		return components.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newComponents
	 */
	@SuppressWarnings("rawtypes")
	public void setComponents(java.util.Collection<ViewComponents> newComponents) {
		removeAllComponents();
		for (java.util.Iterator iter = newComponents.iterator(); iter.hasNext();)
			addComponents((ViewComponents) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newViewComponents
	 */
	public void addComponents(ViewComponents newViewComponents) {
		if (newViewComponents == null)
			return;
		if (this.components == null)
			this.components = new java.util.Vector<ViewComponents>();
		if (!this.components.contains(newViewComponents))
			this.components.add(newViewComponents);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldViewComponents
	 */
	public void removeComponents(ViewComponents oldViewComponents) {
		if (oldViewComponents == null)
			return;
		if (this.components != null)
			if (this.components.contains(oldViewComponents))
				this.components.remove(oldViewComponents);
	}

	/** @pdGenerated default removeAll */
	public void removeAllComponents() {
		if (components != null)
			components.clear();
	}

	public CompositeComponent() {
		// TODO: implement
	}

	public void addComponent() {
		// TODO: implement
	}

	public void removeComponent() {
		// TODO: implement
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub

	}

}