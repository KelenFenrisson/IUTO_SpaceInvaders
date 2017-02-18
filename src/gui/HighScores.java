package gui;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.net.URL;
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
                new KeyFrame(Duration.seconds(1),
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
        Text charttitle = new Text(200, 200,"TOP 10");
        charttitle.setFont(Font.font ("Monospaced", 50));
        topten.getChildren().add(charttitle);
        double interligne = 20;
        for(int i=0;i<10;++i)
        {
            String line = (i+1)+". "+Main.TOP10.getScorelist().get(i);
            topten.getChildren().add(new Text(200, 250+(i*interligne), line));
        }
    }





    //any required method here
}
