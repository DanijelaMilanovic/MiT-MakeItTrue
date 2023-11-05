/***********************************************************************
 * Module:  Canvas.java
 * Author:  G1 
 ***********************************************************************/

package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
//import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import model.ApplicationModel;
import model.Diagram;
import view.contextmenu.CanvasContextMenu;
/**Klasa koja definiše elemente kanvasa**/
public class Canvas extends JPanel {

	private static final long serialVersionUID = 1L;
	/**Mreža na kanvasu**/
	private boolean grid;
	/**Dijagram koji se trenutno prikazuje**/
	private Diagram diagram;
	/**Naziv komande koja se izvršila na paleti elemenata**/
	private String clicked = "select";
	/**Poèetna taèka seketovanja**/
	public Point sp = null;
	/**Krajnja taèka selektovanja**/
	public Point ep = null;
	/**Prvaougaonik koji selektuje**/
	public Rectangle selector=null;

	
	public String getClicked() {
		return clicked;
	}

	public void setClicked(String clicked) {
		this.clicked = clicked;
	}
	
	public Diagram getDiagram() {
		return diagram;
	}

	public Canvas(Diagram diagram, ApplicationModel appModel) {
		this.grid = true;
		this.diagram = diagram;
		setPreferredSize(new Dimension(10000, 10000));
		setBackground(Color.WHITE);

		
	}
	/**
	 * Metoda za iscrtavanje komponenti na kanvasu
	 * @param g Grafièki kontekst
	 * **/
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
		if(sp == null || ep == null) {
		Graphics2D g2d = (Graphics2D) g;
		diagram.drawDiagram(g2d);
		}
		else {
			Graphics2D g2d=(Graphics2D) g;

			diagram.drawDiagram(g2d);
			int posxmin=Math.min(sp.x, ep.x);
			int posymin=Math.min(sp.y, ep.y);
			int posxmax=Math.max(sp.x, ep.x);
			int posymax=Math.max(sp.y, ep.y);
			selector=new Rectangle(posxmin,posymin,posxmax-posxmin,posymax-posymin);
			g2d.setComposite(AlphaComposite.SrcOver.derive(0.35f));
			g2d.setPaint(Color.gray);
			g2d.fillRect( posxmin,posymin,posxmax-posxmin,posymax-posymin);

		}
		/**/
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
/*
	private Point calibratePoint(int x, int y) {
		Point point = new Point(x - this.getWidth() / 2, -y + this.getHeight() / 2);
		return point;
	}
*/

}
