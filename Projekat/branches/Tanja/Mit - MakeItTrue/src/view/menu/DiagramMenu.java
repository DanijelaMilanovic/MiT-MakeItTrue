package view.menu;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class DiagramMenu extends JMenu{
	
	private static final long serialVersionUID = 1L;

	JMenuItem menuItemNoviDijagram = null;
	JMenuItem menuItemOtvoriDijagram = null;
	JMenuItem menuItemZatvoriDijagram=null;
	JMenuItem menuItemPreimenovanjeDijagrama=null;
	JMenuItem menuItemStampanjeDijagrama=null;
	JMenuItem menuItemSacuvajDijagram=null;
	JMenuItem menuItemObrisiDijagram=null;
	JMenuItem menuItemGenerisanjeElemnta=null;
	
	public DiagramMenu()
	{
		setText("Dijagram");
		
		menuItemNoviDijagram = new JMenuItem("Kreiranje dijagrama");
		menuItemNoviDijagram.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/create_diagram.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemOtvoriDijagram = new JMenuItem("Otvaranje dijagrama");
		menuItemOtvoriDijagram.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/open_diagram.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemSacuvajDijagram = new JMenuItem("Čuvanje dijagrama");
		menuItemSacuvajDijagram.setMnemonic(KeyEvent.VK_S);
		menuItemSacuvajDijagram.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/save_diagram.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemStampanjeDijagrama = new JMenuItem("Štampanje dijagrama");
		menuItemStampanjeDijagrama.setMnemonic(KeyEvent.VK_P);
		menuItemStampanjeDijagrama.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/print.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		menuItemStampanjeDijagrama.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information", JOptionPane.INFORMATION_MESSAGE);
		}});
		
		menuItemPreimenovanjeDijagrama = new JMenuItem("Preimenovanje dijagrama");
		menuItemPreimenovanjeDijagrama.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/rename_diagram.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemGenerisanjeElemnta=new JMenuItem("Generisanje elementa");
		menuItemGenerisanjeElemnta.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/gen_element.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		menuItemGenerisanjeElemnta.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information", JOptionPane.INFORMATION_MESSAGE);
		}});
		
		menuItemZatvoriDijagram = new JMenuItem("Zatvaranje dijagrama");
		menuItemZatvoriDijagram.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/close_diagram.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
		menuItemObrisiDijagram = new JMenuItem("Brisanje dijagrama");
		//menuItemObrisiDijagram.setMnemonic(KeyEvent.VK_DELETE);
		menuItemObrisiDijagram.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/delete_diagram.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		
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
}
