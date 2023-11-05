/***********************************************************************
 * Module:  ApplicationView.java
 * Author:  G1
 ***********************************************************************/

package view;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.ApplicationModel;
/** Klasa koja definiše i postavlja komponente koje vidi korisnk**/
public class ApplicationView {
	/**Prozor koji se vidi**/
	private Window windowFrame;
	/**Aplikacioni model **/
	private ApplicationModel appModel;

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