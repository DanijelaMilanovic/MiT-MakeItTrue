package view.toolbar;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import localization.Localization;
import model.ApplicationModel;

public class ToolBarSimulationButtons {

	private JButton btnZapocniSimulaciju = null;
	private JButton btnZaustaviSimulaciju = null;
	private JButton btnZatvoriSimulaciju = null;
	private Vector<JButton> buttons = null;
	private Localization localization = null;

	public Vector<JButton> getToolBarSimulationButtons() {
		return this.buttons;
	}

	public ToolBarSimulationButtons(ApplicationModel appModel) {
		buttons = new Vector<JButton>();
		localization = Localization.getInstance();

		btnZapocniSimulaciju = new JButton();
		btnZapocniSimulaciju.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/start_simulation.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnZapocniSimulaciju.setToolTipText(localization.getString("toolbar.sStart"));
		localization.registerComponent("toolbar.sStart", btnZapocniSimulaciju);
		buttons.add(btnZapocniSimulaciju);

		btnZaustaviSimulaciju = new JButton();
		btnZaustaviSimulaciju.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/pause_simulation.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnZaustaviSimulaciju.setToolTipText(localization.getString("toolbar.sPause"));
		localization.registerComponent("toolbar.sPause", btnZaustaviSimulaciju);
		buttons.add(btnZaustaviSimulaciju);

		btnZatvoriSimulaciju = new JButton();
		btnZatvoriSimulaciju.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/stop_simulation.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnZatvoriSimulaciju.setToolTipText(localization.getString("toolbar.sStop"));
		localization.registerComponent("toolbar.sStop", btnZatvoriSimulaciju);
		buttons.add(btnZatvoriSimulaciju);

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
