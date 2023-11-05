package view.toolbar;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarSimulacije extends JToolBar{
	private static final long serialVersionUID = 1L;
	
	JButton btnZapocniSimulaciju=null;
	JButton btnZaustaviSimulaciju=null;
	JButton btnZatvoriSimulaciju=null;
	
	public ToolBarSimulacije() {
		
		setRollover(true);
		setFloatable(false);
		
		btnZapocniSimulaciju=new JButton();
		btnZapocniSimulaciju.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/start_simulation.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnZapocniSimulaciju);
		
		btnZaustaviSimulaciju=new JButton();
		btnZaustaviSimulaciju.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/pause_simulation.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnZaustaviSimulaciju);
		
		btnZatvoriSimulaciju=new JButton();
		btnZatvoriSimulaciju.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/stop_simulation.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnZatvoriSimulaciju);
		
	}
	

}
