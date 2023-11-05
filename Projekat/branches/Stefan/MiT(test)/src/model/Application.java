/***********************************************************************
 * Module:  Application.java
 * Author:  Notebook
 * Purpose: Defines the Class Application
 ***********************************************************************/

package model;

import view.MainFrame;

public class Application {
   
	ApplicationModel appModel;
	MainFrame appView;
	
   public Application() {
	  this.appModel = new ApplicationModel();
	  this.appView = new MainFrame(appModel);
   }

}