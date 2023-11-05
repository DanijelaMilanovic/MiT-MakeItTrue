/***********************************************************************
 * Module:  EditMenu.java
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

import localization.Localization;
import model.ApplicationModel;
import model.commands.RedoCommand;
import model.commands.UndoCommand;
public class EditMenu extends JMenu {

	private static final long serialVersionUID = 1L;
	private JMenuItem menuItemPonistiPrethodniKorak = null;
	private JMenuItem menuItemPovratiPonisteniKorak = null;
	private JMenuItem menuItemIsjecanje = null;
	private JMenuItem menuItemKopiranje = null;
	private JMenuItem menuItemLijepljenje = null;
	private JMenuItem menuItemOznaciSve = null;
	private JMenuItem menuItemObrisiOznaceneElemente = null;
	private Localization localization = null;

	public JMenuItem getMenuItemPonistiPrethodniKorak() {
		return menuItemPonistiPrethodniKorak;
	}

	public JMenuItem getMenuItemPovratiPonisteniKorak() {
		return menuItemPovratiPonisteniKorak;
	}

	public JMenuItem getMenuItemIsjecanje() {
		return menuItemIsjecanje;
	}

	public JMenuItem getMenuItemKopiranje() {
		return menuItemKopiranje;
	}

	public JMenuItem getMenuItemLijepljenje() {
		return menuItemLijepljenje;
	}

	public JMenuItem getMenuItemOznaciSve() {
		return menuItemOznaciSve;
	}

	public JMenuItem getMenuItemObrisiOznaceneElemente() {
		return menuItemObrisiOznaceneElemente;
	}

	public EditMenu(ApplicationModel appModel) {
		localization = Localization.getInstance();
		setText(localization.getString("naziv.uredi"));
		localization.registerComponent("naziv.uredi", this);

		menuItemPonistiPrethodniKorak = new JMenuItem(localization.getString("edit.undo"));
		localization.registerComponent("edit.undo", menuItemPonistiPrethodniKorak);
		menuItemPonistiPrethodniKorak.setMnemonic(KeyEvent.VK_Z);
		menuItemPonistiPrethodniKorak.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/undo.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemPonistiPrethodniKorak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UndoCommand(appModel).execute();
			}
		});

		menuItemPovratiPonisteniKorak = new JMenuItem(localization.getString("edit.redo"));
		localization.registerComponent("edit.redo", menuItemPovratiPonisteniKorak);
		menuItemPovratiPonisteniKorak.setMnemonic(KeyEvent.VK_Y);
		menuItemPovratiPonisteniKorak.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/redo.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemPovratiPonisteniKorak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new RedoCommand(appModel).execute();
			}});

		menuItemIsjecanje = new JMenuItem(localization.getString("edit.cut"));
		localization.registerComponent("edit.cut", menuItemIsjecanje);
		menuItemIsjecanje.setMnemonic(KeyEvent.VK_X);
		menuItemIsjecanje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/cut.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemKopiranje = new JMenuItem(localization.getString("edit.copy"));
		localization.registerComponent("edit.copy", menuItemKopiranje);
		menuItemKopiranje.setMnemonic(KeyEvent.VK_C);
		menuItemKopiranje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/copy.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemLijepljenje = new JMenuItem(localization.getString("edit.paste"));
		localization.registerComponent("edit.paste", menuItemLijepljenje);
		menuItemLijepljenje.setMnemonic(KeyEvent.VK_V);
		menuItemLijepljenje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/paste.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemOznaciSve = new JMenuItem(localization.getString("edit.selectAll"));
		localization.registerComponent("edit.selectAll", menuItemOznaciSve);
		menuItemOznaciSve.setMnemonic(KeyEvent.VK_A);

		add(menuItemPonistiPrethodniKorak);
		add(menuItemPovratiPonisteniKorak);
		addSeparator();
		add(menuItemIsjecanje);
		add(menuItemKopiranje);
		add(menuItemLijepljenje);
		add(menuItemOznaciSve);
	}
	/**Metoda za omogućavanje menija**/
	public void enableMenu() {
		menuItemPonistiPrethodniKorak.setEnabled(true);
		menuItemPovratiPonisteniKorak.setEnabled(true);
		menuItemIsjecanje.setEnabled(true);
		menuItemKopiranje.setEnabled(true);
		menuItemLijepljenje.setEnabled(true);
		menuItemOznaciSve.setEnabled(true);
	}
	/**Metoda za neomogućavanje menija**/
	public void disableMenu() {
		menuItemPonistiPrethodniKorak.setEnabled(false);
		menuItemPovratiPonisteniKorak.setEnabled(false);
		menuItemIsjecanje.setEnabled(false);
		menuItemKopiranje.setEnabled(false);
		menuItemLijepljenje.setEnabled(false);
		menuItemOznaciSve.setEnabled(false);
	}
}
