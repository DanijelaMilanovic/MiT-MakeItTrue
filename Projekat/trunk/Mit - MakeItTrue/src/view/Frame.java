/***********************************************************************
 * Module:  Frame.java
 * Author:  G1
 ***********************************************************************/

package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import com.javadocking.DockingManager;
import com.javadocking.model.FloatDockModel;

import model.ApplicationModel;
import model.commands.CloseApplication;
/**Klasa koja definiše osnovni izgled prozora**/
public class Frame extends Window {

	private static final long serialVersionUID = 1L;
	/**Kontejner na koji se postavlja**/
	private Container contentPane = null;

	public Frame(ApplicationModel app) {
		super("mainFrame", app);

		FloatDockModel dockModel = new FloatDockModel();
		dockModel.addOwner("window", this);
		DockingManager.setDockModel(dockModel);

		Dimension screenSize;
		Dimension frameSize;
		Point location;

		// Osnovna podšavanja
		setTitle("MiT - MakeItTrue");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(app.getApplicationProperty().getState());
		getExtendedState();

		// Podesavanja dimenzija i lokacije
		screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		frameSize = app.getApplicationProperty().getDimension();
		setSize(frameSize);

		location = new Point((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setLocation(location);
		setMinimumSize(new Dimension(800, 600));

		// Postavljanje komponenti pogleda
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		for (ViewComponents viewComponent : getViewComponents()) {
			if (viewComponent.getClass().getName() == ToolBar.class.getName()) {
				contentPane.add(((ToolBar) viewComponent), BorderLayout.NORTH);
			} else if (viewComponent.getClass().getName() == StatusBar.class.getName()) {
				contentPane.add(((StatusBar) viewComponent), BorderLayout.SOUTH);
			} else if (viewComponent.getClass().getName() == Toolbox.class.getName()) {
				dockModel.addRootDock("root", ((Toolbox) viewComponent).getContentPane(), this);
				contentPane.add(((Toolbox) viewComponent).getContentPane(), BorderLayout.CENTER);
			} else if (viewComponent.getClass().getName() == GraficEditor.class.getName()) {
				dockModel.addRootDock("root", ((GraficEditor) viewComponent).getContentPane(), this);
				contentPane.add(((GraficEditor) viewComponent).getContentPane(), BorderLayout.CENTER);
			} else if (viewComponent.getClass().getName() == ObjectBrowser.class.getName()) {
				dockModel.addRootDock("root", ((ObjectBrowser) viewComponent).getContentPane(), this);
				contentPane.add(((ObjectBrowser) viewComponent).getContentPane(), BorderLayout.CENTER);
			}
		}

		// Window Listener
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				StatusBar.terminateTimerThread();
				new CloseApplication(app).execute();
			}
		});
		addWindowStateListener(new WindowStateListener() {

			@Override
			public void windowStateChanged(WindowEvent e) {
				app.getApplicationProperty().setState(getExtendedState());
			}
			
		});

		addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent e) {
				if (app.getApplicationProperty().getState() != MAXIMIZED_BOTH)
					app.getApplicationProperty().setDimension(new Dimension(getBounds().width, getBounds().height));
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		setJMenuBar(getMenu());
		setVisible(true);
	}

}