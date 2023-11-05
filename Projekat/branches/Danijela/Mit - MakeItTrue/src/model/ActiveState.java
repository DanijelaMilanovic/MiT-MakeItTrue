/***********************************************************************
 * Module:  ActiveState.java
 * Author:  Notebook
 * Purpose: Defines the Class ActiveState
 ***********************************************************************/

package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ActiveState implements ApplicationState {
	/** @param context */
	public void createProject(ApplicationModel context, String path) {
		File newProject = new File(path);

		try {
			Files.createDirectories(newProject.toPath());

			Files.createFile(Paths
					.get(newProject.toPath().toString() + FileSystems.getDefault().getSeparator() + ".projectMiT"));

			Project project = new Project(newProject.toPath().getFileName().toString(), newProject.getAbsolutePath());
			project.addDiagram(new Diagram("Ime dijagrama"));
			context.addActiveProject(project);
			context.getDataExporter().getExporter().exportProject(project, newProject.getAbsolutePath());

			context.notifyObservers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/** @param context */
	public void openProject(ApplicationModel context) {
		// TODO: implement
	}

	/** @param context */
	public void closeProject(ApplicationModel context) {
		// TODO: implement
	}

	/** @param context */
	public void deleteProject(ApplicationModel context) {
		// TODO: implement
	}

	@Override
	public void saveProject(ApplicationModel context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAsProject(ApplicationModel context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void renameProject(ApplicationModel context) {
		// TODO Auto-generated method stub

	}

}