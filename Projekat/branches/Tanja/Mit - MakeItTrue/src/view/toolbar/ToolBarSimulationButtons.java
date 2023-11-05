package view.toolbar;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolBarSimulationButtons {

	private JButton btnZapocniSimulaciju = null;
	private JButton btnZaustaviSimulaciju = null;
	private JButton btnZatvoriSimulaciju = null;
	private Vector<JButton> buttons = null;

	public Vector<JButton> getToolBarSimulationButtons() {
		return this.buttons;
	}

	public ToolBarSimulationButtons() {
		buttons = new Vector<JButton>();

		btnZapocniSimulaciju = new JButton();
		btnZapocniSimulaciju.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/start_simulation.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnZapocniSimulaciju.setToolTipText("Zapoèni simulaciju");
		buttons.add(btnZapocniSimulaciju);

		btnZaustaviSimulaciju = new JButton();
		btnZaustaviSimulaciju.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/pause_simulation.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnZaustaviSimulaciju.setToolTipText("Zaustavi simulaciju");
		buttons.add(btnZaustaviSimulaciju);

		btnZatvoriSimulaciju = new JButton();
		btnZatvoriSimulaciju.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/stop_simulation.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnZatvoriSimulaciju.setToolTipText("Zatvori simulaciju");
		buttons.add(btnZatvoriSimulaciju);

	}

}
