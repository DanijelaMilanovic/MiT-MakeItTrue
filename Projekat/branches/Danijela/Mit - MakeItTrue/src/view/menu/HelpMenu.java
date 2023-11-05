package view.menu;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class HelpMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	private JMenuItem menuItemOnlinePomoc = null;
	private JMenuItem menuItemOAplikaciji = null;
	private JMenuItem menuItemFAQ = null;

	public JMenuItem getMenuItemOnlinePomoc() {
		return menuItemOnlinePomoc;
	}

	public JMenuItem getMenuItemOAplikaciji() {
		return menuItemOAplikaciji;
	}

	public JMenuItem getMenuItemFAQ() {
		return menuItemFAQ;
	}

	public HelpMenu() {
		setText("Pomoć");

		menuItemOnlinePomoc = new JMenuItem("Online pomoć");
		menuItemOnlinePomoc.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/online_help.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemOnlinePomoc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuItemOAplikaciji = new JMenuItem("O MiT editoru");
		menuItemOAplikaciji.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/logo1.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemOAplikaciji.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuItemFAQ = new JMenuItem("FAQ");
		menuItemFAQ.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/faq.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemFAQ.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		add(menuItemOnlinePomoc);
		add(menuItemOAplikaciji);
		add(menuItemFAQ);

	}
}
