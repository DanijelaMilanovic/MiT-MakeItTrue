package view.tree;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class TreeRenderer extends DefaultTreeCellRenderer {

	private static final long serialVersionUID = 1L;
	
	@Override 
	public Color getBackgroundNonSelectionColor() {
		return null;
	}
	
	@Override
	public Color getBackgroundSelectionColor() {
	
		return Color.LIGHT_GRAY;
	}
	
	
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {

		JLabel label = new JLabel(value.toString());

		if (!leaf) {
			label.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/open_project.png")
					.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		} else {
			label.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/file.png")
					.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)));
		}
		
		return label;
	}
}
