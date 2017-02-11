package gui;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

/** Classe SplashScreenController, implemente ControlledScreens
 *
 * Contient les contrôles (du modele MVC) de l'ecran splash
 *
 *
 *
 * SOURCE :
 * Issue d'un article de Angela Caicedo:
 * (https://blogs.oracle.com/acaicedo/entry/managing_multiple_screens_in_javafx1)
 */
public class SplashScreenController implements Initializable,
        ControlledScreen {

    ScreensController myController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    //any required method here
}
