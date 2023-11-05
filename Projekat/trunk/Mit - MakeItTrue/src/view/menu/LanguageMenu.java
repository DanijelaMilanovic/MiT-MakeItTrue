package view.menu;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;

import localization.Localization;
import model.ApplicationModel;

public class LanguageMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private JCheckBoxMenuItem menuItemSrpski = null;
	private JCheckBoxMenuItem menuItemEngleski = null;
	private JCheckBoxMenuItem menuItemCirilica = null;
	private Localization localization = null;
	private ApplicationModel appModel;

	public JCheckBoxMenuItem getMenuItemSrpski() {
		return menuItemSrpski;
	}

	public JCheckBoxMenuItem getMenuItemEngleski() {
		return menuItemEngleski;
	}

	public JCheckBoxMenuItem getMenuItemCirilica() {
		return menuItemCirilica;
	}

	public LanguageMenu(ApplicationModel appModel) {
		ButtonGroup languageGroup = new ButtonGroup();
		this.appModel = appModel;
		localization = Localization.getInstance();
		
        setText(localization.getString("naziv.jezik"));
        localization.registerComponent("naziv.jezik", this);
		menuItemSrpski = new JCheckBoxMenuItem(localization.getString("lang.serbian_lat"));
		menuItemSrpski.setActionCommand("langBa");
		menuItemSrpski.addItemListener(il);
		localization.registerComponent("lang.serbian_lat", menuItemSrpski);

		menuItemEngleski = new JCheckBoxMenuItem(localization.getString("lang.english"));
		menuItemEngleski.setActionCommand("langEn");
		menuItemEngleski.addItemListener(il);
		localization.registerComponent("lang.english", menuItemEngleski);

		menuItemCirilica = new JCheckBoxMenuItem(localization.getString("lang.serbian_cryl"));
		menuItemCirilica.setActionCommand("langSr");
		menuItemCirilica.addItemListener(il);
		localization.registerComponent("lang.serbian_cryl", menuItemCirilica);

		add(menuItemSrpski);
		add(menuItemEngleski);
		add(menuItemCirilica);

		languageGroup.add(menuItemSrpski);
		languageGroup.add(menuItemEngleski);
		languageGroup.add(menuItemCirilica);
		add(Box.createHorizontalGlue());

		switch (appModel.getApplicationProperty().getLanguage()) {
		case "langBa":
			menuItemSrpski.setState(true);
			break;
		case "langSr":
			menuItemCirilica.setState(true);
			break;
		case "langEn":
			menuItemEngleski.setState(true);
			break;
		default:
			menuItemSrpski.setState(true);
			break;
		}
		
	}

	ItemListener il = new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent i) {
			AbstractButton ab = (AbstractButton) i.getSource();
			if (i.getStateChange() == ItemEvent.SELECTED) {
				if (ab.getActionCommand().equals("langEn")) {
					localization.setLocal("en", "US");
					appModel.getApplicationProperty().setLanguage("langEn");
				} else if (ab.getActionCommand().equals("langBa")) {
					localization.setLocal("sr", "BA");
					appModel.getApplicationProperty().setLanguage("langBa");
				} else if (ab.getActionCommand().equals("langSr")) {
					localization.setLocal("sr", "RS");
					appModel.getApplicationProperty().setLanguage("langSr");
				}

				localization.updateAll();
			}
		}
	};


}
