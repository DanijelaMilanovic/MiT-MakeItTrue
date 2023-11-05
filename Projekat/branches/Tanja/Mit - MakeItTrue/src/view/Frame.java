/***********************************************************************
 * Module:  Frame.java
 * Author:  Korisnik
 * Purpose: Defines the Class Frame
 ***********************************************************************/

package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Iterator;
import model.ApplicationModel;

public class Frame extends Window {
	
	private static final long serialVersionUID = 1L;
	private Container contentPane = null;
	
   @SuppressWarnings("rawtypes")
   public Frame(ApplicationModel app) {
	   super("mainFrame", app);
	   
	   Dimension screenSize;
	   Dimension frameSize;
	   Point location;
	   
	   //Osnovna podšavanja
	   setTitle("MiT - MakeItTrue");
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   setExtendedState(MAXIMIZED_BOTH);
	         
	    //Podesavanja dimenzija i lokacije
	    screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	    frameSize = new Dimension(800,600);
	    setSize(frameSize);
	      
	    location = new Point((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
	    setLocation(location);
	    setMinimumSize(frameSize);
	        
	    //Postavljanje komponenti pogleda
	    contentPane = getContentPane();
	    contentPane.setLayout(new BorderLayout());
	   
	    for (Iterator iterator = getViewComponents().iterator(); iterator.hasNext();) {
			ViewComponents viewComponent = (ViewComponents) iterator.next();
			if(viewComponent.getClass().getName() == ToolBar.class.getName()) {
				contentPane.add(((ToolBar) viewComponent).getToolBar(), BorderLayout.NORTH);
			}
			else if(viewComponent.getClass().getName() == StatusBar.class.getName()) {
				contentPane.add(((StatusBar) viewComponent).getStatusbar(), BorderLayout.SOUTH);
			}
			else if(viewComponent.getClass().getName() == Toolbox.class.getName()) {
				contentPane.add(((Toolbox) viewComponent).getContentPane(), BorderLayout.CENTER);
			}
			else if(viewComponent.getClass().getName() == GraficEditor.class.getName()) {
				contentPane.add(((GraficEditor) viewComponent).getContentPane(), BorderLayout.CENTER);
			}
			else if(viewComponent.getClass().getName() == ObjectBrowser.class.getName()) {
				contentPane.add(((ObjectBrowser) viewComponent).getContentPane(), BorderLayout.CENTER);
			}	
		}

	    setJMenuBar(getMenu());
	    setVisible(true);
	    
   }

}