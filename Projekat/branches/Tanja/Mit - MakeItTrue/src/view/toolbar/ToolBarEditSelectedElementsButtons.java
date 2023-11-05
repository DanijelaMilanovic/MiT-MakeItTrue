package view.toolbar;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolBarEditSelectedElementsButtons {

	private JButton btnOznacavanjeE = null;
	private JButton btnRotiranje = null;
	private JButton btnHorizontalnoPoravnanje = null;
	private JButton btnVertikalnoPoravnanje = null;
	private JButton btnSpajanje = null;
	private JButton btnBrisanjeE = null;
	private Vector<JButton> buttons = null;

	public Vector<JButton> getToolBarEditSelectedElementsButtons() {
		return buttons;
	}

	public ToolBarEditSelectedElementsButtons() {
		buttons = new Vector<JButton>();

		btnOznacavanjeE = new JButton();
		btnOznacavanjeE.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/select.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnOznacavanjeE.setToolTipText("Oznaèavanje elementa");
		buttons.add(btnOznacavanjeE);

		btnRotiranje = new JButton();
		btnRotiranje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/rotate.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnRotiranje.setToolTipText("Rotiranje elementa");
		buttons.add(btnRotiranje);

		btnHorizontalnoPoravnanje = new JButton();
		btnHorizontalnoPoravnanje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/horizontal_aligh.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnHorizontalnoPoravnanje.setToolTipText("Horizontalno poravnanje elemenata");
		buttons.add(btnHorizontalnoPoravnanje);

		btnVertikalnoPoravnanje = new JButton();
		btnVertikalnoPoravnanje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/vertical_align.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnVertikalnoPoravnanje.setToolTipText("Vertikalno poravnanje elemenata");
		buttons.add(btnVertikalnoPoravnanje);

		btnSpajanje = new JButton();
		btnSpajanje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/merge_elements.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnSpajanje.setToolTipText("Spajanje elemenata");
		buttons.add(btnSpajanje);

		btnBrisanjeE = new JButton();
		btnBrisanjeE.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/delete_element.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnBrisanjeE.setToolTipText("Brisanje elementa");
		buttons.add(btnBrisanjeE);

	}

}
