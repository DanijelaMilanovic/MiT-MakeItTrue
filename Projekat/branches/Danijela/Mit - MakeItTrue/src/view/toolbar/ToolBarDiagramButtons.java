package view.toolbar;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.ApplicationModel;

public class ToolBarDiagramButtons {

	private JButton btnKreiranjeD = null;
	private JButton btnCuvanjeKaoD = null;
	private JButton btnPreimenovanjeD = null;
	private JButton btnUvecajD = null;
	private JButton btnUmanjiD = null;
	private JButton btnBrisanjeD = null;
	private JButton btnZatvaranjeD = null;
	private Vector<JButton> buttons = null;

	public Vector<JButton> getToolBarDiagramButtons() {
		return this.buttons;
	}

	public ToolBarDiagramButtons(ApplicationModel appModel) {

		buttons = new Vector<JButton>();

		btnKreiranjeD = new JButton();
		btnKreiranjeD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/create_diagram.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnKreiranjeD.setToolTipText("Kreiranje novog dijagrama");
		buttons.add(btnKreiranjeD);

		btnCuvanjeKaoD = new JButton();
		btnCuvanjeKaoD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/save_diagram.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnCuvanjeKaoD.setToolTipText("Čuvanje dijagrama");
		buttons.add(btnCuvanjeKaoD);

		btnPreimenovanjeD = new JButton();
		btnPreimenovanjeD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/rename_diagram.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnPreimenovanjeD.setToolTipText("Preimenovanje dijagrama");
		buttons.add(btnPreimenovanjeD);

		btnUvecajD = new JButton();
		btnUvecajD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/zoom_in_diagram.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnUvecajD.setToolTipText("Uvećavanje prikaza dijagrama");
		buttons.add(btnUvecajD);

		btnUmanjiD = new JButton();
		btnUmanjiD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/zoom_out_diagram.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnUmanjiD.setToolTipText("Umanjenje prikaza dijagrama");
		buttons.add(btnUmanjiD);

		btnBrisanjeD = new JButton();
		btnBrisanjeD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/delete_diagram.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnBrisanjeD.setToolTipText("Brisanje dijagrama");
		buttons.add(btnBrisanjeD);

		btnZatvaranjeD = new JButton();
		btnZatvaranjeD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/close_diagram.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnZatvaranjeD.setToolTipText("Zatvaranje dijagrama");
		buttons.add(btnZatvaranjeD);

	}

}
