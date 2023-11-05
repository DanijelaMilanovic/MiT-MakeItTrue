/***********************************************************************
 * Module:  ContextMenu.java
 * Author:  G1
 ***********************************************************************/

package view;

import javax.swing.JPopupMenu;

import model.ApplicationModel;
import view.contextmenu.CanvasContextMenu;
import view.contextmenu.ObjectBrowserContextMenu;
import view.contextmenu.ToolboxContextMenu;
/**Klasa koja definiše osnovne elemente konteksnog menija**/
public class ContextMenu {

	/**Konteksni meni koji se postavlja**/
	private JPopupMenu contextMenu = null;

	public JPopupMenu getContextMenu() {
		return contextMenu;
	}

	public void setContextMenu(JPopupMenu contextMenu) {
		this.contextMenu = contextMenu;
	}

	public ContextMenu(String type,ApplicationModel model) {
		switch (type) {
		case "Canvas":
			contextMenu = new CanvasContextMenu(model);
			break;
		case "Toolbox":
			contextMenu = new ToolboxContextMenu();
			break;
		case "Object Browser":
			contextMenu = new ObjectBrowserContextMenu();
			break;
		}
	}
}