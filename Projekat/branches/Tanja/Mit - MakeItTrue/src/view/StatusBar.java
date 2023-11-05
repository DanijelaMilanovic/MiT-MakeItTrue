/***********************************************************************
 * Module:  StatusBar.java
 * Author:  Notebook
 * Purpose: Defines the Class StatusBar
 ***********************************************************************/

package view;

import javax.swing.JLabel;

import model.ActiveState;
import model.ApplicationModel;
import model.ApplicationState;
import model.EditingState;
import model.IdleState;
import observer.Subject;
import view.statusbar.CustomStatusBar;
import view.statusbar.TimerThread;

public class StatusBar extends ViewComponents {
	
    private CustomStatusBar statusbar;

	public CustomStatusBar getStatusbar() {
		return statusbar;
	}

	public void setStatusbar(CustomStatusBar statusbar) {
		this.statusbar = statusbar;
	}

	public StatusBar() {
		JLabel leftLabel = null;
		JLabel centerLabel = null;
		TimerThread timerThread = null;
		
		this.statusbar = new CustomStatusBar();
		
		leftLabel = new JLabel("<html><b style=\"color:gray\">Vaša aplikacija je uspješno pokrenuta</b></html>");
	    this.statusbar.setLeftComponent(leftLabel);
	    
	    centerLabel = new JLabel("<html><b style=\"color:gray\">Vaša aplikacija je uspješno pokrenuta</b></html>");
	    this.statusbar.setCenterComponent(centerLabel);
	    
	    final JLabel dateLabel = new JLabel();
	    dateLabel.setHorizontalAlignment(JLabel.CENTER);
	    statusbar.addRightComponent(dateLabel);

	    final JLabel timeLabel = new JLabel();
	    timeLabel.setHorizontalAlignment(JLabel.CENTER);
	    statusbar.addRightComponent(timeLabel);
	     
	    timerThread = new TimerThread(dateLabel, timeLabel);
	    timerThread.start();
	     
	}

	@Override
	public void update(Subject subject) {
		String text = "";
		ApplicationState state = ((ApplicationModel)subject).getCurrentState();
		JLabel labela;
		
		if(state.getClass() == IdleState.class) {
			text = "Neaktivno";
		}
		else if(state.getClass() == ActiveState.class) {
			text = "Aktivno";
		}
		else if(state.getClass() == EditingState.class) {
			text = "Uredjivanje";
		}
		
		labela = new JLabel("<html><b style=\"color:gray\">" + text + "</b></html>");
		
		statusbar.setLeftComponent(labela);		
		statusbar.updateUI();
	}

}