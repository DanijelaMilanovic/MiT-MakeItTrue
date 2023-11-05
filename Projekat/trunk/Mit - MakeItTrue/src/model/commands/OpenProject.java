package model.commands;

import java.io.File;
import java.nio.file.FileSystems;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import localization.Localization;
import model.AbstractExecutableCommand;
import model.ApplicationModel;

/**
 * 
 * Klasa koja realizuje otvaranje projekta
 *
 */
public class OpenProject extends AbstractExecutableCommand {
	private Localization localization;
	
	public OpenProject(ApplicationModel applicationModel) {
		super(applicationModel);
	}

	public void execute() {
		JFileChooser folderChooser = new JFileChooser();
		String path = askUser(folderChooser);
		if (path != "" && !applicationModel.existProject(path))
			this.applicationModel.openProject(path);
		else if(applicationModel.existProject(path)) {
			JOptionPane.showMessageDialog(null, localization.getString("dialog.openProject_message1"), localization.getString("dialog.create_warning"),
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private String askUser(JFileChooser folderChooser) {
		File mitFile = null;
		int result;
		
		localization = Localization.getInstance();
		
		folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		folderChooser.setDialogTitle(localization.getString("dialog.openProject_title"));
		folderChooser.setDialogType(JFileChooser.SAVE_DIALOG);
		folderChooser.setApproveButtonText(localization.getString("dialog.open_button"));

		do {
			result = JFileChooser.CANCEL_OPTION;
			if (folderChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) { 
				result = JFileChooser.APPROVE_OPTION;
				mitFile = new File(folderChooser.getSelectedFile().getAbsolutePath()
						.concat(FileSystems.getDefault().getSeparator() + ".projectMiT"));
			} 
			else 
				break;
			if (!mitFile.exists() && result == JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, localization.getString("dialog.openProject_message1"), localization.getString("dialog.create_warning"),
						JOptionPane.INFORMATION_MESSAGE);
			}
		} while(!mitFile.exists() && result == JFileChooser.APPROVE_OPTION);
		if(result == JFileChooser.APPROVE_OPTION) {
			return folderChooser.getSelectedFile().getAbsolutePath(); 
		}
		return "";
	}

}
