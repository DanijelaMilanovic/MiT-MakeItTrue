/***********************************************************************
 * Module:  DiagramMenu.java
 * Author:  G1
 ***********************************************************************/

package view.menu;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import localization.Localization;
import model.ApplicationModel;
import model.commands.CreateDiagram;
public class DiagramMenu extends JMenu {

	private static final long serialVersionUID = 1L;
	private JMenuItem menuItemNoviDijagram = null;
	private JMenuItem menuItemOtvoriDijagram = null;
	private JMenuItem menuItemZatvoriDijagram = null;
	private JMenuItem menuItemPreimenovanjeDijagrama = null;
	private JMenuItem menuItemStampanjeDijagrama = null;
	private JMenuItem menuItemSacuvajDijagram = null;
	private JMenuItem menuItemObrisiDijagram = null;
	private JMenuItem menuItemGenerisanjeElemnta = null;
	private Localization localization=null;

	public JMenuItem getMenuItemNoviDijagram() {
		return menuItemNoviDijagram;
	}

	public JMenuItem getMenuItemOtvoriDijagram() {
		return menuItemOtvoriDijagram;
	}

	public JMenuItem getMenuItemZatvoriDijagram() {
		return menuItemZatvoriDijagram;
	}

	public JMenuItem getMenuItemPreimenovanjeDijagrama() {
		return menuItemPreimenovanjeDijagrama;
	}

	public JMenuItem getMenuItemStampanjeDijagrama() {
		return menuItemStampanjeDijagrama;
	}

	public JMenuItem getMenuItemSacuvajDijagram() {
		return menuItemSacuvajDijagram;
	}

	public JMenuItem getMenuItemObrisiDijagram() {
		return menuItemObrisiDijagram;
	}

	public JMenuItem getMenuItemGenerisanjeElemnta() {
		return menuItemGenerisanjeElemnta;
	}

	public DiagramMenu(ApplicationModel appModel) {
		localization = Localization.getInstance();
        setText(localization.getString("naziv.dijagram"));
        localization.registerComponent("naziv.dijagram", this);
		
		
		menuItemNoviDijagram = new JMenuItem(localization.getString("menu.diagramCreate"));  
		localization.registerComponent("menu.diagramCreate", menuItemNoviDijagram);
		menuItemNoviDijagram.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/create_diagram.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemNoviDijagram.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateDiagram(appModel).execute();
			}});

		menuItemOtvoriDijagram = new JMenuItem(localization.getString("menu.diagramOpen"));  
		localization.registerComponent("menu.diagramOpen", menuItemOtvoriDijagram);
		menuItemOtvoriDijagram.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/open_diagram.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemSacuvajDijagram = new JMenuItem(localization.getString("menu.diagramSave"));  
		localization.registerComponent("menu.diagramSave", menuItemSacuvajDijagram);
		menuItemSacuvajDijagram.setMnemonic(KeyEvent.VK_S);
		menuItemSacuvajDijagram.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/save_diagram.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemStampanjeDijagrama = new JMenuItem(localization.getString("menu.diagramPrint"));  
		localization.registerComponent("menu.diagramPrint", menuItemStampanjeDijagrama);
		menuItemStampanjeDijagrama.setMnemonic(KeyEvent.VK_P);
		menuItemStampanjeDijagrama.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/print.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemStampanjeDijagrama.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuItemPreimenovanjeDijagrama = new JMenuItem(localization.getString("menu.diagramRename"));  
		localization.registerComponent("menu.diagramRename", menuItemPreimenovanjeDijagrama);
		menuItemPreimenovanjeDijagrama.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/rename_diagram.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemGenerisanjeElemnta = new JMenuItem(localization.getString("menu.diagramGenerateElement"));  
		localization.registerComponent("menu.diagramGenerateElement", menuItemGenerisanjeElemnta);
		menuItemGenerisanjeElemnta.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/gen_element.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemGenerisanjeElemnta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuItemZatvoriDijagram = new JMenuItem(localization.getString("menu.diagramClose"));  
		localization.registerComponent("menu.diagramClose", menuItemZatvoriDijagram);
		menuItemZatvoriDijagram.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/close_diagram.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemObrisiDijagram = new JMenuItem(localization.getString("menu.diagramDelete"));  
		localization.registerComponent("menu.diagramDelete", menuItemObrisiDijagram);
		// menuItemObrisiDijagram.setMnemonic(KeyEvent.VK_DELETE);
		menuItemObrisiDijagram.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/delete_diagram.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		add(menuItemNoviDijagram);
		add(menuItemOtvoriDijagram);
		addSeparator();
		add(menuItemSacuvajDijagram);
		addSeparator();
		add(menuItemStampanjeDijagrama);
		addSeparator();
		add(menuItemPreimenovanjeDijagrama);
		addSeparator();
		add(menuItemGenerisanjeElemnta);
		addSeparator();
		add(menuItemZatvoriDijagram);
		add(menuItemObrisiDijagram);
	}
	/**Metoda za omogućavanje menija**/
	public void enableMenu() {
		menuItemNoviDijagram.setEnabled(true);
		menuItemOtvoriDijagram.setEnabled(true);
		menuItemSacuvajDijagram.setEnabled(true);
		menuItemStampanjeDijagrama.setEnabled(true);
		menuItemPreimenovanjeDijagrama.setEnabled(true);
		menuItemGenerisanjeElemnta.setEnabled(true);
		menuItemZatvoriDijagram.setEnabled(true);
		menuItemObrisiDijagram.setEnabled(true);
	}
	/**Metoda za neomogućavanje menija**/
	public void disableMenu() {
		menuItemNoviDijagram.setEnabled(false);
		menuItemOtvoriDijagram.setEnabled(false);
		menuItemSacuvajDijagram.setEnabled(false);
		menuItemStampanjeDijagrama.setEnabled(false);
		menuItemPreimenovanjeDijagrama.setEnabled(false);
		menuItemGenerisanjeElemnta.setEnabled(false);
		menuItemZatvoriDijagram.setEnabled(false);
		menuItemObrisiDijagram.setEnabled(false);
	}
}
