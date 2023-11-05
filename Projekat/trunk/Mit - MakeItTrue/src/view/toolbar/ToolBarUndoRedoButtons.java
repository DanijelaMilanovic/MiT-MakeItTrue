package view.toolbar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import localization.Localization;
import model.ApplicationModel;
import model.commands.RedoCommand;
import model.commands.UndoCommand;

public class ToolBarUndoRedoButtons {

	private JButton btnPovratakNaPrethodniKorak = null;
	private JButton btnPovratakNaPonisteniKorak = null;
	private Vector<JButton> buttons = null;
	private Localization localization = null;

	public Vector<JButton> getToolBarUndoRedoButtons() {
		return this.buttons;
	}

	public ToolBarUndoRedoButtons(ApplicationModel appModel) {
		buttons = new Vector<JButton>();

		localization = Localization.getInstance();

		btnPovratakNaPrethodniKorak = new JButton();
		btnPovratakNaPrethodniKorak.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/undo.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnPovratakNaPrethodniKorak.setToolTipText(localization.getString("toolbar.eUndo"));
		btnPovratakNaPrethodniKorak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UndoCommand(appModel).execute();
			}
		});
		localization.registerComponent("toolbar.eUndo", btnPovratakNaPrethodniKorak);
		buttons.add(btnPovratakNaPrethodniKorak);

		btnPovratakNaPonisteniKorak = new JButton();
		btnPovratakNaPonisteniKorak.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/redo.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnPovratakNaPonisteniKorak.setToolTipText(localization.getString("toolbar.eRedo"));
		btnPovratakNaPonisteniKorak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new RedoCommand(appModel).execute();
			}
		});
		localization.registerComponent("toolbar.eRedo", btnPovratakNaPonisteniKorak);
		buttons.add(btnPovratakNaPonisteniKorak);
	}

	public void enableButtons() {
		for (JButton btn : buttons) {
			btn.setEnabled(true);
		}
	}

	public void disableButtons() {
		for (JButton btn : buttons) {
			btn.setEnabled(false);
		}
	}
}
