package view.menu;

import javax.swing.Box;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;

import localization.Localization;

public class ViewMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private JCheckBoxMenuItem menuItemObjectBrowser = null;
	private JCheckBoxMenuItem menuItemToolbox = null;
	private Localization localization=null;

	public JCheckBoxMenuItem getMenuItemObjectBrowser() {
		return menuItemObjectBrowser;
	}

	public JCheckBoxMenuItem getMenuItemToolbox() {
		return menuItemToolbox;
	}

	public ViewMenu() {

		localization = Localization.getInstance();
        setText(localization.getString("naziv.prikazi"));
        localization.registerComponent("naziv.prikazi", this);

		menuItemObjectBrowser = new JCheckBoxMenuItem(localization.getString("view.projects"));
		localization.registerComponent("view.projects", menuItemObjectBrowser);
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
		menuItemToolbox = new JCheckBoxMenuItem(localization.getString("view.elements"));
		localization.registerComponent("view.elements", menuItemToolbox);
		menuItemToolbox.setActionCommand("toolbox");
		menuItemToolbox.setSelected(true);

		add(menuItemObjectBrowser);
		add(menuItemToolbox);

		add(Box.createHorizontalGlue());
	}

}
