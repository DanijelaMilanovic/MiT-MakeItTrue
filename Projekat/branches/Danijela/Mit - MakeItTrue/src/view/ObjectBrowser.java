/***********************************************************************
 * Module:  ObjectBrowser.java
 * Author:  Notebook
 * Purpose: Defines the Class ObjectBrowser
 ***********************************************************************/

package view;

import model.ApplicationModel;
import model.Diagram;
import model.Project;
import observer.Subject;
import view.tree.TreeRenderer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.AbstractButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.javadocking.dock.LineDock;
import com.javadocking.dock.Position;
import com.javadocking.dock.SingleDock;
import com.javadocking.dock.SplitDock;
import com.javadocking.dock.TabDock;
import com.javadocking.dockable.DefaultDockable;
import com.javadocking.dockable.Dockable;
import com.javadocking.dockable.DockingMode;

public class ObjectBrowser extends ComponentDecorator {
	CustomObjectBrowser customObjectBrowser;
	private Dockable dock;

	public CustomObjectBrowser getCustomObjectBrowser() {
		return customObjectBrowser;
	}

	public void setCustomObjectBrowser(CustomObjectBrowser customObjectBrowser) {
		this.customObjectBrowser = customObjectBrowser;
	}

	public ObjectBrowser(Editor editor, JCheckBoxMenuItem menuItem) {
		super(editor);
		getContentPane().addChildDock(editor.getContentPane(), new Position(Position.CENTER));

		customObjectBrowser = new CustomObjectBrowser();
		customObjectBrowser.getContentPane().setComponentPopupMenu(new ContextMenu("Object Browser").getContextMenu());
		dock = new DefaultDockable("dock2", customObjectBrowser, "ObjectBrowser", null, DockingMode.ALL);
		LineDock objectTabDock = new LineDock();
		objectTabDock.addDockable(dock, new Position(1));
		objectTabDock.setPreferredSize(new Dimension(300,0));
		//SplitDock center = new SplitDock();
		//center.addChildDock(objectTabDock, new Position(Position.LEFT));
		//center.setDividerLocation((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/3);
//		tabPanel.setComponentPopupMenu(super.getContextMenu().getContextMenu());
		getContentPane().addChildDock(objectTabDock, new Position(Position.LEFT));

		//	showComponent();

		customObjectBrowser.getButtonClose().addActionListener(new ActionListener() {

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
	public void showComponent() {
		editor.getContentPane().add(customObjectBrowser, BorderLayout.WEST);
		editor.getContentPane().updateUI();

	}

	@Override
	public void hideComponent() {
		editor.getContentPane().remove(customObjectBrowser);
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
		ApplicationModel appModel = (ApplicationModel) subject;
		super.update(subject);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Projekti");
		customObjectBrowser.getContentPane().removeAll();

		for (Project activeProject : appModel.getActiveProjects()) {
			DefaultMutableTreeNode activeProjectNode = new DefaultMutableTreeNode(activeProject.getName());
			root.add(activeProjectNode);

			for (Diagram diagram : activeProject.getDiagrams()) {
				DefaultMutableTreeNode diagramNode = new DefaultMutableTreeNode(diagram.getName());
				activeProjectNode.add(diagramNode);
			}
		}

		for (Project closedProject : appModel.getClosedProject()) {
			DefaultMutableTreeNode closedProjectNode = new DefaultMutableTreeNode(closedProject.getName());
			root.add(closedProjectNode);

			for (Diagram diagram : closedProject.getDiagrams()) {
				DefaultMutableTreeNode diagramNode = new DefaultMutableTreeNode(diagram.getName());
				closedProjectNode.add(diagramNode);

			}
		}

		JTree tree = new JTree(root);
		tree.setRootVisible(false);
		tree.setShowsRootHandles(true);
		tree.setBackground(null);
		tree.setCellRenderer(new TreeRenderer());

		customObjectBrowser.getContentPane().add(tree);

	}

}