/***********************************************************************
 * Module:  ApplicationState.java
 * Author:  G1
 ***********************************************************************/

package model;
/**Interfejs za definisanje metoda koje se ponašajau razlièito u odnosu na stanje u kom se nalazi aplikacija.**/
public interface ApplicationState {
   /**Metoda za kreiranje projekta na odabranom mjestu na raèunaru.
    *  @param context - Objekat nad kojim se izvršava metoda.
    *  @param url – Putanja da odabranog mjesta na raèunaru. */
   void createProject(ApplicationModel context, String url);
   /**Metoda za otvaranje postojeæeg projekta.
    *  @param context - Objekat nad kojim se izvršava metoda.
    *  @param url – Putanja da odabranog mjesta na raèunaru. */
   void openProject(ApplicationModel context, String url);
   /**Metoda za zatvaranje izabranog projekta projekta.
    *  @param context - Objekat nad kojim se izvršava metoda. */
   void closeProject(ApplicationModel context);
   /**Metoda za brisanje izabranog projekta.
    *  @param context - Objekat nad kojim se izvršava metoda.*/
   void deleteProject(ApplicationModel context);
   /**Metoda za èuvanje izabranog projekta.
    *  @param context  - Objekat nad kojim se izvršava metoda. 
 * @param project - Projekat koji se èuva. */
   void saveProject(ApplicationModel context, Project project);
   /** Metoda za èuvanje izmjena izabranog projekta projekta 
    * @param context - Objekat nad kojim se izvršava metoda.*/
   void saveAsProject(ApplicationModel context);
   /** Metoda za preimenovanje izabranog projekta 
    *  @param context - Objekat nad kojim se izvršava metoda.*/
   void renameProject(ApplicationModel context);
}