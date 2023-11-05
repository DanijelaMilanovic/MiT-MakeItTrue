/***********************************************************************
 * Module:  Project.java
 * Author:  Notebook
 * Purpose: Defines the Class Project
 ***********************************************************************/

package model;

public class Project {
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Project(String name) {
		super();
		this.name = name;
	}
	
	
}