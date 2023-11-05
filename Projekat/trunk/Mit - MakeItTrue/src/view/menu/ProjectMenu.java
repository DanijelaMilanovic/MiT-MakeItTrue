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
import model.commands.CloseApplication;
import model.commands.CreateProject;
import model.commands.OpenProject;
import model.commands.SaveProject;
import view.StatusBar;

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
	private Localization localization=null;

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
		
        localization = Localization.getInstance();
        setText(localization.getString("naziv.projekat"));
        localization.registerComponent("naziv.projekat", this);
        
		menuItemNoviProjekat = new JMenuItem(localization.getString("menu.createProject"));  
		localization.registerComponent("menu.createProject", menuItemNoviProjekat);
		
		menuItemNoviProjekat.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/new_p.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemNoviProjekat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateProject(appModel).execute();
			}
		});

		menuItemOtvoriProjekat = new JMenuItem(localization.getString("menu.openProject"));  
		localization.registerComponent("menu.openProject", menuItemOtvoriProjekat);
		menuItemOtvoriProjekat.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/open_project.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemOtvoriProjekat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new OpenProject(appModel).execute();
			}
		});

		
		menuItemSacuvajProjekat = new JMenuItem(localization.getString("menu.saveProject"));  
		localization.registerComponent("menu.saveProject", menuItemSacuvajProjekat);
		menuItemSacuvajProjekat.setMnemonic(KeyEvent.VK_S);
		menuItemSacuvajProjekat.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/save_project.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemSacuvajProjekat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SaveProject(appModel).execute();
			}});

		
		menuItemSacuvajKao = new JMenuItem(localization.getString("menu.saveAsProject"));  
		localization.registerComponent("menu.saveAsProject", menuItemSacuvajKao);
		menuItemSacuvajKao.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/save_as_project.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		
		menuItemPreimenovanjeProjekta = new JMenuItem(localization.getString("menu.renameProject"));  
		localization.registerComponent("menu.renameProject", menuItemPreimenovanjeProjekta);
		menuItemPreimenovanjeProjekta.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/rename_project.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemZatvori = new JMenuItem(localization.getString("menu.closeProject"));  
		localization.registerComponent("menu.closeProject", menuItemZatvori);
		menuItemZatvori.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/close_project.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemObrisiProjekat = new JMenuItem(localization.getString("menu.deleteProject"));  
		localization.registerComponent("menu.deleteProject", menuItemObrisiProjekat);
		// menuItemObrisiProjekat.setMnemonic(KeyEvent.VK_DELETE);
		menuItemObrisiProjekat.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/delete_project.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));

		menuItemIzlaz = new JMenuItem(localization.getString("menu.exitProject"));  
		localization.registerComponent("menu.exitProject", menuItemIzlaz);
		menuItemIzlaz.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/exit.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemIzlaz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StatusBar.terminateTimerThread();
				new CloseApplication(appModel).execute();
			}
		});

		add(menuItemNoviProjekat);
		add(menuItemOtvoriProjekat);
		addSeparator();
		add(menuItemSacuvajProjekat);
		add(menuItemSacuvajKao);
		add(menuItemPreimenovanjeProjekta);
		addSeparator();
		add(menuItemZatvori);
		add(menuItemObrisiProjekat);
		addSeparator();
		add(menuItemIzlaz);
	}
}
