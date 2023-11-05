package view.editor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import view.Canvas;

public class CustomTabEditorPane extends JTabbedPane {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tabCounter = 0;

	public CustomTabEditorPane() {
		setAlignmentX(JTabbedPane.RIGHT_ALIGNMENT);
		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);	
	}
	public int getTabCounter() {
		return tabCounter;
	}
	
	/**
	 * Metoda koja dodaje novi tab na postojeci {@link TabPan}, pri tom dodaje
	 * observer na kanvas postavlja aktivni undomanager, setuje mod kanvasa na
	 * default (selekcioni mod)
	 * 
	 * @param str
	 *            - naziv taba
	 */
	public void addTab(String str, int index, Canvas kanv)
	{
		Rectangle bounds1 = null;
		Dimension size1 = null;
		int x = 0;
		int y = 0;
		
		JScrollPane scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JPanel kanvas = kanv;
		
		scroll.setViewportView(kanvas);
		bounds1 = scroll.getViewport().getViewRect();
		size1 = scroll.getViewport().getViewSize();
		x = (size1.width - bounds1.width) / 2;
		y = (size1.height - bounds1.height) / 2;
		scroll.getViewport().setViewPosition(new Point(x, y));
				
		this.addTab(null, scroll);

		JPanel pnl = new JPanel();
		pnl.setOpaque(false);
		pnl.setLayout(new BorderLayout());
		pnl.setPreferredSize(new Dimension(90, 17));

		JLabel labela = new JLabel(str);
		labela.setOpaque(false);
		labela.setVerticalAlignment(JLabel.BOTTOM);
		pnl.add(labela, BorderLayout.CENTER);

		JPanel pan = new JPanel();
		pan.setOpaque(false);
		pan.setLayout(new BoxLayout(pan, BoxLayout.X_AXIS));

		JButton d = new JButton(new ImageIcon("icons/cross.png"));
		d.setRolloverIcon(new ImageIcon("icons/cross.png"));

		d.setRolloverEnabled(true);
		d.setOpaque(false);
		d.setBorderPainted(false);
		ActionListener al;
	    al = new ActionListener() 
	    {
	    	public void actionPerformed(ActionEvent ae) 
	    	{
	    		JButton btn = (JButton) ae.getSource();    		
	    		int index = indexOfTabComponent(btn.getParent().getParent());
    			removeTabAt(index);
    			tabCounter--;
	    	}
	    };
	    d.addActionListener(al);

		Dimension dim = new Dimension(16, 16);
		d.setPreferredSize(dim);
		d.setMaximumSize(dim);
		d.setMinimumSize(dim);
		d.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
		pan.add(d);

		pnl.add(pan, BorderLayout.EAST);

		setTabComponentAt(index, pnl);
		tabCounter++;
	}
	
}
