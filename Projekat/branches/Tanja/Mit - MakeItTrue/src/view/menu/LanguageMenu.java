package view.menu;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;

public class LanguageMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	JCheckBoxMenuItem menuItemSrpski=null;
	JCheckBoxMenuItem menuItemEngleski=null;
	JCheckBoxMenuItem menuItemCirilica=null;
	
	public LanguageMenu()
	{
		ButtonGroup languageGroup=new ButtonGroup();
		
		setText("Jezik");
		menuItemSrpski=new JCheckBoxMenuItem("Srpski");
		menuItemSrpski.setActionCommand("langBA");
		menuItemSrpski.setSelected(true);	
		
		menuItemEngleski=new JCheckBoxMenuItem("Engleski");
		menuItemEngleski.addActionListener(actionListener);
		menuItemEngleski.setSelected(true);
		
		menuItemCirilica=new JCheckBoxMenuItem("Српски");
		menuItemEngleski.addActionListener(actionListener);
		menuItemEngleski.setSelected(true);
		
	    add(menuItemSrpski);
		add(menuItemEngleski);
		add(menuItemCirilica);
		
		languageGroup.add(menuItemSrpski);
		languageGroup.add(menuItemEngleski);
		languageGroup.add(menuItemCirilica);
		add(Box.createHorizontalGlue());
		
	//Lokalizacija je odadjena u fajlu na redmine
	}
}
