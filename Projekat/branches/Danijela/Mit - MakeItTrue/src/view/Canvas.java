/***********************************************************************
 * Module:  Canvas.java
 * Author:  Notebook
 * Purpose: Defines the Class Canvas
 ***********************************************************************/

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import model.AbstractObject;
import model.CanvasObject;
import model.DifferentViewObject;
import model.Xor;
import view.contextmenu.CanvasContextMenu;

public class Canvas extends JPanel implements MouseMotionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean grid;

	public Canvas() {
		this.grid = true;
		setPreferredSize(new Dimension(10000, 10000));
		setBackground(Color.WHITE);

	}

	public void paint(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.LIGHT_GRAY);

		if (grid) {
			// TUFNE
			/*
			 * for(int i = -10; i < getWidth(); i+=100) { for(int j = -10; j < getHeight();
			 * j+=100) { g.drawRect(i, j, 1, 1); } }
			 */
			/*
			 * for (int i = 0; i < this.getWidth(); i += 12) { g2d.drawLine(i, 0, i,
			 * this.getHeight()); }
			 * 
			 * for (int i = 0; i <= this.getHeight(); i += 12) { g2d.drawLine(0, i,
			 * this.getWidth(), i); }
			 */
			for (int i = -10; i < getWidth(); i += 12) {
				for (int j = -10; j < getHeight(); j += 12) {
					g.drawRect(i, j, 1, 1);
				}
			}

		}

		Graphics2D g2d = (Graphics2D) g;

		DifferentViewObject differentViewObject = new CanvasObject();
		AbstractObject xor = new Xor(10, 10, differentViewObject);

		xor.draw(g2d);
	}

	@Override
	public void setComponentPopupMenu(JPopupMenu popup) {
		super.setComponentPopupMenu(popup);
		((CanvasContextMenu) popup).getMrezaZaCrtanje().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				grid = !grid;
				updateUI();
			}
		});
	}

	private Point calibratePoint(int x, int y) {
		Point point = new Point(x - this.getWidth() / 2, -y + this.getHeight() / 2);
		return point;
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent k) {

	}

}
