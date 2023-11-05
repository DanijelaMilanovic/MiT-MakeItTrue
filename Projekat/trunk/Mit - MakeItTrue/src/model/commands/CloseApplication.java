package model.commands;

import javax.swing.JOptionPane;

import localization.Localization;
import model.AbstractExecutableCommand;
import model.ApplicationModel;

/**
 * 
 * Klasa koja realizuje zatvaranje aplikacije
 *
 */
public class CloseApplication extends AbstractExecutableCommand {

	private Localization localization;
	
	public CloseApplication(ApplicationModel applicationModel) {
		super(applicationModel);
	}

	public void execute() {
		localization = Localization.getInstance();
		
		String odgovori[] = { localization.getString("dialog.yes"), localization.getString("dialog.no") };
		
		int cuvanje = JOptionPane.showOptionDialog(null, localization.getString("dialog.message"), localization.getString("dialog.title"), 0,
				JOptionPane.WARNING_MESSAGE, null, odgovori, null);
		// Izvrsiti implementaciju ovog dijela

		if (cuvanje == JOptionPane.YES_OPTION) {
			new SaveProject(applicationModel).execute();
		}

		applicationModel.getApplicationProperty().saveConfig();
		System.exit(0);

	}

}
