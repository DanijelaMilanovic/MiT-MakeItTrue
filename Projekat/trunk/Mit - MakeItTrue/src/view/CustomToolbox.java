/***********************************************************************
 * Module:  CustomToolbox.java
 * Author:  G1
 ***********************************************************************/

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import com.javadocking.dockable.DraggableContent;
import com.javadocking.drag.DragListener;

import listeners.ToolBoxActionListener;
import localization.Localization;
import model.DifferentViewObject;
import model.ToolBoxObject;
import model.elements.Or;
import model.elements.Xor;
/**Klasa koja definiše sve elemente palete elemenata**/
public class CustomToolbox extends JTabbedPane implements DraggableContent {

	private static final long serialVersionUID = 1L;
	DifferentViewObject differentViewObject = new ToolBoxObject();

	/**Dugme za zatvaranje palete elemenata**/
	private JButton btnClose = null;
	/**Panel na koji se postavlja paleta elemenata**/
	private JPanel panel = null;

	/**Dugme za oznaèavanje**/
	private JButton btnSelect = null;
	/**Dugme za iscrtavanje linije**/
	private JButton btnLine = null;
	/**Dugme za postavljanje èvorišta**/
	private JButton btnJunctionPoint = null;
	/**Dugme za postavljanje komentara**/
	private JButton btnComment = null;

	/**Dugme za postavljanje elementa bafer**/
	private JButton btnBuffer = null;
	/**Dugme za postavljanje elementa NE**/
	private JButton btnNOT = null;
	/**Dugme za postavljanje elementa I**/
	private JButton btnAND = null;
	/**Dugme za postavljanje elementa NI**/
	private JButton btnNAND = null;
	/**Dugme za postavljanje elementa ILI**/
	private JButton btnOR = null;
	/**Dugme za postavljanje elementa NILI**/
	private JButton btnNOR = null;
	/**Dugme za postavljanje elementa Iskljuèivo ILI**/
	private JButton btnXOR = null;
	/**Dugme za postavljanje elementa Iskljuèivo NILI**/
	private JButton btnXNOR = null;
	/**Lokalizacija**/
	private Localization localization = null;

	public JPanel getContentPane() {
		return this.panel;
	}

	public JButton getButtonClose() {
		return this.btnClose;
	}

	public CustomToolbox(Editor editor) {
		localization = Localization.getInstance();
		// -----------Postavke JTabbedPane----------------//
		setPreferredSize(new Dimension(220, 0));
		setMaximumSize(new Dimension(220, 1000));

		FlowLayout panelLayout;
		panelLayout = new FlowLayout(5);
		ToolBoxActionListener customToolBoxListeer = new ToolBoxActionListener(editor);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(210, 0));
		panel.setLayout(panelLayout);

		// -----------Postavljanje elemenata ----------------//
		btnSelect = new JButton();
		btnSelect.setIcon(new ImageIcon("icons/LogickaKola/Cursor.png"));
		btnSelect.setPreferredSize(new Dimension(100, 50));
		btnSelect.setToolTipText(localization.getString("toolbox.select"));
		localization.registerComponent("toolbox.select", btnSelect);
		btnSelect.setOpaque(false);
		btnSelect.setContentAreaFilled(false);
		btnSelect.setBorderPainted(false);
		btnSelect.setActionCommand("select");
		btnSelect.addActionListener(customToolBoxListeer);
		panel.add(btnSelect);

		btnComment = new JButton();
		btnComment.setIcon(new ImageIcon("icons/LogickaKola/Comment.png"));
		btnComment.setPreferredSize(new Dimension(100, 50));
		btnComment.setToolTipText(localization.getString("toolbox.comment"));
		localization.registerComponent("toolbox.comment", btnComment);
		btnComment.setOpaque(false);
		btnComment.setContentAreaFilled(false);
		btnComment.setBorderPainted(false);
		btnComment.setRolloverEnabled(true);
		btnComment.setActionCommand("comment");
		btnComment.addActionListener(customToolBoxListeer);
		panel.add(btnComment);

		btnLine = new JButton();
		btnLine.setIcon(new ImageIcon("icons/LogickaKola/Wire.png"));
		btnLine.setPreferredSize(new Dimension(100, 50));
		btnLine.setToolTipText(localization.getString("toolbox.line"));
		localization.registerComponent("toolbox.line", btnLine);
		btnLine.setOpaque(false);
		btnLine.setContentAreaFilled(false);
		btnLine.setBorderPainted(false);
		btnLine.setActionCommand("line");
		btnLine.addActionListener(customToolBoxListeer);
		panel.add(btnLine);

		btnJunctionPoint = new JButton();
		btnJunctionPoint.setIcon(new ImageIcon("icons/LogickaKola/JunctionPoint.png"));
		btnJunctionPoint.setPreferredSize(new Dimension(100, 50));
		btnJunctionPoint.setToolTipText(localization.getString("toolbox.junctionPoint"));
		localization.registerComponent("toolbox.junctionPoint", btnJunctionPoint);
		btnJunctionPoint.setOpaque(false);
		btnJunctionPoint.setContentAreaFilled(false);
		btnJunctionPoint.setBorderPainted(false);
		btnJunctionPoint.setActionCommand("junctionPoint");
		btnJunctionPoint.addActionListener(customToolBoxListeer);
		panel.add(btnJunctionPoint);

		btnBuffer = new JButton();
		btnBuffer.setIcon(new ImageIcon("icons/LogickaKola/Buffer.png"));
		btnBuffer.setPreferredSize(new Dimension(100, 50));
		btnBuffer.setToolTipText(localization.getString("toolbox.buffer"));
		localization.registerComponent("toolbox.buffer", btnBuffer);
		btnBuffer.setOpaque(false);
		btnBuffer.setContentAreaFilled(false);
		btnBuffer.setBorderPainted(false);
		btnBuffer.setActionCommand("buffer");
		btnBuffer.addActionListener(customToolBoxListeer);
		panel.add(btnBuffer);

		btnNOT = new JButton();
		btnNOT.setIcon(new ImageIcon("icons/LogickaKola/NOT.png"));
		btnNOT.setPreferredSize(new Dimension(100, 50));
		btnNOT.setToolTipText(localization.getString("toolbox.not"));
		localization.registerComponent("toolbox.not", btnNOT);
		btnNOT.setOpaque(false);
		btnNOT.setContentAreaFilled(false);
		btnNOT.setBorderPainted(false);
		btnNOT.setRolloverEnabled(true);
		btnNOT.setActionCommand("not");
		btnNOT.addActionListener(customToolBoxListeer);
		panel.add(btnNOT);

		btnAND = new JButton();
		btnAND.setIcon(new ImageIcon("icons/LogickaKola/AND.png"));
		btnAND.setPreferredSize(new Dimension(100, 50));
		btnAND.setToolTipText(localization.getString("toolbox.and"));
		localization.registerComponent("toolbox.and", btnAND);
		btnAND.setOpaque(false);
		btnAND.setContentAreaFilled(false);
		btnAND.setBorderPainted(false);
		btnAND.setActionCommand("and");
		btnAND.addActionListener(customToolBoxListeer);
		panel.add(btnAND);

		btnNAND = new JButton();
		btnNAND.setIcon(new ImageIcon("icons/LogickaKola/NAND.png"));
		btnNAND.setPreferredSize(new Dimension(100, 50));
		btnNAND.setToolTipText(localization.getString("toolbox.nand"));
		localization.registerComponent("toolbox.nand", btnNAND);
		btnNAND.setOpaque(false);
		btnNAND.setContentAreaFilled(false);
		btnNAND.setBorderPainted(false);
		btnNAND.setActionCommand("nand");
		btnNAND.addActionListener(customToolBoxListeer);
		panel.add(btnNAND);

		btnOR = new JButton();
		btnOR.setIcon(new ImageIcon("icons/LogickaKola/OR.png"));
		btnOR.setPreferredSize(new Dimension(100, 50));
		btnOR.setToolTipText(localization.getString("toolbox.or"));
		localization.registerComponent("toolbox.or", btnOR);
		btnOR.setOpaque(false);
		btnOR.setContentAreaFilled(false);
		btnOR.setBorderPainted(false);
		btnOR.setActionCommand("or");
		btnOR.addActionListener(customToolBoxListeer);
		Icon orIcon = new Or(8, 8, differentViewObject);
		btnOR.setIcon(orIcon);
		panel.add(btnOR);

		btnNOR = new JButton();
		btnNOR.setIcon(new ImageIcon("icons/LogickaKola/NOR.png"));
		btnNOR.setPreferredSize(new Dimension(100, 50));
		btnNOR.setToolTipText(localization.getString("toolbox.nor"));
		localization.registerComponent("toolbox.nor", btnNOR);
		btnNOR.setOpaque(false);
		btnNOR.setContentAreaFilled(false);
		btnNOR.setBorderPainted(false);
		btnNOR.setRolloverEnabled(true);
		btnNOR.setActionCommand("nor");
		btnNOR.addActionListener(customToolBoxListeer);

		panel.add(btnNOR);

		btnXOR = new JButton();

		btnXOR.setPreferredSize(new Dimension(100, 50));
		btnXOR.setToolTipText(localization.getString("toolbox.xor"));
		localization.registerComponent("toolbox.xor", btnXOR);
		btnXOR.setOpaque(false);
		btnXOR.setContentAreaFilled(false);
		btnXOR.setBorderPainted(false);
		btnXOR.setActionCommand("xor");
		btnXOR.addActionListener(customToolBoxListeer);
		Icon icon = new Xor(8, 8, differentViewObject);
		btnXOR.setIcon(icon);

		panel.add(btnXOR);

		btnXNOR = new JButton();
		btnXNOR.setIcon(new ImageIcon("icons/LogickaKola/XNOR.png"));
		btnXNOR.setPreferredSize(new Dimension(100, 50));
		btnXNOR.setToolTipText(localization.getString("toolbox.xnor"));
		localization.registerComponent("toolbox.xnor", btnXNOR);
		btnXNOR.setOpaque(false);
		btnXNOR.setContentAreaFilled(false);
		btnXNOR.setBorderPainted(false);
		btnXNOR.setActionCommand("xnor");
		btnXNOR.addActionListener(customToolBoxListeer);
		panel.add(btnXNOR);

		// -----------Dodavanje taba----------------//
		addTab(localization.getString("kartice.toolbox"), panel);

	}
	/**Metoda za dodavanje taba
	 * @param str Naziv taba
	 * @param panel Panel na koji se postavlja tab
	 * **/
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

		localization.registerComponent("kartice.toolbox", labela);

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
	/**Metoda za postavljanje stanja**/
	public void selectState() {
		btnSelect.requestFocus();
	}
	/**Metoda za omoguæavanje dugmiæa**/
	public void enableButtons() {
		btnSelect.setEnabled(true);
		btnLine.setEnabled(true);
		btnJunctionPoint.setEnabled(true);
		btnComment.setEnabled(true);
		btnBuffer.setEnabled(true);
		btnNOT.setEnabled(true);
		btnAND.setEnabled(true);
		btnNAND.setEnabled(true);
		btnOR.setEnabled(true);
		btnNOR.setEnabled(true);
		btnXOR.setEnabled(true);
		btnXNOR.setEnabled(true);
	}
	/**Metoda za onemoguæavanje dugmiæa**/
	public void disableButtons() {
		btnSelect.setEnabled(false);
		btnLine.setEnabled(false);
		btnJunctionPoint.setEnabled(false);
		btnComment.setEnabled(false);
		btnBuffer.setEnabled(false);
		btnNOT.setEnabled(false);
		btnAND.setEnabled(false);
		btnNAND.setEnabled(false);
		btnOR.setEnabled(false);
		btnNOR.setEnabled(false);
		btnXOR.setEnabled(false);
		btnXNOR.setEnabled(false);
	}

	@Override
	public void addDragListener(DragListener arg0) {
		addMouseListener(arg0);
		addMouseMotionListener(arg0);
	}
}
