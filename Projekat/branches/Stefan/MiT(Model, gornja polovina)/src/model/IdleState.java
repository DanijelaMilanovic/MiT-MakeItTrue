/***********************************************************************
 * Module:  IdleState.java
 * Author:  Notebook
 * Purpose: Defines the Class IdleState
 ***********************************************************************/

package model;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IdleState implements ApplicationState {

   public void createProject(ApplicationModel context) {
	   final JFileChooser folderChooser = new JFileChooser();
	   folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	   folderChooser.setDialogTitle("Create project folder");
	   folderChooser.setDialogType(JFileChooser.SAVE_DIALOG);
	   folderChooser.setApproveButtonText("Create");
	   
	   //Izvrsiti prilagodjavanje prozora
	   JTextField field = new JTextField("Hello, World");
	   JPanel accessory = new JPanel();
	   accessory.setLayout(new BorderLayout());
	   accessory.add(new JLabel("Project name: "), BorderLayout.NORTH);
	   accessory.add(field, BorderLayout.CENTER);
	 
	   folderChooser.setAccessory(accessory);
	    
	   File newProject = null;
	   String newProjectName = "";
	    int result;
	    context.setCurrentState(new EditingState());
	    context.notifyObservers();
	    
	    do
	    {
		 result = JFileChooser.CANCEL_OPTION;
		 if (folderChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
		  JPanel fcAccessory = (JPanel)folderChooser.getAccessory();
		  newProjectName = "";
		  for(Component comp : fcAccessory.getComponents()){
			    if(comp instanceof JTextField){ 
			        newProjectName = ((JTextField)comp).getText();
			    }
			}
	    result = JFileChooser.APPROVE_OPTION;
	    newProject = new File(folderChooser.getSelectedFile().getAbsolutePath().concat(FileSystems.getDefault().getSeparator() + newProjectName));
	   }
	   else break;
	   if(newProject.exists() && result == JFileChooser.APPROVE_OPTION) {
	        JOptionPane.showMessageDialog(null, "Projekat sa istim imenom vec postoji", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
	   }
	 }while(newProject.exists() && result == JFileChooser.APPROVE_OPTION);
	   
	    	 try {
	    		 if (result == JFileChooser.APPROVE_OPTION)
	    		 {
	    			 Files.createDirectories(newProject.toPath());
	    			 Files.createFile(Paths.get(newProject.toPath().toString() + FileSystems.getDefault().getSeparator() + ".projectMiT"));
	    			 
	    			 Project project = new Project(newProjectName, newProject.getAbsolutePath());
	    			 project.addDiagram(new Diagram("Ime dijagrama"));
	    			 context.addActiveProjects(project);
	    			 context.getDataExporter().getExporter().export(project , newProject.getAbsolutePath());
	    			 
	    			  context.changeState(new IdleState());
	    			    context.notifyObservers();
	    		 }
	    	} catch (IOException e) {
				System.out.println(e);
			}
	    	  context.setCurrentState(new IdleState());
	  	    context.notifyObservers();
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

}