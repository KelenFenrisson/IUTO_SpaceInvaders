package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

/** CLASSE Splash
 *
 * Contrôleur du SplashScreen 
 * * SOURCE :
 * Issue d'un article de Angela Caicedo:
 * (https://blogs.oracle.com/acaicedo/entry/managing_multiple_screens_in_javafx1)
 ***********************************************************************************************************************
 *
 * ATTRIBUTS
 *
 * public Image image;
 * private ScreensController myController;
 * *********************************************************************************************************************
 *
 * METHODES
 *
 * public void initialize()
 * public void initialize(URL url, ResourceBundle resourceBundle)
 * public void setScreenParent(ScreensController screenParent)
 * public void goToGame()
 * public void initialize(URL url, ResourceBundle resourceBundle)
 * public void playGrowl()
 *
 * *********************************************************************************************************************
 */
public class Splash implements Initializable, ControlledScreen {

    public Image image;
    private ScreensController myController;


    @Override
    public void initialize() {

        image = new Image("src/gui/growler.png");

    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    public void goToGame(){
        this.playGrowl();
        myController.setScreen(Main.GAME_SCREEN);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void playGrowl()
    {
        AudioClip growl = new AudioClip(Paths.get("src/sfx/growl.wav").toUri().toString());
        growl.play();
    }


    //any required method here
}
