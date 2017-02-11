package gui;

/** Interface ControlledScreen
 *
 *
 * Requiert l'implementation d'une methode d'injection de parent
 *
 *
 * SOURCE :
 * Issue d'un article de Angela Caicedo:
 * (https://blogs.oracle.com/acaicedo/entry/managing_multiple_screens_in_javafx1)
 */

public interface ControlledScreen
{

    //This method will allow the injection of the Parent ScreenPane
    public void setScreenParent(ScreensController screenPage);

}