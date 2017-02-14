package gui;

/** INTERFACE ControlledScreens
 *
 * SOURCE :
 * Issue d'un article de Angela Caicedo:
 * (https://blogs.oracle.com/acaicedo/entry/managing_multiple_screens_in_javafx1)
 *
 ***********************************************************************************************************************
 * NECESSITE
 *
 * void initialize();
 * void setScreenParent(ScreensController screenPage);
 * *********************************************************************************************************************
 */

public interface ControlledScreen
{

    void initialize();
    void setScreenParent(ScreensController screenPage);

}