/***********************************************************************
 * Module:  ContextMenu.java
 * Author:  Notebook
 * Purpose: Defines the Class ContextMenu
 ***********************************************************************/

package view;

import javax.swing.JPopupMenu;

import view.contextmenu.CanvasContextMenu;
import view.contextmenu.ObjectBrowserContextMenu;
import view.contextmenu.ToolboxContextMenu;

public class ContextMenu {

	private JPopupMenu contextMenu = null;

	public JPopupMenu getContextMenu() {
		return contextMenu;
	}

	public void setContextMenu(JPopupMenu contextMenu) {
		this.contextMenu = contextMenu;
	}

	public ContextMenu(String type) {
		switch (type) {
		case "Canvas":
			contextMenu = new CanvasContextMenu();
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