package view.menu;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;

import localization.Localization;

public class LanguageMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private JCheckBoxMenuItem menuItemSrpski = null;
	private JCheckBoxMenuItem menuItemEngleski = null;
	private JCheckBoxMenuItem menuItemCirilica = null;
	private Localization localization = null;

	public JCheckBoxMenuItem getMenuItemSrpski() {
		return menuItemSrpski;
	}

	public JCheckBoxMenuItem getMenuItemEngleski() {
		return menuItemEngleski;
	}

	public JCheckBoxMenuItem getMenuItemCirilica() {
		return menuItemCirilica;
	}

	public LanguageMenu() {
		ButtonGroup languageGroup = new ButtonGroup();
		localization = Localization.getInstance();

		setText("Jezik");
		menuItemSrpski = new JCheckBoxMenuItem("Srpski");
		menuItemSrpski.setActionCommand("langBa");
		menuItemSrpski.addItemListener(il);
		menuItemSrpski.setSelected(true);

		menuItemEngleski = new JCheckBoxMenuItem("Engleski");
		menuItemEngleski.setActionCommand("langEn");
		menuItemEngleski.addItemListener(il);

		menuItemCirilica = new JCheckBoxMenuItem("Српски");
		menuItemCirilica.setActionCommand("langSr");
		menuItemCirilica.addItemListener(il);

		add(menuItemSrpski);
		add(menuItemEngleski);
		add(menuItemCirilica);

		languageGroup.add(menuItemSrpski);
		languageGroup.add(menuItemEngleski);
		languageGroup.add(menuItemCirilica);
		add(Box.createHorizontalGlue());


	}
	ItemListener il = new ItemListener()
	{

		@Override
		public void itemStateChanged(ItemEvent i)
		{
			AbstractButton ab = (AbstractButton) i.getSource();
			if (i.getStateChange() == ItemEvent.SELECTED)
			{
				if (ab.getActionCommand().equals("langEn"))
				{
					localization.setLocal("en", "US");

				}
				else if (ab.getActionCommand().equals("langBa"))
				{
					localization.setLocal("sr", "BA");

				}
				else if (ab.getActionCommand().equals("langSr"))
				{
					localization.setLocal("sr", "RS");

				}
				
				localization.updateAll();
			}
		}
	};
}
