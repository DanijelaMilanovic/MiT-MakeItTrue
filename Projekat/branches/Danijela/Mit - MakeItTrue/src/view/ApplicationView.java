/***********************************************************************
 * Module:  ApplicationView.java
 * Author:  Notebook
 * Purpose: Defines the Class ApplicationView
 ***********************************************************************/

package view;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.ApplicationModel;
import localization.Localization;

public class ApplicationView {
	private Window windowFrame;
	private ApplicationModel appModel;
	private Localization localization = null;

	public Window getWindowFrame() {
		return windowFrame;
	}

	public void setWindowFrame(Window windowFrame) {
		this.windowFrame = windowFrame;
	}

	public ApplicationModel getApplicationModel() {
		return appModel;
	}

	public ApplicationView(ApplicationModel appModel) {
		localization = Localization.getInstance("sr", "BA");

		try {
			com.jtattoo.plaf.aero.AeroLookAndFeel.setTheme("Large-Font", "", "MiT");
			// UIManager.put("Tree.rendererFillBackground", false);
			UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}
		this.appModel = appModel;
		setWindowFrame(new Frame(appModel));

	}
}