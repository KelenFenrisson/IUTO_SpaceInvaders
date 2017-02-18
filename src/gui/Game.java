package gui;

import game.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;



/** CLASSE Game
 *
 * Contrôleur de toute la partie jeu de l'application
 *  * SOURCE :
 * Issue d'un article de Angela Caicedo:
 * (https://blogs.oracle.com/acaicedo/entry/managing_multiple_screens_in_javafx1)
 ***********************************************************************************************************************
 *
 * ATTRIBUTS
 *
 * private ScreensController myController;
 * private GestionJeu gestionnaire;
 * private Timeline timeline;
 * private EventHandler KeHandler = this.initKeyEventHandler();
 * private String message = "Appuyez sur F2 pour lancer une nouvelle partie";
 * public AnchorPane root = new AnchorPane();
 * public Group caracteres = new Group();
 * *********************************************************************************************************************
 *
 * METHODES
 *
 * public void initialize(URL url, ResourceBundle resourceBundle)
 * public void majAffichage()
 * public void lancerAnimation()
 * public void arreterAnimation()
 * public void setScreenParent(ScreensController screenParent)
 * public MPKEventHandler initKeyEventHandler()
 * public void nouvellePartie()
 * public void checkGameOver()
 *
 * *********************************************************************************************************************
 */

public class Game implements Initializable, ControlledScreen {

    // Gestionnaire multi ecrans
    private ScreensController myController;

    // Controleur de jeu
    private GestionJeu gestionnaire;

    // Contrôleur de temps
    private Timeline timeline;

    // Controleur de Clavier
    private EventHandler KeHandler = this.initKeyEventHandler();

    // Message initial
    private String message = "Appuyez sur F2 pour lancer une nouvelle partie";

    // Vue
    public AnchorPane root = new AnchorPane();

    // Caracteres du jeu
    public Group caracteres = new Group();

    // Statut des animations
    public boolean paused = false;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Initialisation");

        // Receptionnaire Clavier
        this.root.setOnKeyPressed(KeHandler);
        this.root.setOnKeyReleased(KeHandler);

        Text title = new Text(50, 100, "SPACE INVADERS");
        title.setFont(Font.font("Monospaced", FontWeight.BOLD,60));
        Text t = new Text (135,300, this.message);
        t.setFont(Font.font ("Monospaced", 12));
        caracteres.getChildren().add(title);
        caracteres.getChildren().add(t);

    }

    public void majAffichage(){
//        System.out.println("Maj Affichage");

        caracteres.getChildren().clear();
        int hauteur = Main.HAUTEUR_VUE * Main.hauteurTexte; // Pas adaptable mais ça marche

        for( ChainePositionnee cp : gestionnaire.getDessin().getChaines())
        {
            Text t = new Text (cp.getx()*Main.largeurCaractere,hauteur-cp.gety()*Main.hauteurTexte, cp.getChaine());

            t.setFont(Font.font ("Monospaced", 10));
            caracteres.getChildren().add(t);
        }

    }

    public void nouvellePartie()
    {
        this.gestionnaire=new GestionJeu();
        this.lancerAnimation();

    }

    public void checkGameOver(){

        if(this.gestionnaire.isGameOver())
        {
            // On arrete le jeu
            this.arreterAnimation();
        }
    }



    public void lancerAnimation() {

        System.out.println("Lancer animation");
        // On ajoute le Controleur de Temps
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        actionEvent -> {
                            gestionnaire.jouerUnTour();
                            majAffichage();
                            checkGameOver();
                        }),
                new KeyFrame(Duration.seconds(0.025))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }


    public void arreterAnimation() {

        timeline.stop();
        Main.TOP10.addScore(this.gestionnaire.getScore().getPoints());
        this.goToHighScores();
    }


    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    public MPKEventHandler initKeyEventHandler() {
        final MPKEventHandler keyHandler =
                new MPKEventHandler(new MPKEventHandler.MultiKeyEventHandler() {

                    public void handle(MPKEventHandler.MultiKeyEvent ke) {

                        if (ke.isPressed(KeyCode.F2)){
                            nouvellePartie();
                        }
                        if (ke.isPressed(KeyCode.LEFT) || ke.isPressed(KeyCode.Q)) {
                            gestionnaire.toucheGauche();
                        }
                        if (ke.isPressed(KeyCode.RIGHT) || ke.isPressed(KeyCode.D)) {
                            gestionnaire.toucheDroite();
                        }

                        if (ke.isPressed(KeyCode.UP) || ke.isPressed(KeyCode.SPACE)) {
                            gestionnaire.toucheEspace();
                        }
                        if (ke.isPressed(KeyCode.P)) {
                            if (paused){timeline.play();}
                            else{timeline.pause();}
                            paused = !paused;
                        }
                        if (ke.isPressed(KeyCode.X)) {
                            gestionnaire.setGameOver(true);
                        }
                    }
                });
        return keyHandler;
    }


    public void goToHighScores(){
        myController.setScreen(Main.HIGHSCORES_SCREEN);
    }


    //any required method here
}
