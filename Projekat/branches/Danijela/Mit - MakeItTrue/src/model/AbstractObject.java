/***********************************************************************
 * Module:  AbstractObject.java
 * Author:  Notebook
 * Purpose: Defines the Class AbstractObject
 ***********************************************************************/

package model;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;


public abstract class AbstractObject extends Objects {
   private int numberOfPins;
   
    private int xKoordinata;
	private int yKoordinata;

	protected double scaleFactorX = 1;
	protected double scaleFactorY = 1;

	protected double translateFactorX = 0;
	protected double translateFactorY = 0;

	protected double rotateFactor = 0;

	protected int selectionStartingPointX;
	protected int selectionStartingPointY;
	protected int selectionRectX;
	protected int selectionRectY;

	protected Boolean isSelected = false;

	protected String name;
	protected Point2D location;
	protected Dimension2D dimension;
	protected String elementState;
	
	protected Rectangle2D.Double testSelectionRectangle = new Rectangle2D.Double();

	protected Rectangle2D.Double selectionRectangle = new Rectangle2D.Double();
	
	public Point2D.Double input = new Point2D.Double();
	public Point2D.Double output = new Point2D.Double();
	
	

	Color elementColor = new Color(0, 0, 0);
	Color stringColor = new Color(0, 0, 0);
	Color outlineColor = new Color(192, 192, 192);
	
	
	public void setPoint(int xKoordinata, int yKoordinata)
	{
		this.xKoordinata = xKoordinata;
		this.yKoordinata = yKoordinata;
		
		/*
		this.input = new Point2D.Double(x, y+20);
		this.output = new Point2D.Double(x+130, y+40);
		this.input = new Point2D.Double(x, y+40);
		this.output = new Point2D.Double(x+120, y+20);
	    */
	}

	public void drawFigura(Graphics2D g2d)
	{

		draw(g2d);
		AffineTransform currentAT = g2d.getTransform();
		g2d.scale(scaleFactorX, scaleFactorY);
		g2d.rotate(rotateFactor, xKoordinata + (width / 2), yKoordinata + (height / 2));
		testSelectionRectangle.setRect(xKoordinata, yKoordinata, width, height);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0));
		g2d.draw(testSelectionRectangle);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
		g2d.setTransform(currentAT);

	}
   
   
   public void draw(Graphics g) {
      // TODO: implement
   }
   
   public void rotate() {
      // TODO: implement
   }
   
   public void delete() {
      // TODO: implement
   }
   
   public int getNumberOfPins() {
      return numberOfPins;
   }
   
   /** @param newNumberOfPins */
   public void setNumberOfPins(int newNumberOfPins) {
      numberOfPins = newNumberOfPins;
   }
   
   public AbstractObject() {
      // TODO: implement
   }
   
   public float getWidth() {
      // TODO: implement
      return 0;
   }
   
   /** @param newWidth */
   public void setWidth(float newWidth) {
      // TODO: implement
   }
   
   public float getHeight() {
      // TODO: implement
      return 0;
   }
   
   /** @param newHeight */
   public void setHeight(float newHeight) {
      // TODO: implement
   }
   
   public void move() {
      // TODO: implement
   }

}