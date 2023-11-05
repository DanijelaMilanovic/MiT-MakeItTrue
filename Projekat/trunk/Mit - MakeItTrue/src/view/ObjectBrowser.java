/***********************************************************************
 * Module:  ObjectBrowser.java
 * Author:  G1
 ***********************************************************************/

package view;
/**Klasa koja definiše pretraživaè projekata**/
import model.ApplicationModel;
import model.Diagram;
import model.Project;
import observer.Subject;
import view.tree.TreeRenderer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.AbstractButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import com.javadocking.dock.Position;
import com.javadocking.dockable.DefaultDockable;
import com.javadocking.dockable.Dockable;
import com.javadocking.dockable.DockingMode;

import listeners.TreeMouseListener;

public class ObjectBrowser extends ComponentDecorator {
	/**elementi pretraživaèa projekata**/
	private CustomObjectBrowser customObjectBrowser;
	/**Stanje za mod java dokinga**/
	private Dockable dock;

	public CustomObjectBrowser getCustomObjectBrowser() {
		return customObjectBrowser;
	}

	public void setCustomObjectBrowser(CustomObjectBrowser customObjectBrowser) {
		this.customObjectBrowser = customObjectBrowser;
	}

	@Override
	public ApplicationModel getAppModel() {
		// TODO Auto-generated method stub
		return super.getAppModel();
	}

	public ObjectBrowser(Editor editor, JCheckBoxMenuItem menuItem) {
		super(editor);
		// getContentPane().addDockable(getContentPane().getDockable(0), new
		// Position(1));

		customObjectBrowser = new CustomObjectBrowser();
		customObjectBrowser.getContentPane()
				.setComponentPopupMenu(new ContextMenu("Object Browser", super.getAppModel()).getContextMenu());
		customObjectBrowser.setMinimumSize(new Dimension(220, 0));
		dock = new DefaultDockable("dock2", customObjectBrowser, "ObjectBrowser", null, DockingMode.HORIZONTAL_LINE);
		// getContentPane().addDockable(dock, new Position(0));

		showComponent();

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
	public Diagram getFocusedDiagram() {
		return super.getFocusedDiagram();
	}

	@Override
	public void showComponent() {
		getContentPane().addDockable(dock, new Position(0));
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
		ApplicationModel appModel = (ApplicationModel) subject;
		super.update(subject);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Projekti");
		customObjectBrowser.getContentPane().removeAll();

		for (Project activeProject : appModel.getActiveProjects()) {
			DefaultMutableTreeNode activeProjectNode = new DefaultMutableTreeNode(activeProject.getName());
			activeProjectNode.setUserObject(activeProject);
			root.add(activeProjectNode);

			if (activeProject.getDiagrams().isEmpty()) {
				DefaultMutableTreeNode invisibleNode = new DefaultMutableTreeNode("hide");
				activeProjectNode.add(invisibleNode);
			}
			for (Diagram diagram : activeProject.getDiagrams()) {
				DefaultMutableTreeNode diagramNode = new DefaultMutableTreeNode(diagram.getName());
				diagramNode.setUserObject(diagram);
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
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addMouseListener(new TreeMouseListener(tree, this));

		customObjectBrowser.getContentPane().add(tree);

	}

}