package view.toolbar;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarProject extends JToolBar{
	private static final long serialVersionUID = 1L;
	
	JButton btnKreiranjeP=null;
	JButton btnOtvaranjeP=null;
	JButton btnCuvanjeP=null;
	JButton btnCuvanjeKaoP=null;
	JButton btnPreimenovanjeP=null;
	JButton btnBrisanjeP=null;
	JButton btnZatvaranjeP=null;
	
	public ToolBarProject() {
		
		setRollover(true);
		setFloatable(false);
		
		btnKreiranjeP=new JButton();
		btnKreiranjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/new_p.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnKreiranjeP);
		
		btnOtvaranjeP=new JButton();
		btnOtvaranjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/open_project.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnOtvaranjeP);
		
		btnCuvanjeP=new JButton();
		btnCuvanjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/save_project.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnCuvanjeP);
		
		btnCuvanjeKaoP=new JButton();
		btnCuvanjeKaoP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/save_as_project.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnCuvanjeKaoP);
		
		btnPreimenovanjeP=new JButton();
		btnPreimenovanjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/rename_project.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnPreimenovanjeP);
		
		btnBrisanjeP=new JButton();
		btnBrisanjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/delete_project.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnBrisanjeP);
		
		btnZatvaranjeP=new JButton();
		btnZatvaranjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/close_project.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnZatvaranjeP);
		
	}
	

}
