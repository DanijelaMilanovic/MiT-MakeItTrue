package view.toolbar;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarRadSaOznacenimElementima extends JToolBar{
	private static final long serialVersionUID = 1L;
	
	JButton btnUnosElementa=null;
	JButton btnOznacavanjeE=null;
	JButton btnRotiranje=null;
	JButton btnHorizontalnoPoravnanje=null;
	JButton btnVertikalnoPoravnanje=null;
	JButton btnSpajanje=null;
	JButton btnBrisanjeE=null;
	
	public ToolBarRadSaOznacenimElementima() {
		
		setRollover(true);
		setFloatable(false);
		
		btnUnosElementa=new JButton();
		btnUnosElementa.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/add_element.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnUnosElementa);
		
		btnOznacavanjeE=new JButton();
		btnOznacavanjeE.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/select.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnOznacavanjeE);
		
		btnRotiranje=new JButton();
		btnRotiranje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/rotate.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnRotiranje);
		
		btnHorizontalnoPoravnanje=new JButton();
		btnHorizontalnoPoravnanje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/horizontal_aligh.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnHorizontalnoPoravnanje);
		
		btnVertikalnoPoravnanje=new JButton();
		btnVertikalnoPoravnanje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/vertical_align.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnVertikalnoPoravnanje);
		
		btnSpajanje=new JButton();
		btnSpajanje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/merge_elements.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnSpajanje);
		
		btnBrisanjeE=new JButton();
		btnBrisanjeE.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/delete_element.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnBrisanjeE);
		
		
	}
	

}
