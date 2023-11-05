/***********************************************************************
 * Module:  ApplicationProperty.java
 * Author:  Notebook
 * Purpose: Defines the Class ApplicationProperty
 ***********************************************************************/

package model;

import java.awt.Dimension;

public class ApplicationProperty {
   private float positionX;
   private float positionY;
   private Dimension dimension;
   private String language;
   private PropertyParserStrategy parser;
   
	public float getPositionX() {
		return positionX;
	}	
	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}
	
	public float getPositionY() {
		return positionY;
	}
	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}
	public Dimension getDimension() {
		return dimension;
	}
	/** @param newDimension */
	public void setDimension(Dimension newDimension) {
		dimension = newDimension;
	}
   
	public String getLanguage() {
      return language;
	}
   
	/** @param newLanguage */
	public void setLanguage(String newLanguage) {
      language = newLanguage;
	}

	public PropertyParserStrategy getParser() {
		return parser;
	}	
	public void setParser(PropertyParserStrategy parser) {
		this.parser = parser;
	}

   
}