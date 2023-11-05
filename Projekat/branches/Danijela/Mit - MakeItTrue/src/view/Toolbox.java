/***********************************************************************
 * Module:  Toolbox.java
 * Author:  Notebook
 * Purpose: Defines the Class Toolbox
 ***********************************************************************/

package view;

import observer.Subject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.AbstractButton;
import javax.swing.JCheckBoxMenuItem;

import com.javadocking.dock.LineDock;
import com.javadocking.dock.Position;
import com.javadocking.dock.SingleDock;
import com.javadocking.dock.SplitDock;
import com.javadocking.dock.TabDock;
import com.javadocking.dockable.DefaultDockable;
import com.javadocking.dockable.Dockable;
import com.javadocking.dockable.DockingMode;

import model.Diagram;

public class Toolbox extends ComponentDecorator {
	CustomToolbox customToolBox;
	private Dockable dock;


	public CustomToolbox getCustomToolBox() {
		return customToolBox;
	}

	public void setCustomToolBox(CustomToolbox customToolBox) {
		this.customToolBox = customToolBox;
	}


	
	public Toolbox(Editor editor, JCheckBoxMenuItem menuItem) {
		super(editor);
		getContentPane().addChildDock(editor.getContentPane(), new Position(Position.CENTER));

		customToolBox = new CustomToolbox();
		customToolBox.getContentPane().setComponentPopupMenu(new ContextMenu("Toolbox").getContextMenu());
		customToolBox.setPreferredSize(new Dimension(300, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
		customToolBox.setMaximumSize(new Dimension(300,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
		
		dock = new DefaultDockable("dock2", getCustomToolBox(), "Toolbox", null, DockingMode.ALL);
		LineDock toolBoxTabDock = new LineDock();
		toolBoxTabDock.addDockable(dock, new Position(2));

		//SplitDock center = new SplitDock();
		//center.addChildDock(toolBoxTabDock, new Position(Position.RIGHT));
		//center.setDividerLocation((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3);
//		tabPanel.setComponentPopupMenu(super.getContextMenu().getContextMenu());
		getContentPane().addChildDock(toolBoxTabDock, new Position(Position.RIGHT));
		
		//		showComponent();

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
	public void hideComponent() {
		editor.getContentPane().remove(customToolBox);
		editor.getContentPane().updateUI();

	}

	@Override
	public void showComponent() {
		editor.getContentPane().add(customToolBox, BorderLayout.EAST);
		editor.getContentPane().updateUI();
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
	}

}