/***********************************************************************
 * Module:  Application.java
 * Author:  Notebook
 * Purpose: Defines the Class Application
 ***********************************************************************/

package model;

import view.ApplicationView;
import view.ViewComponents;

public class Application {
   private ApplicationModel applicationModel;
   private ApplicationView applicationView;
   
   public ApplicationModel getApplicationModel() {
      return applicationModel;
   }
   
   /** @param newApplicationModel */
   public void setApplicationModel(ApplicationModel newApplicationModel) {
      applicationModel = newApplicationModel;
   }
   
   public Application() {
	   this.applicationModel = new ApplicationModel();
	   this.applicationView = new ApplicationView(applicationModel);
	   
	   //Pretplacivanje observera na application model
	   for(ViewComponents viewComponent : applicationView.getWindowFrame().getViewComponents()) {
		   applicationModel.attach(viewComponent);
	   }
	   
	   //Obavjestenje pretplatnika(Pocetno stanje)
	   applicationModel.notifyObservers();
   }
}