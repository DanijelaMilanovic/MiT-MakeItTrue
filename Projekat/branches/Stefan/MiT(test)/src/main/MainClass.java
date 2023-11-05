/***********************************************************************
 * Module:  MainClass.java
 * Author:  Notebook
 * Purpose: Defines the Class MainClass
 ***********************************************************************/

package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Application;

public class MainClass {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Application();
	}
}