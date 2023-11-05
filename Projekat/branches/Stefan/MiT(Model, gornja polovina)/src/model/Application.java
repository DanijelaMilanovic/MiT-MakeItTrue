/***********************************************************************
 * Module:  Application.java
 * Author:  Notebook
 * Purpose: Defines the Class Application
 ***********************************************************************/

package model;

import view.MainFrame;

public class Application {
   
   public Application() {
	   ApplicationModel app = new ApplicationModel();
	   MainFrame view = new MainFrame(app);
	   app.addObserver(view);
	   app.notifyObservers();
   }

}