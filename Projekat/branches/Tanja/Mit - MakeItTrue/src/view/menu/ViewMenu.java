package view.menu;

import javax.swing.Box;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;

public class ViewMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private JCheckBoxMenuItem menuItemObjectBrowser = null;
	private JCheckBoxMenuItem menuItemToolbox = null;

	public JCheckBoxMenuItem getMenuItemObjectBrowser() {
		return menuItemObjectBrowser;
	}

	public JCheckBoxMenuItem getMenuItemToolbox() {
		return menuItemToolbox;
	}

	public ViewMenu() {

		setText("Prikaži");

		menuItemObjectBrowser = new JCheckBoxMenuItem("Pretraživaè projekata");
		menuItemObjectBrowser.setActionCommand("objectBrowser");
		menuItemObjectBrowser.setSelected(true);

		// ----------------Kako radi checkBox-----------------------

		/*
		 * menuItemObjectBrowser.addActionListener( new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 * method stub AbstractButton aButton = (AbstractButton) e.getSource(); boolean
		 * selected = aButton.getModel().isSelected(); if (selected) {
		 * 
		 * } else {
		 * 
		 * } }
		 * 
		 * });
		 * 
		 */
		menuItemToolbox = new JCheckBoxMenuItem("Paleta elemenata");
		menuItemToolbox.setActionCommand("toolbox");
		menuItemToolbox.setSelected(true);

		add(menuItemObjectBrowser);
		add(menuItemToolbox);

		add(Box.createHorizontalGlue());
	}

}
