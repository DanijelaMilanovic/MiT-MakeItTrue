/***********************************************************************
 * Module:  ElementMouseListener.java
 * Author:  G1
 ***********************************************************************/
package listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.SwingUtilities;

import model.AbstractObject;
import model.ApplicationModel;
import model.CanvasObject;
import model.CompositeLine;
import model.Diagram;
import model.DifferentViewObject;
import model.Group;
import model.Line;
import model.Objects;
import model.SelectionDecorator;
import model.commands.AddElement;
import model.elements.Or;
import model.elements.Xor;
import view.Canvas;
/**Klasa osluškivaèa dogaðaja koja je vezana za bilo koji dogaðaj koji je nastao na kanvasu od strane miša.**/
public class ElementMouseListener implements MouseListener, MouseMotionListener {

	Diagram diagram;
	Canvas canvas;
	
	Point p1 = new Point();
	Point p2 = new Point();
	Point p3 = null;
	Point p4 = null;
	Group groupElement = null;
	Point startPoint = null;
	int count = 0;
	boolean found = false;
	private ApplicationModel appModel;
	
	DifferentViewObject differentViewObject = new CanvasObject();
	Vector<Point> allPoints = new Vector<>();
	Vector<SelectionDecorator> selectedObjects = new Vector<>();
	Vector<Objects> selectingObjects = new Vector<>();
	Vector<Objects> groupObjects = new Vector<>();


	public ElementMouseListener(Diagram diagram, Canvas canvas, ApplicationModel appModel) {
		this.diagram = diagram;
		this.canvas = canvas;
		this.appModel = appModel;
	}
	/**Metoda resetovanje objekata selekcije.**/
	public void reset() {
		this.selectedObjects.clear();
		this.selectingObjects.clear();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		System.out.println(canvas.getClicked());
		if (SwingUtilities.isLeftMouseButton(e)) {
			switch (canvas.getClicked()) {
		case "xor":
				AbstractObject xor = new Xor(e.getX(), e.getY(), differentViewObject);

				allPoints.add(xor.getPin1());
				allPoints.add(xor.getPin2());
				allPoints.add(xor.getExitPin());

				new AddElement(appModel, xor).execute();
				break;
		case "select":
				boolean isOut = true;

				for (Objects object : diagram.getElements()) {
					if(!object.isSelected()) {
					if ((e.getX() < object.getPoint().getX() + 80) && (e.getX() > object.getPoint().getX())
							&& (e.getY() < object.getPoint().getY() + 50) && (e.getY() > object.getPoint().getY())) {
						SelectionDecorator dec = new SelectionDecorator(object);
						selectingObjects.add(object);
						selectedObjects.add(dec);
						isOut = false;
					}
				}
				}
				if (!isOut) {
					diagram.getElements().add(selectedObjects.lastElement());
					diagram.removeElement(selectingObjects.lastElement());
				}

				if (isOut) {
					for (SelectionDecorator object : selectedObjects) {
						Objects obj = object.getObject();
						diagram.getElements().add(obj);
						diagram.removeElement(object);
					}
					selectedObjects.clear();
					if(groupElement!=null) {
						for (Objects add : groupObjects) {
							diagram.addElement(add);
						}
						groupElement = null;
					}
				}

				break;
			case "line":
				switch (count) {
				case 0:
					System.out.println("E      " + e.getPoint());
					if (isPin(e)) {
						p1.x = e.getX();
						p1.y = e.getY();
						count++;
					}
					break;
				case 1:
					if (isPin(e)) {
						count = 0;
						found = true;
						p2.x = e.getX();
						p2.y = e.getY();
					}
					if (found) {
						CompositeLine relations = new CompositeLine();
						Line line = new Line(p1.x, p1.y, (p1.x + p2.x) / 2, p1.y);
						Line line2 = new Line((p1.x + p2.x) / 2, p1.y, (p1.x + p2.x) / 2, p2.y);
						Line line3 = new Line((p1.x + p2.x) / 2, p2.y, p2.x, p2.y);

						relations.add(line);
						relations.add(line2);
						relations.add(line3);
						found = false;
						new AddElement(appModel, relations).execute();
						System.out.println("Tacka p1" + p1);
						System.out.println("Tacka p2" + p2);

					} else {
						p2 = new Point();
					}
					break;
				}
				break;
			case "or":
				AbstractObject or = new Or(e.getX(), e.getY(), differentViewObject);

				allPoints.add(or.getPin1());
				allPoints.add(or.getPin2());
				allPoints.add(or.getExitPin());

				new AddElement(appModel, or).execute();
				break;
			}
			canvas.repaint();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		canvas.sp = new Point(e.getX(),e.getY());

		int x = (int) e.getX();
		int y = (int) e.getY();
		startPoint = new Point();
		startPoint.x = x;
		startPoint.y = y;

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		p3 = new Point();
		p4 = new Point();

		p4.x = startPoint.x;
		p4.y = e.getY();

		p3.x = e.getX();
		p3.y = startPoint.y;
		
		if (SwingUtilities.isLeftMouseButton(e)) {
			switch (canvas.getClicked()) {
			case "select":
				groupElement = new Group();
				groupObjects = new Vector<>();

				for (Objects object : diagram.getElements()) {
					if (object.getPoint().getX() < p3.x && object.getPoint().getX() > startPoint.x
							&& object.getPoint().getY() > startPoint.y && object.getPoint().getX() < p4.y) {
						groupElement.add(object);
						groupObjects.add(object);
						
						found = true;
					}
				}
				if (found) {
					found = false;
					SelectionDecorator dec = new SelectionDecorator(groupElement);
					diagram.getElements().add(dec);
				
					selectedObjects.add(dec);
					
					for (Objects obj : groupObjects) {
						diagram.removeElement(obj);
					}
				}
				break;
			}
		}
		canvas.sp = null;
		canvas.ep = null;
		canvas.repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println(e.getPoint());
		canvas.ep = new Point(e.getX(),e.getY());
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
	/**Metoda koja ispituje da li je taèka koja je kliknuta jedna od pinova elementa.
	 * @param e - dogaðaj klika koji se ispituje.
	 * @return true/false – vraæa boolean vrijedost u zavisnosti da li je kliknuto na pin ili ne.
	 * **/
	public boolean isPin(MouseEvent e) {
		for (Point point : allPoints) {
			System.out.println(point);
			if ((e.getX() < point.getX() + 9) && (e.getX() > point.getX() - 9) && (e.getY() < point.getY() + 9)
					&& (e.getY() > point.getY() - 9)) {
				return true;
			}
		}
		return false;
	}

}
