package view.toolbar;

import java.awt.Image;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import localization.Localization;
import model.ApplicationModel;
import model.commands.CreateDiagram;

public class ToolBarDiagramButtons {

	private JButton btnKreiranjeD = null;
	private JButton btnCuvanjeKaoD = null;
	private JButton btnPreimenovanjeD = null;
	private JButton btnUvecajD = null;
	private JButton btnUmanjiD = null;
	private JButton btnBrisanjeD = null;
	private JButton btnZatvaranjeD = null;
	private Vector<JButton> buttons = null;
	private Localization localization=null;


	public Vector<JButton> getToolBarDiagramButtons() {
		return this.buttons;
	}

	public ToolBarDiagramButtons(ApplicationModel appModel) {

		buttons = new Vector<JButton>();
		
		localization = Localization.getInstance();

		btnKreiranjeD = new JButton();
		btnKreiranjeD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/create_diagram.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnKreiranjeD.setToolTipText(localization.getString("toolbar.dCreate"));
		localization.registerComponent("toolbar.dCreate", btnKreiranjeD);
		btnKreiranjeD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateDiagram(appModel).execute();

			}
		});
		buttons.add(btnKreiranjeD);

		btnCuvanjeKaoD = new JButton();
		btnCuvanjeKaoD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/save_diagram.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnCuvanjeKaoD.setToolTipText(localization.getString("toolbar.dSave"));
		localization.registerComponent("toolbar.dSave", btnCuvanjeKaoD);
		buttons.add(btnCuvanjeKaoD);

		btnPreimenovanjeD = new JButton();
		btnPreimenovanjeD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/rename_diagram.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnPreimenovanjeD.setToolTipText(localization.getString("toolbar.dRename"));
		localization.registerComponent("toolbar.dRename", btnPreimenovanjeD);
		buttons.add(btnPreimenovanjeD);

		btnUvecajD = new JButton();
		btnUvecajD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/zoom_in_diagram.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnUvecajD.setToolTipText(localization.getString("toolbar.dZoomIn"));
		localization.registerComponent("toolbar.dZoomIn", btnUvecajD);
		buttons.add(btnUvecajD);

		btnUmanjiD = new JButton();
		btnUmanjiD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/zoom_out_diagram.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnUmanjiD.setToolTipText(localization.getString("toolbar.dZoomOut"));
		localization.registerComponent("toolbar.dZoomOut", btnUmanjiD);
		buttons.add(btnUmanjiD);

		btnBrisanjeD = new JButton();
		btnBrisanjeD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/delete_diagram.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnBrisanjeD.setToolTipText(localization.getString("toolbar.dDelete"));
		localization.registerComponent("toolbar.dDelete", btnBrisanjeD);
		buttons.add(btnBrisanjeD);

		btnZatvaranjeD = new JButton();
		btnZatvaranjeD.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/close_diagram.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		btnZatvaranjeD.setToolTipText(localization.getString("toolbar.dClose"));
		localization.registerComponent("toolbar.dClose", btnZatvaranjeD);
		buttons.add(btnZatvaranjeD);

	}
	
	public void enableButtons() {
		for(JButton btn : buttons) {
			btn.setEnabled(true);
		}
	}

	public void disableButtons() {
		for(JButton btn : buttons) {
			btn.setEnabled(false);
		}
	}

}
