/***********************************************************************
 * Module:  CreateProject.java
 * Author:  Notebook
 * Purpose: Defines the Class CreateProject
 ***********************************************************************/

package model.commands;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.nio.file.FileSystems;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import localization.Localization;
import model.AbstractExecutableCommand;
import model.ApplicationModel;

/**
 * 
 * Klasa koja realizuje kreiranje projekta
 *
 */
public class CreateProject extends AbstractExecutableCommand {
	private Localization localization;

	public CreateProject(ApplicationModel applicationModel) {
		super(applicationModel);
	}

	@Override
	public void execute() {
		JFileChooser folderChooser = new JFileChooser();
		String path = askUser(folderChooser);
		if (path != "")
			this.applicationModel.createProject(path);
	}

	private String askUser(JFileChooser folderChooser) {
		localization = Localization.getInstance();
		
		folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		folderChooser.setDialogTitle(localization.getString("dialog.createProject_title"));
		folderChooser.setDialogType(JFileChooser.SAVE_DIALOG);
		folderChooser.setApproveButtonText(localization.getString("dialog.create_button"));

		// Izvrsiti prilagodjavanje prozora
		JTextField field = new JTextField("Hello, World");
		JPanel accessory = new JPanel();
		accessory.setLayout(new BorderLayout());
		accessory.add(new JLabel(localization.getString("dialog.createProject_name")), BorderLayout.NORTH);
		accessory.add(field, BorderLayout.CENTER);

		folderChooser.setAccessory(accessory);

		File newProject = null;
		String newProjectName = "";
		int result;

		do {
			result = JFileChooser.CANCEL_OPTION;
			if (folderChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				JPanel fcAccessory = (JPanel) folderChooser.getAccessory();
				newProjectName = "";
				for (Component comp : fcAccessory.getComponents()) {
					if (comp instanceof JTextField) {
						newProjectName = ((JTextField) comp).getText();
					}
				}
				result = JFileChooser.APPROVE_OPTION;
				newProject = new File(folderChooser.getSelectedFile().getAbsolutePath()
						.concat(FileSystems.getDefault().getSeparator() + newProjectName));
			} else
				break;
			if (newProject.exists() && result == JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, localization.getString("dialog.createProject_message1"), localization.getString("dialog.create_warning"),
						JOptionPane.INFORMATION_MESSAGE);
			}
		} while (newProject.exists() && result == JFileChooser.APPROVE_OPTION);

		if (result == JFileChooser.APPROVE_OPTION) {
			return folderChooser.getSelectedFile().getAbsolutePath()
					.concat(FileSystems.getDefault().getSeparator() + newProjectName);
		}
		return "";
	}
}