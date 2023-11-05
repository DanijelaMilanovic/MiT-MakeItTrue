/***********************************************************************
 * Module:  Project.java
 * Author:  G1
 ***********************************************************************/

package model;

import java.util.Vector;
/**Klasa koja definiše osnovna svojstva projekta u aplikaciji. Sadrži sve metode koje su definisane za komande nad dijagramom.**/
public class Project {
	private Vector<Diagram> diagrams;
	private String name;
	private String url;

	private boolean isFocused;

	public Vector<Diagram> getDiagrams() {
		return diagrams;
	}

	public void addDiagram(Diagram newDiagram) {
		diagrams.add(newDiagram);
	}

	public void removeDiagram(Diagram diagram) {
		diagrams.remove(diagram);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDiagrams(Vector<Diagram> diagrams) {
		this.diagrams = diagrams;
	}

	public boolean isFocused() {
		return isFocused;
	}

	public void setFocused(boolean isFocused) {
		this.isFocused = isFocused;
	}

	public Project(String name, String url) {
		this.name = name;
		this.url = url;
		this.isFocused = false;
		diagrams = new Vector<Diagram>();
	}

	public void createDiagram(String diagramName) {
		getDiagrams().add(new Diagram(diagramName));
	}

	public void openDiagram() {
		// TODO: implement
	}

	public void closeDiagram() {
		// TODO: implement
	}

	public void deleteDiagram() {
		// TODO: implement
	}

	public void saveDiagram() {
		// TODO: implement
	}

	public void renameDiagram() {

	}

	@Override
	public String toString() {
		return name;
	}
}