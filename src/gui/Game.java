package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

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
public class Game implements Initializable, ControlledScreen {

    public Image image;
    ScreensController myController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initialize() {

    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void goToSplash(){
        myController.setScreen(Main.SPLASH_SCREEN);
    }


    //any required method here
}
