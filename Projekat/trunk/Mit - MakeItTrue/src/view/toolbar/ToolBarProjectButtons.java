package view.toolbar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import localization.Localization;
import model.ApplicationModel;
import model.commands.CreateProject;
import model.commands.OpenProject;
import model.commands.SaveProject;

public class ToolBarProjectButtons {

	private JButton btnKreiranjeP = null;
	private JButton btnOtvaranjeP = null;
	private JButton btnCuvanjeP = null;
	private JButton btnCuvanjeKaoP = null;
	private JButton btnBrisanjeP = null;
	private JButton btnZatvaranjeP = null;
	private Vector<JButton> buttons = null;
	private Localization localization=null;

	public Vector<JButton> getToolBarProjectButtons() {
		return this.buttons;
	}

	public ToolBarProjectButtons(ApplicationModel appModel) {
		buttons = new Vector<JButton>();
		
		localization = Localization.getInstance();


		btnKreiranjeP = new JButton();
		btnKreiranjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/new_p.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnKreiranjeP.setToolTipText(localization.getString("toolbar.pCreate"));
		localization.registerComponent("toolbar.pCreate", btnKreiranjeP);
		btnKreiranjeP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateProject(appModel).execute();
			}});
		buttons.add(btnKreiranjeP);

		btnOtvaranjeP = new JButton();
		btnOtvaranjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/open_project.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnOtvaranjeP.setToolTipText(localization.getString("toolbar.pOpen"));
		localization.registerComponent("toolbar.pOpen", btnOtvaranjeP);
		btnOtvaranjeP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new OpenProject(appModel).execute();
			}});
		buttons.add(btnOtvaranjeP);

		btnCuvanjeP = new JButton();
		btnCuvanjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/save_project.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnCuvanjeP.setToolTipText(localization.getString("toolbar.pSave"));
		localization.registerComponent("toolbar.pSave", btnCuvanjeP);
		btnCuvanjeP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SaveProject(appModel).execute();
			}});
		buttons.add(btnCuvanjeP);

		btnCuvanjeKaoP = new JButton();
		btnCuvanjeKaoP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/save_as_project.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnCuvanjeKaoP.setToolTipText(localization.getString("toolbar.pSaveAs"));
		localization.registerComponent("toolbar.pSaveAs", btnCuvanjeKaoP);
		buttons.add(btnCuvanjeKaoP);

		btnBrisanjeP = new JButton();
		btnBrisanjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/delete_project.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnBrisanjeP.setToolTipText(localization.getString("toolbar.pDelete"));
		localization.registerComponent("toolbar.pDelete", btnBrisanjeP);
		buttons.add(btnBrisanjeP);

		btnZatvaranjeP = new JButton();
		btnZatvaranjeP.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/close_project.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnZatvaranjeP.setToolTipText(localization.getString("toolbar.pClose"));
		localization.registerComponent("toolbar.pClose", btnZatvaranjeP);
		buttons.add(btnZatvaranjeP);

	}

}
