/***********************************************************************
 * Module:  Diagram.java
 * Author:  G1
 ***********************************************************************/

package model;

import java.awt.Graphics2D;
import java.util.Vector;

import model.memento.History;
import observer.Observer;
/**Klasa koja definiše osnovne elemente dijagrama. Sadrži sve metode iz interfejsa koji implementira. **/
public class Diagram implements observer.Subject {
	private DiagramEditingState currentState;
	private Vector<Objects> elements;
	private String name;
	private boolean isActive;
	private Vector<Observer> observers;

	private History history;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public History getHistory() {
		return history;
	}
	
	public Vector<Objects> getElements() {
		return elements;
	}

	public void addElement(Objects newElement) {
		this.currentState.addElement(this, newElement);
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
		isActive = false;
		this.name = name;
		elements = new Vector<Objects>();
		observers = new Vector<Observer>();
		history = new History();
	}

	public void drawDiagram(Graphics2D g2d) {
		for (Objects objects : elements) {
			objects.draw(g2d);
		}
	}
/**Metoda za izvršavanje komande nad dijagramom.
 * @param command - komanda koja se izvršava.**/
	public void execute(AbstractExecutableCommand command) {
		history.push(command, new Memento(this));
	}
	/**Metoda za vraæanje na prethodni korak.**/
	public void undo() {
		history.undo();
	}
	/**Metoda za poništavanja vraæanja na prethodni korak.**/
	public void redo() {
		history.redo();
	}

	@SuppressWarnings("unchecked")
	public Vector<Objects> backup() {
		return (Vector<Objects>) elements.clone();
	}
	public void restore(Vector<Objects> obj) {
		this.elements = obj;
	}

	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer: observers) {
			observer.update(this);
		}
	}

	@Override
	public String toString() {
		return name;
	}
}