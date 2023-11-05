package view.menu;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import localization.Localization;

public class SimulationMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private JMenuItem menuItemPokretanjeSimulacije = null;
	private JMenuItem menuItemZatvaranjeSimulacije = null;
	private JMenuItem menuItemZaustavljanjeSimulacije = null;
	private JMenuItem menuItemNastavljanjeSimulacije = null;
	private JMenuItem menuItemCuvanjeRezultataSimulacije = null;
	private JMenuItem menuItemUpravljanjeRadomSimulacije = null;
	private JMenuItem menuItemVerifikacijaSimulacije = null;
	private Localization localization=null;

	public JMenuItem getMenuItemPokretanjeSimulacije() {
		return menuItemPokretanjeSimulacije;
	}

	public JMenuItem getMenuItemZatvaranjeSimulacije() {
		return menuItemZatvaranjeSimulacije;
	}

	public JMenuItem getMenuItemZaustavljanjeSimulacije() {
		return menuItemZaustavljanjeSimulacije;
	}

	public JMenuItem getMenuItemNastavljanjeSimulacije() {
		return menuItemNastavljanjeSimulacije;
	}

	public JMenuItem getMenuItemCuvanjeRezultataSimulacije() {
		return menuItemCuvanjeRezultataSimulacije;
	}

	public JMenuItem getMenuItemUpravljanjeRadomSimulacije() {
		return menuItemUpravljanjeRadomSimulacije;
	}

	public JMenuItem getMenuItemVerifikacijaSimulacije() {
		return menuItemVerifikacijaSimulacije;
	}

	public SimulationMenu() {
		localization = Localization.getInstance();
        setText(localization.getString("naziv.sim"));
        localization.registerComponent("naziv.sim", this);
		menuItemPokretanjeSimulacije = new JMenuItem(localization.getString("sim.start"));  
		localization.registerComponent("sim.start", menuItemPokretanjeSimulacije);
		menuItemPokretanjeSimulacije.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/start_simulation.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemPokretanjeSimulacije.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuItemZatvaranjeSimulacije = new JMenuItem(localization.getString("sim.stop"));  
		localization.registerComponent("sim.stop", menuItemZatvaranjeSimulacije);
		menuItemZatvaranjeSimulacije.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/stop_simulation.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemZatvaranjeSimulacije.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuItemZaustavljanjeSimulacije = new JMenuItem(localization.getString("sim.pause"));  
		localization.registerComponent("sim.pause", menuItemZaustavljanjeSimulacije);
		menuItemZaustavljanjeSimulacije.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/pause_simulation.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemZaustavljanjeSimulacije.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuItemNastavljanjeSimulacije = new JMenuItem(localization.getString("sim.continue"));  
		localization.registerComponent("sim.continue", menuItemNastavljanjeSimulacije);
		menuItemNastavljanjeSimulacije.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/continue_simulation.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemNastavljanjeSimulacije.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuItemCuvanjeRezultataSimulacije = new JMenuItem(localization.getString("sim.save"));  
		localization.registerComponent("sim.save", menuItemCuvanjeRezultataSimulacije);
		menuItemCuvanjeRezultataSimulacije.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/saving_res_simulation.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemCuvanjeRezultataSimulacije.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuItemUpravljanjeRadomSimulacije = new JMenuItem(localization.getString("sim.man"));  
		localization.registerComponent("sim.man", menuItemUpravljanjeRadomSimulacije);
		menuItemUpravljanjeRadomSimulacije.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/man_simulation2.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemUpravljanjeRadomSimulacije.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menuItemVerifikacijaSimulacije = new JMenuItem(localization.getString("sim.ver"));  
		localization.registerComponent("sim.ver", menuItemVerifikacijaSimulacije);
		menuItemVerifikacijaSimulacije.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/clean_well_accept.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		menuItemVerifikacijaSimulacije.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		add(menuItemPokretanjeSimulacije);
		add(menuItemZatvaranjeSimulacije);
		add(menuItemZaustavljanjeSimulacije);
		add(menuItemNastavljanjeSimulacije);
		add(menuItemCuvanjeRezultataSimulacije);
		add(menuItemUpravljanjeRadomSimulacije);
		addSeparator();
		add(menuItemVerifikacijaSimulacije);
	}

	public void enableMenu() {
		menuItemPokretanjeSimulacije.setEnabled(true);
		menuItemZatvaranjeSimulacije.setEnabled(true);
		menuItemZaustavljanjeSimulacije.setEnabled(true);
		menuItemNastavljanjeSimulacije.setEnabled(true);
		menuItemCuvanjeRezultataSimulacije.setEnabled(true);
		menuItemUpravljanjeRadomSimulacije.setEnabled(true);
		menuItemVerifikacijaSimulacije.setEnabled(true);
	}

	public void disableMenu() {
		menuItemPokretanjeSimulacije.setEnabled(false);
		menuItemZatvaranjeSimulacije.setEnabled(false);
		menuItemZaustavljanjeSimulacije.setEnabled(false);
		menuItemNastavljanjeSimulacije.setEnabled(false);
		menuItemCuvanjeRezultataSimulacije.setEnabled(false);
		menuItemUpravljanjeRadomSimulacije.setEnabled(false);
		menuItemVerifikacijaSimulacije.setEnabled(false);
	}
}
