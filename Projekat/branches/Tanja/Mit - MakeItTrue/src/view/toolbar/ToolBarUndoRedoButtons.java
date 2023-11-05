package view.toolbar;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolBarUndoRedoButtons {

	private JButton btnPovratakNaPrethodniKorak = null;
	private JButton btnPovratakNaPonisteniKorak = null;
	private Vector<JButton> buttons = null;

	public Vector<JButton> getToolBarUndoRedoButtons() {
		return this.buttons;
	}

	public ToolBarUndoRedoButtons() {
		buttons = new Vector<JButton>();

		btnPovratakNaPrethodniKorak = new JButton();
		btnPovratakNaPrethodniKorak.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/undo.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnPovratakNaPrethodniKorak.setToolTipText("Povratak na prethodni korak");
		buttons.add(btnPovratakNaPrethodniKorak);

		btnPovratakNaPonisteniKorak = new JButton();
		btnPovratakNaPonisteniKorak.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/redo.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnPovratakNaPonisteniKorak.setToolTipText("Povratak na poništeni korak");
		buttons.add(btnPovratakNaPonisteniKorak);
	}
}
