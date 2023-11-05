package view.statusbar;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JComponent;

public class CustomStatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JPanel leftPanel;
	protected JPanel centerPanel;
	protected JPanel rightPanel;

	public CustomStatusBar() {
		createPartControl();
	}

	protected void createPartControl() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(getWidth(), 23));

		leftPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 3));
		leftPanel.setOpaque(false);
		add(leftPanel, BorderLayout.WEST);

		centerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 3));
		centerPanel.setOpaque(false);
		add(centerPanel, BorderLayout.CENTER);

		rightPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING, 5, 3));
		rightPanel.setOpaque(false);
		add(rightPanel, BorderLayout.EAST);
	}

	public void setLeftComponent(JComponent component) {
		// Lijeva komponenta se restartuje prije postavljanja nove...
		leftPanel.removeAll();
		leftPanel.add(component);
	}

	public void setCenterComponent(JComponent component) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 0));
		panel.add(new SeparatorPanel(Color.GRAY, Color.WHITE));
		panel.add(component);

		centerPanel.removeAll();
		centerPanel.add(panel);
	}

	public void addRightComponent(JComponent component) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 0));
		panel.add(new SeparatorPanel(Color.GRAY, Color.WHITE));
		panel.add(component);
		rightPanel.add(panel);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int y = 0;
		g.setColor(new Color(156, 154, 140));
		g.drawLine(0, y, getWidth(), y);
		y++;

		g.setColor(new Color(196, 194, 183));
		g.drawLine(0, y, getWidth(), y);
		y++;

		g.setColor(new Color(218, 215, 201));
		g.drawLine(0, y, getWidth(), y);
		y++;

		g.setColor(new Color(233, 231, 217));
		g.drawLine(0, y, getWidth(), y);

		y = getHeight() - 3;

		g.setColor(new Color(233, 232, 218));
		g.drawLine(0, y, getWidth(), y);
		y++;

		g.setColor(new Color(233, 231, 216));
		g.drawLine(0, y, getWidth(), y);
		y++;

		g.setColor(new Color(221, 221, 220));
		g.drawLine(0, y, getWidth(), y);
	}
}