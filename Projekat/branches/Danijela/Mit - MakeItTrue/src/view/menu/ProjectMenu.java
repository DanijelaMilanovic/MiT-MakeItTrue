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
import model.commands.CreateProject;

public class ProjectMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private JMenuItem menuItemNoviProjekat = null;
	private JMenuItem menuItemOtvoriProjekat = null;
	private JMenuItem menuItemSacuvajProjekat = null;
	private JMenuItem menuItemSacuvajKao = null;
	private JMenuItem menuItemStampanjeProjekta = null;
	private JMenuItem menuItemPreimenovanjeProjekta = null;
	private JMenuItem menuItemObrisiProjekat = null;
	private JMenuItem menuItemZatvori = null;
	private JMenuItem menuItemIzlaz = null;
	private Localization localization = null;

	public JMenuItem getMenuItemNoviProjekat() {
		return menuItemNoviProjekat;
	}

	public JMenuItem getMenuItemOtvoriProjekat() {
		return menuItemOtvoriProjekat;
	}

	public JMenuItem getMenuItemSacuvajProjekat() {
		return menuItemSacuvajProjekat;
	}

	public JMenuItem getMenuItemSacuvajKao() {
		return menuItemSacuvajKao;
	}

	public JMenuItem getMenuItemStampanjeProjekta() {
		return menuItemStampanjeProjekta;
	}

	public JMenuItem getMenuItemPreimenovanjeProjekta() {
		return menuItemPreimenovanjeProjekta;
	}

	public JMenuItem getMenuItemObrisiProjekat() {
		return menuItemObrisiProjekat;
	}

	public JMenuItem getMenuItemZatvori() {
		return menuItemZatvori;
	}

	public JMenuItem getMenuItemIzlaz() {
		return menuItemIzlaz;
	}

	public ProjectMenu(ApplicationModel appModel) {
		setText("Projekat");
		localization = Localization.getInstance();
		
		menuItemNoviProjekat = new JMenuItem(localization.getString("menu.createProject"));
		menuItemNoviProjekat.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/new_p.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		localization.registerComponent("menu.createProject", menuItemNoviProjekat);
		menuItemNoviProjekat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateProject(appModel).execute();
			}
		});

		menuItemOtvoriProjekat = new JMenuItem("Otvaranje projekta");
		menuItemOtvoriProjekat.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/open_project.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemSacuvajProjekat = new JMenuItem("Čuvanje projekta");
		menuItemSacuvajProjekat.setMnemonic(KeyEvent.VK_S);
		menuItemSacuvajProjekat.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/save_project.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemSacuvajKao = new JMenuItem("Čuvanje projekta kao");
		menuItemSacuvajKao.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/save_as_project.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemPreimenovanjeProjekta = new JMenuItem("Preimenovanje projekta");
		menuItemPreimenovanjeProjekta.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/rename_project.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemZatvori = new JMenuItem("Zatvaranje projekta");
		menuItemZatvori.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/close_project.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemObrisiProjekat = new JMenuItem("Brisanje projekta");
		// menuItemObrisiProjekat.setMnemonic(KeyEvent.VK_DELETE);
		menuItemObrisiProjekat.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/delete_project.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemIzlaz = new JMenuItem("Izlaz");
		menuItemIzlaz.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/exit.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		add(menuItemNoviProjekat);
		add(menuItemOtvoriProjekat);
		addSeparator();
		add(menuItemSacuvajProjekat);
		add(menuItemSacuvajKao);
		add(menuItemPreimenovanjeProjekta);
		;
		addSeparator();
		add(menuItemZatvori);
		add(menuItemObrisiProjekat);
		addSeparator();
		add(menuItemIzlaz);
	}
}
