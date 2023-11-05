package view.toolbar;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarUpravljanjeRadomElementima extends JToolBar{
	private static final long serialVersionUID = 1L;
	
	JButton btnPovratakNaPrethodniKorak=null;
	JButton btnPovratakNaPonisteniKorak=null;
	
	public ToolBarUpravljanjeRadomElementima() {
		
		setRollover(true);
		setFloatable(false);
		
		btnPovratakNaPrethodniKorak=new JButton();
		btnPovratakNaPrethodniKorak.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/undo.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnPovratakNaPrethodniKorak);
		
		btnPovratakNaPonisteniKorak=new JButton();
		btnPovratakNaPonisteniKorak.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/redo.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnPovratakNaPonisteniKorak);
	}
}
