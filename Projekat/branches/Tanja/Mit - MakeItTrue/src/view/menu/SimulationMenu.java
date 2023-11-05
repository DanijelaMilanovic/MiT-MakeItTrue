package view.menu;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class SimulationMenu extends JMenu {

	private static final long serialVersionUID = 1L;
	
	JMenuItem menuItemPokretanjeSimulacije = null;
	JMenuItem menuItemZatvaranjeSimulacije = null;
	JMenuItem menuItemZaustavljanjeSimulacije = null;
	JMenuItem menuItemNastavljanjeSimulacije = null;
	JMenuItem menuItemCuvanjeRezultataSimulacije = null;
	JMenuItem menuItemUpravljanjeRadomSimulacije = null;
	JMenuItem menuItemVerifikacijaSimulacije = null;
	
	public SimulationMenu()
	{
		setText("Simulacija");
		
		menuItemPokretanjeSimulacije = new JMenuItem("Pokretanje simulacije");
		menuItemPokretanjeSimulacije.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/start_simulation.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		menuItemPokretanjeSimulacije.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information", JOptionPane.INFORMATION_MESSAGE);
		}});

		menuItemZatvaranjeSimulacije = new JMenuItem("Zatvaranje simulacije");
		menuItemZatvaranjeSimulacije.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/stop_simulation.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		menuItemZatvaranjeSimulacije.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information", JOptionPane.INFORMATION_MESSAGE);
		}});

		menuItemZaustavljanjeSimulacije = new JMenuItem("Zaustavljanje simulacije");
		menuItemZaustavljanjeSimulacije.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/pause_simulation.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		menuItemZaustavljanjeSimulacije.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information", JOptionPane.INFORMATION_MESSAGE);
		}});

		menuItemNastavljanjeSimulacije = new JMenuItem("Nastavljanje simulacije");
		menuItemNastavljanjeSimulacije.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/continue_simulation.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		menuItemNastavljanjeSimulacije.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information", JOptionPane.INFORMATION_MESSAGE);
		}});
		
		menuItemCuvanjeRezultataSimulacije = new JMenuItem("Čuvanje rezultata simulacije");
		menuItemCuvanjeRezultataSimulacije.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/saving_res_simulation.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		menuItemCuvanjeRezultataSimulacije.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information", JOptionPane.INFORMATION_MESSAGE);
		}});
		
		menuItemUpravljanjeRadomSimulacije = new JMenuItem("Upravljanje radom simulacije");
		menuItemUpravljanjeRadomSimulacije.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/man_simulation2.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		menuItemUpravljanjeRadomSimulacije.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information", JOptionPane.INFORMATION_MESSAGE);
		}});
		
		menuItemVerifikacijaSimulacije = new JMenuItem("Verifikacija");
		menuItemVerifikacijaSimulacije.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/clean_well_accept.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		menuItemVerifikacijaSimulacije.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija je u fazi izrade.", "Information", JOptionPane.INFORMATION_MESSAGE);
		}});
		
		add(menuItemPokretanjeSimulacije);
		add(menuItemZatvaranjeSimulacije);
		add(menuItemZaustavljanjeSimulacije);
		add(menuItemNastavljanjeSimulacije);
		add(menuItemCuvanjeRezultataSimulacije);
		add(menuItemUpravljanjeRadomSimulacije);
		addSeparator();
		add(menuItemVerifikacijaSimulacije);
	}
}
