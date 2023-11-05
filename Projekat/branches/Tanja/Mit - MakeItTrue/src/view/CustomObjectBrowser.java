package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class CustomObjectBrowser extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	private JButton btnClose = null;
	private JPanel panel = null;

	public JPanel getContentPane() {
		return this.panel;
	}
	public JButton getButtonClose() {
		return this.btnClose;
	}

	public CustomObjectBrowser() {
		setPreferredSize(new Dimension(220, 0));

		// BorderLayout panelLayout;
		// panelLayout = new BorderLayout();

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(210, 0));
		// panel.setLayout(panelLayout);
		addTab("ObjectBrowser", panel);
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
