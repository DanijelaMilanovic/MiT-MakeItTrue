/***********************************************************************
 * Module:  Diagram.java
 * Author:  Notebook
 * Purpose: Defines the Class Diagram
 ***********************************************************************/

package model;

public class Diagram {
   private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
   
	public Diagram(String name) {
		this.name = name;
	}
}