package view.menu;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class EditMenu extends JMenu {

	private static final long serialVersionUID = 1L;
	
	JMenuItem menuItemPonistiPrethodniKorak = null;
	JMenuItem menuItemPovratiPonisteniKorak = null;
	JMenuItem menuItemIsjecanje = null;
	JMenuItem menuItemKopiranje = null;
	JMenuItem menuItemLijepljenje = null;
	JMenuItem menuItemOznaciSve = null;
	JMenuItem menuItemObrisiOznaceneElemente = null;

	public EditMenu()
	{
		setText("Uređivanje");
		
		menuItemPonistiPrethodniKorak = new JMenuItem("Poništavanje prethodnog koraka");
		menuItemPonistiPrethodniKorak.setMnemonic(KeyEvent.VK_Z);
		menuItemPonistiPrethodniKorak.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/undo.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemPovratiPonisteniKorak = new JMenuItem("Vraćanje poništenog koraka");
		menuItemPovratiPonisteniKorak.setMnemonic(KeyEvent.VK_Y);
		menuItemPovratiPonisteniKorak.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/redo.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemIsjecanje = new JMenuItem("Isjecanje");
		menuItemIsjecanje.setMnemonic(KeyEvent.VK_X);
		menuItemIsjecanje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/cut.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemKopiranje = new JMenuItem("Kopiranje");
		menuItemKopiranje.setMnemonic(KeyEvent.VK_C);
		menuItemKopiranje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/copy.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemLijepljenje = new JMenuItem("Lijepljenje");
		menuItemLijepljenje.setMnemonic(KeyEvent.VK_V);
		menuItemLijepljenje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/paste.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemOznaciSve = new JMenuItem("Označi sve");
		menuItemOznaciSve.setMnemonic(KeyEvent.VK_A);

		add(menuItemPonistiPrethodniKorak);
		add(menuItemPovratiPonisteniKorak);
		addSeparator();
		add(menuItemIsjecanje);
		add(menuItemKopiranje);
		add(menuItemLijepljenje);
		add(menuItemOznaciSve);
	}
}
