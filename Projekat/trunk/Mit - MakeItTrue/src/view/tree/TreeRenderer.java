package view.tree;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class TreeRenderer extends DefaultTreeCellRenderer {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {

		JLabel label = new JLabel(value.toString());
		label.setOpaque(true);
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		
		if (node.getUserObject().toString() != "hide") {
			if (!leaf) {
				label.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/open_project.png")
						.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
			} else {
				label.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/file.png")
						.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)));
			}
		} else {
			label = new JLabel("");
		}
		
		if(selected) {
			label.setBackground(new Color(144, 169, 205));
		}
		else
		{
			label.setBackground(null);
		}
		
		label.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		tree.setRowHeight(30);
		return label;
	}
}
