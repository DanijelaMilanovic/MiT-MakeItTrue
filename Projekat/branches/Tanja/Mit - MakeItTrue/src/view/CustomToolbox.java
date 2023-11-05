package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


public class CustomToolbox extends JTabbedPane{

	private static final long serialVersionUID = 1L;
	
	private JButton btnClose = null;
	private JPanel panel = null;
	 
	private JButton btnSelect = null;
	private JButton btnWire = null;
	private JButton btnJunctionPoint = null;
	private JButton btnComment = null;
    
	private JButton btnBuffer = null;
	private JButton btnNOT = null;
	private JButton btnAND = null;
	private JButton btnNAND = null;
	private JButton btnOR = null;
	private JButton btnNOR = null;
	private JButton btnXOR = null;
	private JButton btnXNOR = null;
	
	public JPanel getContentPane() {
		return this.panel;
	}
	public JButton getButtonClose() {
		return this.btnClose;
	}
	
	public CustomToolbox() {
		//-----------Postavke JTabbedPane----------------//
		setPreferredSize(new Dimension(220,0));
		
		FlowLayout panelLayout;		
		panelLayout = new FlowLayout(5);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(210,0));
		panel.setLayout(panelLayout);

		//-----------Postavke dugmica na panel prvi red----------------//
		btnSelect = new JButton();
		btnSelect.setIcon(new ImageIcon("icons/LogickaKola/Cursor.png"));
		btnSelect.setPreferredSize(new Dimension(100,50));
		btnSelect.setToolTipText("Selektuj");
		btnSelect.setOpaque(false);             
		btnSelect.setContentAreaFilled(false);  
		btnSelect.setBorderPainted(false);
		panel.add(btnSelect);
		
		btnComment = new JButton();
		btnComment.setIcon(new ImageIcon("icons/LogickaKola/Comment.png"));
		btnComment.setPreferredSize(new Dimension(100,50));
		btnComment.setToolTipText("Komentar");
		btnComment.setOpaque(false);             
		btnComment.setContentAreaFilled(false);  
		btnComment.setBorderPainted(false);
		btnComment.setRolloverEnabled(true);
		panel.add(btnComment);
		
		btnWire = new JButton();
		btnWire.setIcon(new ImageIcon("icons/LogickaKola/Wire.png"));
		btnWire.setPreferredSize(new Dimension(100,50));
		btnWire.setToolTipText("Provodnik");
		btnWire.setOpaque(false);             
		btnWire.setContentAreaFilled(false);  
		btnWire.setBorderPainted(false);
		panel.add(btnWire);
		
		btnJunctionPoint = new JButton();
		btnJunctionPoint.setIcon(new ImageIcon("icons/LogickaKola/JunctionPoint.png"));
		btnJunctionPoint.setPreferredSize(new Dimension(100,50));
		btnJunctionPoint.setToolTipText("Èvorište");
		btnJunctionPoint.setOpaque(false);             
		btnJunctionPoint.setContentAreaFilled(false);  
		btnJunctionPoint.setBorderPainted(false);
		panel.add(btnJunctionPoint);
		
		//-----------Postavke dugmica na panel drugi red----------------//
		btnBuffer = new JButton();
		btnBuffer.setIcon(new ImageIcon("icons/LogickaKola/Buffer.png"));
		btnBuffer.setPreferredSize(new Dimension(100,50));
		btnBuffer.setToolTipText("Bafer");
		btnBuffer.setOpaque(false);             
		btnBuffer.setContentAreaFilled(false);  
		btnBuffer.setBorderPainted(false);
		panel.add(btnBuffer);
		
		btnNOT = new JButton();
		btnNOT.setIcon(new ImageIcon("icons/LogickaKola/NOT.png"));
		btnNOT.setPreferredSize(new Dimension(100,50));
		btnNOT.setToolTipText("NE");
		btnNOT.setOpaque(false);             
		btnNOT.setContentAreaFilled(false);  
		btnNOT.setBorderPainted(false);
		btnNOT.setRolloverEnabled(true);
		panel.add(btnNOT);
		
		btnAND = new JButton();
		btnAND.setIcon(new ImageIcon("icons/LogickaKola/AND.png"));
		btnAND.setPreferredSize(new Dimension(100,50));
		btnAND.setToolTipText("I");
		btnAND.setOpaque(false);             
		btnAND.setContentAreaFilled(false);  
		btnAND.setBorderPainted(false);
		panel.add(btnAND);
		
		btnNAND = new JButton();
		btnNAND.setIcon(new ImageIcon("icons/LogickaKola/NAND.png"));
		btnNAND.setPreferredSize(new Dimension(100,50));
		btnNAND.setToolTipText("NI");
		btnNAND.setOpaque(false);             
		btnNAND.setContentAreaFilled(false);  
		btnNAND.setBorderPainted(false);
		panel.add(btnNAND);
		
		//-----------Postavke dugmica na panel treci red----------------//
		btnOR = new JButton();
		btnOR.setIcon(new ImageIcon("icons/LogickaKola/OR.png"));
		btnOR.setPreferredSize(new Dimension(100,50));
		btnOR.setToolTipText("ILI");
		btnOR.setOpaque(false);             
		btnOR.setContentAreaFilled(false);  
		btnOR.setBorderPainted(false);
		panel.add(btnOR);
				
		btnNOR = new JButton();
		btnNOR.setIcon(new ImageIcon("icons/LogickaKola/NOR.png"));
		btnNOR.setPreferredSize(new Dimension(100,50));
		btnNOR.setToolTipText("NILI");
		btnNOR.setOpaque(false);             
		btnNOR.setContentAreaFilled(false);  
		btnNOR.setBorderPainted(false);
		btnNOR.setRolloverEnabled(true);
		panel.add(btnNOR);
				
		btnXOR = new JButton();
		btnXOR.setIcon(new ImageIcon("icons/LogickaKola/XOR.png"));
		btnXOR.setPreferredSize(new Dimension(100,50));
		btnXOR.setToolTipText("Iskljuèivo ILI");
		btnXOR.setOpaque(false);             
		btnXOR.setContentAreaFilled(false);  
		btnXOR.setBorderPainted(false);
		panel.add(btnXOR);
				
		btnXNOR = new JButton();
		btnXNOR.setIcon(new ImageIcon("icons/LogickaKola/XNOR.png"));
		btnXNOR.setPreferredSize(new Dimension(100,50));
		btnXNOR.setToolTipText("Iskljuèivo NILI");
		btnXNOR.setOpaque(false);             
		btnXNOR.setContentAreaFilled(false);  
		btnXNOR.setBorderPainted(false);
		panel.add(btnXNOR);
		
		
		//-----------Dodavanje taba----------------//
		addTab("Toolbox", panel);
			
	}
	
	
	public void addTab(String str, JPanel panel)
	{
		JScrollPane scroll = new JScrollPane();

		JPanel kanvas = panel;
		
		scroll.setViewportView(kanvas);
				
		this.addTab(null, scroll);

		JPanel pnl = new JPanel();
		pnl.setOpaque(false);
		pnl.setLayout(new BorderLayout());
		pnl.setPreferredSize(new Dimension(120, 17));

		JLabel labela = new JLabel(str);
		labela.setOpaque(false);
		labela.setVerticalAlignment(JLabel.BOTTOM);
		pnl.add(labela, BorderLayout.CENTER);

		JPanel pan = new JPanel();
		pan.setOpaque(false);
		pan.setLayout(new BoxLayout(pan, BoxLayout.X_AXIS));

		 btnClose = new JButton(new ImageIcon("icons/cross.png"));
		 btnClose.setRolloverIcon(new ImageIcon("icons/cross.png"));

		 btnClose.setRolloverEnabled(true);
		 btnClose.setOpaque(false);
		 btnClose.setBorderPainted(false);
		

		Dimension dim = new Dimension(16, 16);
		btnClose.setPreferredSize(dim);
		btnClose.setMaximumSize(dim);
		btnClose.setMinimumSize(dim);
		btnClose.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
		pan.add(btnClose);

		pnl.add(pan, BorderLayout.EAST);

		setTabComponentAt(0, pnl);

	}
}

