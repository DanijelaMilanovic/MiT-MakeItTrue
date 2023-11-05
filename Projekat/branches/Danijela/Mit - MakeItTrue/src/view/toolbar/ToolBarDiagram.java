package view.toolbar;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarDiagram extends JToolBar{
	
	private static final long serialVersionUID = 1L;
	
	JButton btnKreiranjeD=null;
	JButton btnOtvaranjeD=null;
	JButton btnCuvanjeKaoD=null;
	JButton btnPreimenovanjeD=null;
	JButton btnUvecajD=null;
	JButton btnUmanjiD=null;
	JButton btnBrisanjeD=null;
	JButton btnZatvaranjeD=null;
	
	public ToolBarDiagram() {
		
		setRollover(true);
		setFloatable(false);
		
		btnKreiranjeD=new JButton();
		btnKreiranjeD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/create_diagram.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnKreiranjeD);
		
		btnOtvaranjeD=new JButton();
		btnOtvaranjeD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/open_diagram.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnOtvaranjeD);
		
		btnCuvanjeKaoD=new JButton();
		btnCuvanjeKaoD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/save_diagram.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnCuvanjeKaoD);
		
		btnPreimenovanjeD=new JButton();
		btnPreimenovanjeD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/rename_diagram.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnPreimenovanjeD);
		
		btnUvecajD=new JButton();
		btnUvecajD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/zoom_in_diagram.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnUvecajD);
		
		btnUmanjiD=new JButton();
		btnUmanjiD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/zoom_out_diagram.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnUmanjiD);
		
		btnBrisanjeD=new JButton();
		btnBrisanjeD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/delete_diagram.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnBrisanjeD);
		
		btnZatvaranjeD=new JButton();
		btnZatvaranjeD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/close_diagram.png").getScaledInstance(24,24,Image.SCALE_AREA_AVERAGING)));
		add(btnZatvaranjeD);
		
	}

}
