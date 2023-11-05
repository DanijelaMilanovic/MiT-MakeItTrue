/***********************************************************************
 * Module:  CustomObjectBrowser.java
 * Author:  G1
 ***********************************************************************/

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

import com.javadocking.dockable.DraggableContent;
import com.javadocking.drag.DragListener;

import localization.Localization;
/**Klasa koja definiše sve elemente koje sadrži pretraživaè projekata**/
public class CustomObjectBrowser extends JTabbedPane implements DraggableContent {

	private static final long serialVersionUID = 1L;
	/**Dugme za zatvaranje pretraživaèa projakata**/
	private JButton btnClose = null;
	/**Panel na kom se nalazi pretraživaè projekata**/
	private JPanel panel = null;
	/**Lokalizacija**/
	private Localization localization=null;


	public JPanel getContentPane() {
		return this.panel;
	}

	public JButton getButtonClose() {
		return this.btnClose;
	}

	public CustomObjectBrowser() {
		localization = Localization.getInstance();
		setPreferredSize(new Dimension(220, 0));
		setMaximumSize(new Dimension(220, 1000));

		// BorderLayout panelLayout;
		// panelLayout = new BorderLayout();

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(210, 0));

		panel.setLayout(new FlowLayout(FlowLayout.LEFT));

		addTab(localization.getString("kartice.objectB"), panel);
	}

	public void addTab(String str, JPanel panel) {
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
		localization.registerComponent("kartice.objectB", labela);
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
	@Override
	public void addDragListener(DragListener arg0) {
		addMouseListener(arg0);
		addMouseMotionListener(arg0);

	}
}
