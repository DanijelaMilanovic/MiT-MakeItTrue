/***********************************************************************
 * Module:  MainFrame.java
 * Author:  Notebook
 * Purpose: Defines the Class MainFrame
 ***********************************************************************/

package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import model.AbstractExecutableCommand;
import model.ApplicationModel;
import model.CreateProject;
import obeserver.IObserver;
import obeserver.ISubject;
import test.XMLJTree;
import view.statsbar.MainStatusBar;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class MainFrame extends JFrame implements IObserver {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainStatusBar statusBar;
	ApplicationModel appModel;
	
	public MainFrame(ApplicationModel app) {
		setTitle("Test");
		this.appModel = app;
		
		setSize(new Dimension(800, 600));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - 150, dim.height / 2 - 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JButton createProject = new JButton("Create Project"); 
		createProject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateProject(app).execute();
			}
		});
		
		mainPanel.add(createProject, BorderLayout.EAST);
		
		//Treba Observer da obavjesti kada se kreira...
		JTree stablo = new XMLJTree("./xml/.projectMIT");
		mainPanel.add(new JScrollPane(stablo), BorderLayout.CENTER);
		
		statusBar = new MainStatusBar();
		mainPanel.add(statusBar, BorderLayout.SOUTH);
		
		this.getContentPane().add(mainPanel);
		
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch(Exception e)
		{
		    System.out.println("Failed loading L&F");
		}

		setVisible(true);
	}

	@Override
	public void update(ISubject subject) {
		statusBar.update(appModel);
	}


}