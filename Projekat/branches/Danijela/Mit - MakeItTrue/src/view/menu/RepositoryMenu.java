package view.menu;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class RepositoryMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private JMenuItem menuItemPrijava = null;
	private JMenuItem menuItemOdjava = null;

	public JMenuItem getMenuItemPrijava() {
		return menuItemPrijava;
	}

	public JMenuItem getMenuItemOdjava() {
		return menuItemOdjava;
	}

	public RepositoryMenu() {
		setText("Repozitorijum");

		menuItemPrijava = new JMenuItem("Prijava");
		menuItemPrijava.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/Login.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemPrijava.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuItemOdjava = new JMenuItem("Odjava");
		menuItemOdjava.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/Logout.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemOdjava.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		add(menuItemPrijava);
		add(menuItemOdjava);
	}
}
