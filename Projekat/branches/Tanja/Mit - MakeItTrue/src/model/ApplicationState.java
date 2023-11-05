/***********************************************************************
 * Module:  ApplicationState.java
 * Author:  Notebook
 * Purpose: Defines the Interface ApplicationState
 ***********************************************************************/

package model;

public interface ApplicationState {
   /** @param context */
   void createProject(ApplicationModel context, String url);
   /** @param context */
   void openProject(ApplicationModel context);
   /** @param context */
   void closeProject(ApplicationModel context);
   /** @param context */
   void deleteProject(ApplicationModel context);
   /** @param context */
   void saveProject(ApplicationModel context);
   /** @param context */
   void saveAsProject(ApplicationModel context);
   /** @param context */
   void renameProject(ApplicationModel context);
}