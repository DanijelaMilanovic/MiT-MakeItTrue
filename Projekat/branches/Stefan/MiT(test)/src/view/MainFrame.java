package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.AbstractExecutableCommand;
import model.ApplicationModel;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame(ApplicationModel app) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Naslov");
		setSize(new Dimension(800, 600));
		setLocationRelativeTo(null);
		
		JButton btnCreate = new JButton("Create project");
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AbstractExecutableCommand(app).execute();
			}
		});
		getContentPane().add(btnCreate);
		setVisible(true);
	}
}
