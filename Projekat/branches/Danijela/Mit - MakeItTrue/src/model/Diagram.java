/***********************************************************************
 * Module:  Diagram.java
 * Author:  Notebook
 * Purpose: Defines the Class Diagram
 ***********************************************************************/

package model;

import java.util.Vector;

import observer.Observer;

public class Diagram implements observer.Subject {
	private DiagramEditingState currentState;
	private Vector<Objects> elements;
	private String name;

	public Vector<Objects> getElements() {
		return elements;
	}

	public void addElement(Objects newElement) {
		elements.add(newElement);
	}

	public void removeElement(Objects element) {
		elements.remove(element);
	}

	public DiagramEditingState getCurrentState() {
		return currentState;
	}

	/** @param newCurrentState */
	public void setCurrentState(DiagramEditingState newCurrentState) {
		currentState = newCurrentState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Diagram() {
		name = "test";
	}

	public Diagram(String name) {
		this.name = name;
		elements = new Vector<Objects>();
		// ovdje treba inicijalizovati kolekciju elemenata
	}

	public void drawDiagram() {
		// TODO: implement
	}

	public void setMemento() {
		// TODO: implement
	}

	public void createMemento() {
		// TODO: implement
	}

	@Override
	public void attach(Observer observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void detach(Observer observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub

	}

}