/***********************************************************************
 * Module:  ToolBoxActionListener.java
 * Author:  G1
 ***********************************************************************/

package listeners;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.AddingState;
import model.CanvasObject;
import model.DifferentViewObject;
import model.SelectionState;
import model.ToolBoxObject;
import model.elements.Or;
import model.elements.Xor;
import view.Canvas;
import view.Editor;
/**Klasa osluškivaèa dogaðaja koja je vezana za bilo koji dogaðaj koji se desio na paleti elemenata.**/
public class ToolBoxActionListener implements ActionListener {

	Editor editor;
	HashMap<String, AbstractButton> fields = new HashMap<>();
	DifferentViewObject differentViewObject;

	public ToolBoxActionListener(Editor editor) {
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand())
		{
		case "xor":
			editor.getFocusedDiagram().setCurrentState(new AddingState());
			AbstractButton btnXor = (AbstractButton) e.getSource();
			fields.put(e.getActionCommand(), btnXor);

			differentViewObject = new CanvasObject();
			ImageIcon cursor = new ImageIcon("icons/add_insert_plus_1588-removebg-preview.png");
			Image img= cursor.getImage();
			Icon icon = new Xor(8,8,differentViewObject);
			Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(img , new Point(0,0), "cursor1");
			btnXor.setIcon(icon);
		
			
			differentViewObject = new ToolBoxObject();

			for (Canvas canvas2 : editor.getCanvas()) {
				canvas2.setCursor(c);
				canvas2.setClicked(e.getActionCommand());
			}
				
			for (Map.Entry<String, AbstractButton> field : fields.entrySet()) {				
				if(field.getKey() == "line") {
					field.getValue().setIcon(new ImageIcon("icons/LogickaKola/Wire.png"));
				}
				else if(field.getKey() == "or") {
					Icon iconOrToolbox = new Or(8,8,differentViewObject);
					field.getValue().setIcon(iconOrToolbox);
				}
			}
			break;
		case "line":
			try {
			editor.getFocusedDiagram().setCurrentState(new AddingState());
			} catch(Exception e1) {}
			AbstractButton btnLine = (AbstractButton) e.getSource();
			fields.put(e.getActionCommand(), btnLine);
			
			differentViewObject = new ToolBoxObject();
			ImageIcon cursor2 = new ImageIcon("icons/LogickaKola/Wire.png");
			Image img1= cursor2.getImage();
			Cursor c2 = Toolkit.getDefaultToolkit().createCustomCursor(img1 , new Point(0,30), "cursor1");

			for (Canvas canvas2 : editor.getCanvas()) {
				canvas2.setCursor(c2);
				canvas2.setClicked(e.getActionCommand());
			}
						
			for (Map.Entry<String, AbstractButton> field : fields.entrySet()) {
				if(field.getKey() == "xor") {
					Icon icon1 = new Xor(8,8,differentViewObject);
					field.getValue().setIcon(icon1);
				}
				else if(field.getKey() == "or") {
					differentViewObject = new ToolBoxObject();
					Icon iconOrToolbox = new Or(8,8,differentViewObject);
					field.getValue().setIcon(iconOrToolbox);
				}
			}
			break;
		case "select":
			editor.getFocusedDiagram().setCurrentState(new SelectionState());

			AbstractButton btnSelect = (AbstractButton) e.getSource();
			btnSelect.setBorder(BorderFactory.createLineBorder(Color.red, 5));
			
			//fields.put(e.getActionCommand(), btnSelect);

			differentViewObject = new ToolBoxObject();
			
			for (Canvas canvas2 : editor.getCanvas()) {
				canvas2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				canvas2.setClicked(e.getActionCommand());
			}
			
			for (Map.Entry<String, AbstractButton> field : fields.entrySet()) {
				if(field.getKey() == "xor") {
					Icon icon1 = new Xor(8,8,differentViewObject);
					field.getValue().setIcon(icon1);
				}
				else if(field.getKey() == "line") {
					field.getValue().setIcon(new ImageIcon("icons/LogickaKola/Wire.png"));
				}
				else if(field.getKey() == "or") {
					differentViewObject = new ToolBoxObject();
					Icon iconOrToolbox = new Or(8,8,differentViewObject);
					field.getValue().setIcon(iconOrToolbox);
				}
			}
			break;
			
		case "or":
			editor.getFocusedDiagram().setCurrentState(new AddingState());
			
			AbstractButton btnOr = (AbstractButton) e.getSource();
			fields.put(e.getActionCommand(), btnOr);

			differentViewObject = new CanvasObject();
			ImageIcon imgCursorAdd = new ImageIcon("icons/add_insert_plus_1588-removebg-preview.png");
			Image imgOr= imgCursorAdd.getImage();
			Icon iconOr = new Or(8,8,differentViewObject);
			Cursor cursorAdd = Toolkit.getDefaultToolkit().createCustomCursor(imgOr , new Point(0,0), "cursor1");
			btnOr.setIcon(iconOr);
		
			differentViewObject = new ToolBoxObject();

			for (Canvas canvas2 : editor.getCanvas()) {
				canvas2.setCursor(cursorAdd);
				canvas2.setClicked(e.getActionCommand());
			}
				
			for (Map.Entry<String, AbstractButton> field : fields.entrySet()) {				
				if(field.getKey() == "line") {
					field.getValue().setIcon(new ImageIcon("icons/LogickaKola/Wire.png"));
				}
				else if(field.getKey() == "xor") {
					Icon icon1 = new Xor(8,8,differentViewObject);
					field.getValue().setIcon(icon1);
				}
			}
			break;
	}

  }
}
