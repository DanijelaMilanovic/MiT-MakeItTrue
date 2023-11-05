package view.menu;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ProjectMenu extends JMenu{

	private static final long serialVersionUID = 1L;
	
	JMenuItem menuItemNoviProjekat = null;
	JMenuItem menuItemOtvoriProjekat = null;
	JMenuItem menuItemSacuvajProjekat = null;
	JMenuItem menuItemSacuvajKao = null;
	JMenuItem menuItemStampanjeProjekta = null;
	JMenuItem menuItemPreimenovanjeProjekta = null;
	JMenuItem menuItemObrisiProjekat = null;
	JMenuItem menuItemZatvori = null;
	JMenuItem menuItemIzlaz = null;
	
	public JMenuItem getMenuItemNoviProjekat() {
		return menuItemNoviProjekat;
	}
	
	public ProjectMenu()
	{
		setText("Projekat");
		
		menuItemNoviProjekat = new JMenuItem("Kreiranje projekta");
		menuItemNoviProjekat.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/new_p.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemOtvoriProjekat = new JMenuItem("Otvaranje projekta");
		menuItemOtvoriProjekat.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/open_project.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemSacuvajProjekat = new JMenuItem("Čuvanje projekta");
		menuItemSacuvajProjekat.setMnemonic(KeyEvent.VK_S);
		menuItemSacuvajProjekat.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/save_project.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemSacuvajKao = new JMenuItem("Čuvanje projekta kao");
		menuItemSacuvajKao.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/save_as_project.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemPreimenovanjeProjekta = new JMenuItem("Preimenovanje projekta");
		menuItemPreimenovanjeProjekta.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/rename_project.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemZatvori = new JMenuItem("Zatvaranje projekta");
		menuItemZatvori.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/close_project.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));

		menuItemObrisiProjekat = new JMenuItem("Brisanje projekta");
		//menuItemObrisiProjekat.setMnemonic(KeyEvent.VK_DELETE);
		menuItemObrisiProjekat.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/delete_project.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemIzlaz = new JMenuItem("Izlaz");
		menuItemIzlaz.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/exit.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));


		add(menuItemNoviProjekat);
		add(menuItemOtvoriProjekat);
		addSeparator();
		add(menuItemSacuvajProjekat);
		add(menuItemSacuvajKao);
		add(menuItemPreimenovanjeProjekta);;
		addSeparator();
		add(menuItemZatvori);  
		add(menuItemObrisiProjekat);
		addSeparator();
		add(menuItemIzlaz);
	}
}
