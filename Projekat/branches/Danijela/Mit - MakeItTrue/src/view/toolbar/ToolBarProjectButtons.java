package view.toolbar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.ApplicationModel;
import model.commands.CreateProject;

public class ToolBarProjectButtons {

	private JButton btnKreiranjeP = null;
	private JButton btnOtvaranjeP = null;
	private JButton btnCuvanjeP = null;
	private JButton btnCuvanjeKaoP = null;
	private JButton btnBrisanjeP = null;
	private JButton btnZatvaranjeP = null;
	private Vector<JButton> buttons = null;

	public Vector<JButton> getToolBarProjectButtons() {
		return this.buttons;
	}

	public ToolBarProjectButtons(ApplicationModel appModel) {
		buttons = new Vector<JButton>();

		btnKreiranjeP = new JButton();
		btnKreiranjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/new_p.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnKreiranjeP.setToolTipText("Kreiranje novog projekta");
		btnKreiranjeP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateProject(appModel).execute();
			}});
		buttons.add(btnKreiranjeP);

		btnOtvaranjeP = new JButton();
		btnOtvaranjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/open_project.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnOtvaranjeP.setToolTipText("Otvaranje projekta");
		buttons.add(btnOtvaranjeP);

		btnCuvanjeP = new JButton();
		btnCuvanjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/save_project.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnCuvanjeP.setToolTipText("Èuvanje postojeæeg projekta");
		buttons.add(btnCuvanjeP);

		btnCuvanjeKaoP = new JButton();
		btnCuvanjeKaoP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/save_as_project.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnCuvanjeKaoP.setToolTipText("Èuvanje novog projekta");
		buttons.add(btnCuvanjeKaoP);

		btnBrisanjeP = new JButton();
		btnBrisanjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/delete_project.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnBrisanjeP.setToolTipText("Brisanje projekta");
		buttons.add(btnBrisanjeP);

		btnZatvaranjeP = new JButton();
		btnZatvaranjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/close_project.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnZatvaranjeP.setToolTipText("Zatvaranje projekta");
		buttons.add(btnZatvaranjeP);

	}

}
