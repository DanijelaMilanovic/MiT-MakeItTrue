/***********************************************************************
 * Module:  Application.java
 * Author:  G1
 ***********************************************************************/

package model;

import view.ApplicationView;
import view.ViewComponents;
/**Osnovna klasa aplikacije Mit-MakeItTrue. **/
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
	   applicationModel.attach(applicationView.getWindowFrame().getMenu());
	   
	   //Obavjestenje pretplatnika(Pocetno stanje)
	   applicationModel.notifyObservers();
   }
}