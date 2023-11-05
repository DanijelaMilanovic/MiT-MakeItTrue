/***********************************************************************
 * Module:  Toolbox.java
 * Author:  G1
 ***********************************************************************/

package view;

import observer.Subject;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.AbstractButton;
import javax.swing.JCheckBoxMenuItem;

import com.javadocking.dock.Position;
import com.javadocking.dockable.DefaultDockable;
import com.javadocking.dockable.Dockable;
import com.javadocking.dockable.DockingMode;

import model.ActiveState;
import model.ApplicationModel;
import model.ApplicationState;
import model.Diagram;
import model.EditingState;
import model.IdleState;
/**Klasa koja definiše kompletnu paletu elemenata**/
public class Toolbox extends ComponentDecorator {
	/**Paleta elemenata koja se dodaje**/
	private CustomToolbox customToolBox;
	/**Stanje za mod java dokinga**/
	private Dockable dock;

	public CustomToolbox getCustomToolBox() {
		return customToolBox;
	}

	public void setCustomToolBox(CustomToolbox customToolBox) {
		this.customToolBox = customToolBox;
	}

	@Override
	public ApplicationModel getAppModel() {
		// TODO Auto-generated method stub
		return super.getAppModel();
	}
	
	public Toolbox(Editor editor, JCheckBoxMenuItem menuItem) {
		super(editor);

		// getContentPane().addDockable(editor.getContentPane().getDockable(0), new
		// Position(0));
		// getContentPane().addDockable(editor.getContentPane().getDockable(1), new
		// Position(1));
		customToolBox = new CustomToolbox(editor);
		customToolBox.setMinimumSize(new Dimension(220, 0));
		customToolBox.getContentPane().setComponentPopupMenu(new ContextMenu("Toolbox",super.getAppModel()).getContextMenu());
		
		dock = new DefaultDockable("dock2", getCustomToolBox(), "Toolbox", null, DockingMode.HORIZONTAL_LINE);
		// getContentPane().addDockable(dock, new Position(2));

		showComponent();

		customToolBox.getButtonClose().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hideComponent();
				if (menuItem.isSelected()) {
					menuItem.setSelected(false);
					menuItem.updateUI();
				}
			}
		});
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton aButton = (AbstractButton) e.getSource();
				boolean selected = aButton.getModel().isSelected();

				if (selected) {
					showComponent();
				} else {
					hideComponent();
				}
			}
		});
	}

	@Override
	public Diagram getFocusedDiagram() {
		return super.getFocusedDiagram();
		
	}
	
	@Override
	public void showComponent() {
		getContentPane().addDockable(dock, new Position(2));
		getContentPane().updateUI();

	}

	@Override
	public void hideComponent() {
		getContentPane().removeDockable(dock);
		getContentPane().updateUI();
	}

	@Override
	public void addDiagrams(Diagram newDiagram) {
		super.addDiagrams(newDiagram);
	}

	@Override
	public Collection<Diagram> getDiagrams() {
		return super.getDiagrams();
	}

	@Override
	public void update(Subject subject) {
		super.update(subject);
		ApplicationState state = ((ApplicationModel) subject).getCurrentState();

		if (state.getClass() == IdleState.class) {
			customToolBox.disableButtons();
		} else if (state.getClass() == ActiveState.class) {
			customToolBox.disableButtons();
		} else if (state.getClass() == EditingState.class) {
			customToolBox.enableButtons();
		}
	}

}