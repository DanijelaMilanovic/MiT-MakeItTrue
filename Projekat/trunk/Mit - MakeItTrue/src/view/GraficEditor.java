/***********************************************************************
 * Module:  GraficEditor.java
 * Author:  G1 
 ***********************************************************************/

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.javadocking.dock.Position;
import com.javadocking.dockable.DefaultDockable;
import com.javadocking.dockable.Dockable;
import com.javadocking.dockable.DockingMode;

import listeners.ElementMouseListener;
import model.ApplicationModel;
import model.Diagram;
import model.EditingState;
import model.commands.DeleteObjects;
import observer.Observer;
import observer.Subject;
import view.contextmenu.CanvasContextMenu;
import view.editor.CustomTabEditorPane;
/**Klasa koja definiše osnovne postavke primitivne komponente editora**/
public class GraficEditor extends Editor {
	/**Svi kanvasi koji su otvoreni**/
	private Vector<Canvas> canvas;
	/**Tab na kom se nalaze kanvasi**/
	private CustomTabEditorPane tabPanel;
	/**Stanje za mod java dokinga**/
	private Dockable dock;
	/**Posmatraèi koji su povezani na dijagram**/
	private Vector<Observer> diagramObservers;

	public Vector<Canvas> getCanvas() {
		return canvas;
	}

	public void setCanvas(Vector<Canvas> canvas) {
		this.canvas = canvas;
	}

	public CustomTabEditorPane getTabPanel() {
		return tabPanel;
	}

	public void setTabPanel(CustomTabEditorPane tabPanel) {
		this.tabPanel = tabPanel;
	}

	@Override
	public ApplicationModel getAppModel() {
		return super.getAppModel();
	}

	@Override
	public void setAppModel(ApplicationModel appModel) {
		// TODO Auto-generated method stub
		super.setAppModel(appModel);
	}

	@Override
	public void addDiagrams(Diagram newDiagram) {
		// TODO Auto-generated method stub
		boolean exists = false;

		for (Diagram diagram : getDiagrams()) {
			if (diagram == newDiagram) {
				exists = true;
			}
		}

		if (!exists) {
			super.addDiagrams(newDiagram);
			newDiagram.setActive(true);
			
			for (Observer observer : diagramObservers) {
				newDiagram.attach(observer);
			}
			
			canvas.add(new Canvas(newDiagram, getAppModel()));
			ElementMouseListener listener = new ElementMouseListener(newDiagram, canvas.lastElement(), getAppModel());
			canvas.lastElement().addMouseListener(listener);
			canvas.lastElement().addMouseMotionListener(listener);
		
			CanvasContextMenu contMenu = (CanvasContextMenu) new ContextMenu("Canvas", super.getAppModel()).getContextMenu();
			(canvas.get(canvas.size() - 1))
					.setComponentPopupMenu(contMenu);
			contMenu.getBrisanjeElementa().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DeleteObjects delete = new DeleteObjects(getAppModel(), listener);
					delete.execute();					
				}
				
			});
		
			tabPanel.addTab(newDiagram.getName(), canvas.size() - 1, canvas.get(canvas.size() - 1));
			getAppModel().setCurrentState(new EditingState());
			getAppModel().notifyObservers();
		}
		else {
			JOptionPane.showMessageDialog(null, "Dijagram je veæ uèitan u editor.", "InfoBox",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	@Override
	public Diagram getFocusedDiagram() {
		return canvas.get(tabPanel.getSelectedIndex()).getDiagram();
	}

	public GraficEditor(ApplicationModel model, Vector<Observer> diagramObservers) {
		super();
		super.setAppModel(model);
		this.diagramObservers = diagramObservers;
		canvas = new Vector<Canvas>();
		tabPanel = new CustomTabEditorPane(this);
		dock = new DefaultDockable("dock1", tabPanel, "GraphicEditor", null, DockingMode.HORIZONTAL_LINE);
		getContentPane().addDockable(dock, new Position(1));
	}

	@Override
	public void update(Subject subject) {
		for (Canvas canva : canvas) {
			canva.repaint();
			canva.updateUI();
		}

	}

}
