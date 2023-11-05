package model.commands;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import localization.Localization;
import model.AbstractExecutableCommand;
import model.ApplicationModel;
import model.Project;

import java.awt.BorderLayout;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.awt.Component;

/**
 * 
 * Klasa koja realizuje kreiranje dijagrama
 *
 */
public class CreateDiagram extends AbstractExecutableCommand {

	private Localization localization;

	public CreateDiagram(ApplicationModel applicationModel) {
		super(applicationModel);
	}

	@Override
	public void execute() {
		JFileChooser folderChooser = new JFileChooser();
		String path = askUser(folderChooser);
		if (path != "") {
			String pathProject = new File(path).getParent();
			boolean isLoading = false;
			Project project = null;

			for (Project openProject : applicationModel.getActiveProjects()) {
				if (pathProject.equals(openProject.getUrl())) {
					project = openProject;
					isLoading = true;
					break;
				}
			}
			if (!isLoading) {
				applicationModel.openProject(pathProject);
				project = applicationModel.getActiveProjects().lastElement();
			}
			try {
				project.createDiagram(Paths.get(path).getFileName().toString());
				applicationModel.getDataExporter().getExporter().exportDiagram(project.getDiagrams().lastElement(),
						project.getUrl() + FileSystems.getDefault().getSeparator()
								+ project.getDiagrams().lastElement().getName() + ".mit");
				applicationModel.notifyObservers();
			} catch (Exception e) {
			}
		}
	}

	private String askUser(JFileChooser folderChooser) {
		localization = Localization.getInstance();

		folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		folderChooser.setDialogTitle(localization.getString("dialog.createDiagram_title"));
		folderChooser.setDialogType(JFileChooser.SAVE_DIALOG);
		folderChooser.setApproveButtonText(localization.getString("dialog.create_button"));

		// Izvrsiti prilagodjavanje prozora
		JTextField field = new JTextField("Hello, World");
		JPanel accessory = new JPanel();
		accessory.setLayout(new BorderLayout());
		accessory.add(new JLabel(localization.getString("dialog.createDiagram_name")), BorderLayout.NORTH);
		accessory.add(field, BorderLayout.CENTER);

		folderChooser.setAccessory(accessory);

		File mitProject = null;
		File newdiagram = null;
		String newdiagramName = "";
		int result;

		do {
			result = JFileChooser.CANCEL_OPTION;
			if (folderChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				JPanel fcAccessory = (JPanel) folderChooser.getAccessory();
				newdiagramName = "";
				for (Component comp : fcAccessory.getComponents()) {
					if (comp instanceof JTextField) {
						newdiagramName = ((JTextField) comp).getText();
					}
				}
				result = JFileChooser.APPROVE_OPTION;

				mitProject = new File(folderChooser.getSelectedFile().getAbsolutePath()
						.concat(FileSystems.getDefault().getSeparator() + ".projectMiT"));
				newdiagram = new File(folderChooser.getSelectedFile().getAbsolutePath()
						.concat(FileSystems.getDefault().getSeparator() + newdiagramName));
			} else
				break;
			if (!mitProject.exists() && result == JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, localization.getString("dialog.createDiagram_message1"),
						localization.getString("dialog.create_warning"), JOptionPane.INFORMATION_MESSAGE);
			} else if (newdiagram.exists() && result == JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, localization.getString("dialog.createDiagram_message2"),
						localization.getString("dialog.create_warning"), JOptionPane.INFORMATION_MESSAGE);
			}
		} while ((!mitProject.exists() || newdiagram.exists()) && result == JFileChooser.APPROVE_OPTION);

		if (result == JFileChooser.APPROVE_OPTION) {
			return folderChooser.getSelectedFile().getAbsolutePath()
					.concat(FileSystems.getDefault().getSeparator() + newdiagramName);
		}
		return "";
	}
}
