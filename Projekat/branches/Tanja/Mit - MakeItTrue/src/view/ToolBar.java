/***********************************************************************
 * Module:  ToolBar.java
 * Author:  Notebook
 * Purpose: Defines the Class ToolBar
 ***********************************************************************/

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;

import model.ApplicationModel;
import model.CreateProject;
import model.ExecutableCommand;
import observer.Subject;
import view.toolbar.CustomToolBar;

public class ToolBar extends ViewComponents {
 
	private java.util.Collection<ExecutableCommand> executableCommand;
    private CustomToolBar toolBar;
	   
	   /** @pdGenerated default getter */
	   public java.util.Collection<ExecutableCommand> getExecutableCommand() {
	      if (executableCommand == null)
	         executableCommand = new java.util.HashSet<ExecutableCommand>();
	      return executableCommand;
	   }
	   
	   /** @pdGenerated default iterator getter */
	   @SuppressWarnings("rawtypes")
	   public java.util.Iterator getIteratorExecutableCommand() {
	      if (executableCommand == null)
	         executableCommand = new java.util.HashSet<ExecutableCommand>();
	      return executableCommand.iterator();
	   }
	   
	   /** @pdGenerated default setter
	     * @param newExecutableCommand */
	   @SuppressWarnings("rawtypes")
	   public void setExecutableCommand(java.util.Collection<ExecutableCommand> newExecutableCommand) {
	      removeAllExecutableCommand();
	      for (java.util.Iterator iter = newExecutableCommand.iterator(); iter.hasNext();)
	         addExecutableCommand((ExecutableCommand)iter.next());
	   }
	   
	   /** @pdGenerated default add
	     * @param newExecutableCommand */
	   public void addExecutableCommand(ExecutableCommand newExecutableCommand) {
	      if (newExecutableCommand == null)
	         return;
	      if (this.executableCommand == null)
	         this.executableCommand = new java.util.HashSet<ExecutableCommand>();
	      if (!this.executableCommand.contains(newExecutableCommand))
	         this.executableCommand.add(newExecutableCommand);
	   }
	   
	   /** @pdGenerated default remove
	     * @param oldExecutableCommand */
	   public void removeExecutableCommand(ExecutableCommand oldExecutableCommand) {
	      if (oldExecutableCommand == null)
	         return;
	      if (this.executableCommand != null)
	         if (this.executableCommand.contains(oldExecutableCommand))
	            this.executableCommand.remove(oldExecutableCommand);
	   }
	   
		   /** @pdGenerated default removeAll */
		   public void removeAllExecutableCommand() {
		      if (executableCommand != null)
		         executableCommand.clear();
		   }
		   
	   public JToolBar getToolBar() {
			return toolBar;
		}

		public void setToolBar(CustomToolBar toolBar) {
			this.toolBar = toolBar;
		}

		public ToolBar(ApplicationModel model) {
			   toolBar = new CustomToolBar();
			   toolBar.getToolBarProjectButtons().getBtnKreiranjeP().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new CreateProject(model).execute();
				}
				   
			   });
		   }

		@Override
		public void update(Subject subject) {
			// TODO Auto-generated method stub
			
		}

}