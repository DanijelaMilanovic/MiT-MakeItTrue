/***********************************************************************
 * Module:  Toolbox.java
 * Author:  Notebook
 * Purpose: Defines the Class Toolbox
 ***********************************************************************/

package view;

import model.ExecutableCommand;
import observer.Subject;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JCheckBoxMenuItem;

public class Toolbox extends ComponentDecorator {
	public java.util.Collection<ExecutableCommand> executableCommand;
	CustomToolbox customToolBox;

	public CustomToolbox getCustomToolBox() {
		return customToolBox;
	}

	public void setCustomToolBox(CustomToolbox customToolBox) {
		this.customToolBox = customToolBox;
	}

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

	/**
	 * @pdGenerated default setter
	 * @param newExecutableCommand
	 */
	@SuppressWarnings("rawtypes")
	public void setExecutableCommand(java.util.Collection<ExecutableCommand> newExecutableCommand) {
		removeAllExecutableCommand();
		for (java.util.Iterator iter = newExecutableCommand.iterator(); iter.hasNext();)
			addExecutableCommand((ExecutableCommand) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newExecutableCommand
	 */
	public void addExecutableCommand(ExecutableCommand newExecutableCommand) {
		if (newExecutableCommand == null)
			return;
		if (this.executableCommand == null)
			this.executableCommand = new java.util.HashSet<ExecutableCommand>();
		if (!this.executableCommand.contains(newExecutableCommand))
			this.executableCommand.add(newExecutableCommand);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldExecutableCommand
	 */
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

	public Toolbox(Editor editor, JCheckBoxMenuItem menuItem) {
		super(editor);
		getContentPane().add(editor.getContentPane(), BorderLayout.CENTER);
		
		customToolBox = new CustomToolbox();
		customToolBox.getContentPane().setComponentPopupMenu(new ContextMenu("Toolbox").getContextMenu());

		showComponent();

		customToolBox.getButtonClose().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hideComponent();
				if(menuItem.isSelected()) {
					menuItem.setSelected(false);
					menuItem.updateUI();
				}
			}
		});
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton aButton = (AbstractButton) e.getSource(); 
				boolean selected = aButton.getModel().isSelected();
				
				if(selected) {
					showComponent();
				}
				else {
					hideComponent();
				}
			}
		});
	}

	@Override
	public void hideComponent() {
		editor.getContentPane().remove(customToolBox);
		editor.getContentPane().updateUI();

	}

	@Override
	public void showComponent() {
		editor.getContentPane().add(customToolBox, BorderLayout.EAST);
		editor.getContentPane().updateUI();
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub

	}

}