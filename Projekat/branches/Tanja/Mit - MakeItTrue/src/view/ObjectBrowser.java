/***********************************************************************
 * Module:  ObjectBrowser.java
 * Author:  Notebook
 * Purpose: Defines the Class ObjectBrowser
 ***********************************************************************/

package view;

import model.ExecutableCommand;
import observer.Subject;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ObjectBrowser extends ComponentDecorator {
	public java.util.Collection<ExecutableCommand> executableCommand;
	CustomObjectBrowser customObjectBrowser;

	public CustomObjectBrowser getCustomObjectBrowser() {
		return customObjectBrowser;
	}

	public void setCustomObjectBrowser(CustomObjectBrowser customObjectBrowser) {
		this.customObjectBrowser = customObjectBrowser;
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

	public ObjectBrowser(Editor editor, JCheckBoxMenuItem menuItem) {
		super(editor);
		getContentPane().add(editor.getContentPane(), BorderLayout.CENTER);

		//editor.getApplicationModel();
		//Varijante koje sam probala, a meni nisu radile: Probala sam preko editora kao gore
		//onda sam probala preko supera kao sto si ti predlozio nije radilo, onda sam probala preko konstruktora
		//ali mi onda vuce da mijenjam masu drugis stvari u ObjectBrowseru
		//onda samo poziv metode i nije ni to radilo
		customObjectBrowser = new CustomObjectBrowser();
		customObjectBrowser.getContentPane().setComponentPopupMenu(new ContextMenu("Object Browser").getContextMenu());

		showComponent();

		customObjectBrowser.getButtonClose().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hideComponent();
				if (menuItem.isSelected()) {
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

				if (selected) {
					showComponent();
				} else {
					hideComponent();
				}
			}
		});
	}

	@Override
	public void showComponent() {
		editor.getContentPane().add(customObjectBrowser, BorderLayout.WEST);
		editor.getContentPane().updateUI();

	}

	@Override
	public void hideComponent() {
		editor.getContentPane().remove(customObjectBrowser);
		editor.getContentPane().updateUI();
	}

	@Override
	public void update(Subject subject) {
		JTree mainTree=new JTree();
		mainTree.removeAll();
		DefaultMutableTreeNode activeProjects=new DefaultMutableTreeNode("aktivanProjekat");
		DefaultMutableTreeNode dijagrami=new DefaultMutableTreeNode("dijagram");
		DefaultMutableTreeNode closedProjcts=new DefaultMutableTreeNode("neaktivanProjekat");
		JTree customTree=null;

	    for(Iterator iterator=getApplicationModel().getIteratorActiveProjects(); iterator.hasNext();)
	    {
	    	customTree=new JTree(activeProjects);	
	    			 for(Iterator iteratorDijagrama=getIteratorDiagrams(); iteratorDijagrama.hasNext();)
	    			 {
	    				 activeProjects.add(dijagrami);
	    			 }
	    	mainTree.add(customTree);	
	    }
	    for(Iterator iterator2=getApplicationModel().getIteratorActiveProjects(); iterator2.hasNext();)
	    {
	    	customTree=new JTree(closedProjcts);	
	    	mainTree.add(customTree);
	    }
		customObjectBrowser.add(mainTree);
	}
}