/***********************************************************************
 * Module:  ApplicationModel.java
 * Author:  Notebook
 * Purpose: Defines the Class ApplicationModel
 ***********************************************************************/

package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Component;
import java.awt.BorderLayout;
 
public class ApplicationModel {
   private java.util.Collection<Project> closedProject;
   private java.util.Collection<Project> activeProjects;
   
   public ApplicationModel() {
	activeProjects = new Vector<Project>();
	closedProject = new Vector<Project>();
}
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorActiveProjects() {
      if (activeProjects == null)
         activeProjects = new java.util.Vector<Project>();
      return activeProjects.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newActiveProjects */
   public void setActiveProjects(java.util.Collection<Project> newActiveProjects) {
      removeAllActiveProjects();
      for (java.util.Iterator iter = newActiveProjects.iterator(); iter.hasNext();)
         addActiveProjects((Project)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProject */
   public void addActiveProjects(Project newProject) {
      if (newProject == null)
         return;
      if (this.activeProjects == null)
         this.activeProjects = new java.util.Vector<Project>();
      if (!this.activeProjects.contains(newProject))
         this.activeProjects.add(newProject);
   }
   
   /** @pdGenerated default remove
     * @param oldProject */
   public void removeActiveProjects(Project oldProject) {
      if (oldProject == null)
         return;
      if (this.activeProjects != null)
         if (this.activeProjects.contains(oldProject))
            this.activeProjects.remove(oldProject);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllActiveProjects() {
      if (activeProjects != null)
         activeProjects.clear();
   }
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorClosedProject() {
      if (closedProject == null)
         closedProject = new java.util.Vector<Project>();
      return closedProject.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newClosedProject */
   public void setClosedProject(java.util.Collection<Project> newClosedProject) {
      removeAllClosedProject();
      for (java.util.Iterator iter = newClosedProject.iterator(); iter.hasNext();)
         addClosedProject((Project)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProject */
   public void addClosedProject(Project newProject) {
      if (newProject == null)
         return;
      if (this.closedProject == null)
         this.closedProject = new java.util.Vector<Project>();
      if (!this.closedProject.contains(newProject))
         this.closedProject.add(newProject);
   }
   
   /** @pdGenerated default remove
     * @param oldProject */
   public void removeClosedProject(Project oldProject) {
      if (oldProject == null)
         return;
      if (this.closedProject != null)
         if (this.closedProject.contains(oldProject))
            this.closedProject.remove(oldProject);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllClosedProject() {
      if (closedProject != null)
         closedProject.clear();
   }
   
   /** @param project */
   public void createProject() {
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
	    int result;
	 do
	 {
		 result = JFileChooser.CANCEL_OPTION;
	   if (folderChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
		  JPanel fcAccessory = (JPanel)folderChooser.getAccessory();
		  String newProjectName = "";
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
	    		 }
	    	} catch (IOException e) {
				System.out.println(e);
			}
	   }
}
  

