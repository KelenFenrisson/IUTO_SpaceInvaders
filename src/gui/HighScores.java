package gui;

import game.HighScore;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/** CLASSE HighScores
 *
 * Contrôleur de l'ecran des HighScores
 *
 * - SOURCES :
 * - - Issue d'un article de Angela Caicedo:
 * - - - (https://blogs.oracle.com/acaicedo/entry/managing_multiple_screens_in_javafx1)
 * - - Issue d'une question StackOverFlow :
 * - - - http://stackoverflow.com/questions/19052508/update-fxml-screen
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
 * public void initialize(URL url, ResourceBundle resourceBundle)
 * public void setScreenParent(ScreensController screenParent)
 * public void goToGame()
 * public void initialize(URL url, ResourceBundle resourceBundle)
 *
 * *********************************************************************************************************************
 */
public class HighScores implements Initializable, ControlledScreen {

    private ScreensController myController;
    public AnchorPane root = new AnchorPane();
    public Group topten;


    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    public void goToGame(){
        myController.setScreen(Main.GAME_SCREEN);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        System.out.println("HighScores init was initialized.");
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2),
                        actionEvent -> {
                            // Call update method for every 1 sec.
                            update();
                        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void update()
    {
        topten.getChildren().clear();
        double interligne = 20;
        for(int i=0;i<Main.TOP10.getScorelist().size();++i)
        {
            String line = (i+1)+". "+Main.TOP10.getScorelist().get(i);
            topten.getChildren().add(new Text(100, 100+(i*interligne), line));
        }
    }





    //any required method here
}
