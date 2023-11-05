/***********************************************************************
 * Module:  TreeMouseListener.java
 * Author:  G1
 ***********************************************************************/

package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import model.Diagram;
import model.Project;
import view.Editor;
/**Klasa osluškivaèa dogaðaja koja registruje dvostruki klik na dijagramu. **/
public class TreeMouseListener extends MouseAdapter {
	private JTree tree;
	private Editor editor;
	
	public TreeMouseListener(JTree tree, Editor editor) {
		this.tree = tree;
		this.editor = editor;
	}

	public void mousePressed(MouseEvent e) {
		int selRow = tree.getRowForLocation(e.getX(), e.getY());
		TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
		if (selRow != -1 && e.getClickCount() == 2 && selPath.getPathCount() == 3) {
			DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selPath.getLastPathComponent();
			Diagram diagram = (Diagram)selectedNode.getUserObject();
			
			editor.addDiagrams(diagram);
		}
		else if(selRow != -1 && selPath.getPathCount() == 2) {
            DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) tree.getModel().getRoot();
			for(int i = 0; i < rootNode.getChildCount(); i++) {
				DefaultMutableTreeNode projectNode = (DefaultMutableTreeNode) rootNode.getChildAt(i);
			
				if(projectNode.getPath().length == 2 ) {
					Project project = (Project)projectNode.getUserObject();
					project.setFocused(false);
				}
			
			}
            
			DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selPath.getLastPathComponent();
			Project project = (Project)selectedNode.getUserObject();
			
			project.setFocused(true);
			
		}
	}
}
