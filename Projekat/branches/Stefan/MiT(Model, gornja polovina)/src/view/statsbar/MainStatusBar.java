package view.statsbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ApplicationModel;
import model.ApplicationState;
import model.EditingState;
import model.IdleState;
import obeserver.IObserver;
import obeserver.ISubject;

public class MainStatusBar extends JPanel implements IObserver
{
	private static final long serialVersionUID = 1L;

	JLabel textLeft = null;
	JLabel textRight = null;
	JLabel textCenter = null;
	
	public MainStatusBar()
	{
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		setPreferredSize(new Dimension(0, 20));
		
		textLeft = new JLabel();
		textLeft.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5)); 
		textLeft.setHorizontalAlignment(JLabel.LEFT);
		textLeft.setPreferredSize(new Dimension(100, 0));
		add(textLeft, BorderLayout.WEST);
		
		textRight = new JLabel();
		textRight.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5)); 
		textRight.setHorizontalAlignment(JLabel.RIGHT);
		textRight.setPreferredSize(new Dimension(100, 0));
		add(textRight, BorderLayout.EAST);
		
		textCenter = new JLabel();
		textCenter.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 1, 0, 1, Color.GRAY), 
				BorderFactory.createEmptyBorder(0, 5, 0, 5))); 
		textCenter.setHorizontalAlignment(JLabel.CENTER);
		add(textCenter, BorderLayout.CENTER);
	}

	
	public void setLeftText(String text)
	{
		this.textLeft.setText(text);
	}
	
	public void setRightText(String text)
	{
		this.textRight.setText(text);
	}
	
	public void setCenterText(String text)
	{
		this.textCenter.setText(text);
	}
	
	public void setLeftText(String text, Color boja)
	{
		this.textLeft.setText(text);
		this.textLeft.setForeground(boja);
	}
	
	public void setRightText(String text, Color boja)
	{
		this.textRight.setText(text);
		this.textRight.setForeground(boja);
	}
	
	public void setCenterText(String text, Color boja)
	{
		this.textCenter.setText(text);
		this.textCenter.setForeground(boja);
	}
	
	@Override
	public void update(ISubject subject) {
		String text = "";
		ApplicationState state = ((ApplicationModel)subject).getCurrentState();
		if(state.getClass() == IdleState.class) {
			text = "Idle";
		}
		else if(state.getClass() == EditingState.class) {
			text = "Edit";
		}
		
		this.setLeftText(text);
	}

}
