package model.commands;

import java.awt.Point;
import java.util.Vector;

import listeners.ElementMouseListener;
import model.AbstractExecutableCommand;
import model.ApplicationModel;
import model.CompositeLine;
import model.Diagram;
import model.Line;
import model.Objects;
import model.Project;
import model.Relation;
import model.SelectionState;

/**
 * 
 * Klasa koja realizuje brisanje elementa sa dijagrama
 *
 */
public class DeleteObjects extends AbstractExecutableCommand{

	Diagram activeDiagram;
	Vector<Project> activeP;
	Vector<Diagram> activeD;
	ElementMouseListener eml;
	
	Vector<Point> points = new Vector<Point>();
	
	public DeleteObjects(ApplicationModel applicationModel, ElementMouseListener eml) {
		super(applicationModel);
		this.eml = eml;
	}
	
	public void execute() {
		activeP = applicationModel.getActiveProjects();
		
		for (Project project : activeP) {
			activeD = project.getDiagrams();
			
			for (Diagram diagram : activeD) {
				if (diagram.getCurrentState() instanceof SelectionState)
					activeDiagram = diagram;
			}
		}
	
		Vector<Objects> selectedObj = new Vector<>();

		for (Objects object : activeDiagram.getElements()) {
			if(object.isSelected()) {
				activeDiagram.execute(this);
				activeDiagram.notifyObservers();
				selectedObj.add(object);
				Point p1 = new Point(object.getPoint().x,object.getPoint().y+10);
				points.add(p1);
				Point p2 = new Point(object.getPoint().x,object.getPoint().y+30);
				points.add(p2);
				Point exitP = new Point(object.getPoint().x + 80,object.getPoint().y+20);
				points.add(exitP);
				
			}	
		}

		for(Objects object : selectedObj) {
			activeDiagram.getElements().remove(object);
			eml.reset();
		}
		Vector<Relation> lines = new Vector<Relation>();

		for (Objects objects : activeDiagram.getElements()) {
			if(objects instanceof Line || objects instanceof CompositeLine) {
				System.out.println("Instanca line " + objects.getPoint());
				if(isPin(objects)) {
					lines.add((Relation) objects);
				}
			}
		}
		
		for(Relation object : lines) {
			activeDiagram.getElements().remove(object);
		}
		System.out.println(lines.size());
		applicationModel.notifyObservers();
	}
	
	public boolean isPin(Objects objects) {
		for (Point point : points) {
			System.out.println("pins " + point);
			if ((objects.getPoint().x -20 < point.getX() + 9) && (objects.getPoint().x-20 > point.getX() - 9) && (objects.getPoint().y-20 < point.getY() + 9)
					&& (objects.getPoint().y-20 > point.getY() - 9)) {
				return true;
			}
		}
		return false;
	}
}

