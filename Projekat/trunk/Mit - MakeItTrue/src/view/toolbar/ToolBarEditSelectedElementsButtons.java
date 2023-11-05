package view.toolbar;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import localization.Localization;
import model.ApplicationModel;

public class ToolBarEditSelectedElementsButtons {

	private JButton btnOznacavanjeE = null;
	private JButton btnRotiranje = null;
	private JButton btnHorizontalnoPoravnanje = null;
	private JButton btnVertikalnoPoravnanje = null;
	private JButton btnSpajanje = null;
	private JButton btnBrisanjeE = null;
	private Vector<JButton> buttons = null;
	private Localization localization=null;

	public Vector<JButton> getToolBarEditSelectedElementsButtons() {
		return buttons;
	}

	public ToolBarEditSelectedElementsButtons(ApplicationModel appModel) {
		buttons = new Vector<JButton>();
		
		localization = Localization.getInstance();

		btnOznacavanjeE = new JButton();
		btnOznacavanjeE.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/select.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnOznacavanjeE.setToolTipText(localization.getString("toolbar.eSelect"));
		localization.registerComponent("toolbar.eSelect", btnOznacavanjeE);
		buttons.add(btnOznacavanjeE);

		btnRotiranje = new JButton();
		btnRotiranje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/rotate.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnRotiranje.setToolTipText(localization.getString("toolbar.eRotate"));
		localization.registerComponent("toolbar.eRotate", btnRotiranje);
		buttons.add(btnRotiranje);

		btnHorizontalnoPoravnanje = new JButton();
		btnHorizontalnoPoravnanje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/horizontal_aligh.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnHorizontalnoPoravnanje.setToolTipText(localization.getString("toolbar.eHor"));
		localization.registerComponent("toolbar.eHor", btnHorizontalnoPoravnanje);
		buttons.add(btnHorizontalnoPoravnanje);

		btnVertikalnoPoravnanje = new JButton();
		btnVertikalnoPoravnanje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/vertical_align.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnVertikalnoPoravnanje.setToolTipText(localization.getString("toolbar.eVer"));
		localization.registerComponent("toolbar.eVer", btnVertikalnoPoravnanje);
		buttons.add(btnVertikalnoPoravnanje);

		btnSpajanje = new JButton();
		btnSpajanje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/merge_elements.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnSpajanje.setToolTipText(localization.getString("toolbar.eMerge"));
		localization.registerComponent("toolbar.eMerge", btnSpajanje);
		buttons.add(btnSpajanje);

		btnBrisanjeE = new JButton();
		btnBrisanjeE.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/delete_element.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnBrisanjeE.setToolTipText(localization.getString("toolbar.eDelete"));
		localization.registerComponent("toolbar.eDelete", btnBrisanjeE);
		buttons.add(btnBrisanjeE);

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
