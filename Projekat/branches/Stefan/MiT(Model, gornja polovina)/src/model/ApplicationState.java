/***********************************************************************
 * Module:  ApplicationState.java
 * Author:  Notebook
 * Purpose: Defines the Interface ApplicationState
 ***********************************************************************/

package model;

import java.util.*;

public interface ApplicationState {
   /** @param context */
   void createProject(ApplicationModel context);
   /** @param context */
   void openProject(ApplicationModel context);
   /** @param context */
   void closeProject(ApplicationModel context);
   /** @param context */
   void deleteProject(ApplicationModel context);

}