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
 * public void handle(MPKEventHandler.MultiKeyEvent ke)
 * public void nouvellePartie()
 *
 * *********************************************************************************************************************
 */

public class Game implements Initializable, ControlledScreen {

    private ScreensController myController;
    private GestionJeu gestionnaire;
    private Timeline timeline;
    private EventHandler KeHandler = this.initKeyEventHandler();
    private String message = "Appuyez sur F2 pour lancer une nouvelle partie";
    public AnchorPane root = new AnchorPane();
    public Group caracteres = new Group();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Initialisation");

        this.root.setOnKeyPressed(KeHandler);
        this.root.setOnKeyReleased(KeHandler);

        Text t = new Text ((Main.LARGEUR_VUE*Main.largeurCaractere/2)-(this.message.length()/2)*Main.largeurCaractere,
                (Main.HAUTEUR_VUE*Main.hauteurTexte/2), "Appuyez sur F2 pour lancer une partie");
        t.setFont(Font.font ("Monospaced", 12));
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

    public void lancerAnimation() {

        System.out.println("Lancer animation");
        // On ajoute le Controleur de Temps
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        actionEvent -> {
                            gestionnaire.jouerUnTour();
                            majAffichage();
                        }),
                new KeyFrame(Duration.seconds(0.025))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    public void arreterAnimation() {
        timeline.stop();
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
                            System.out.println("Pause");
                        }
                    }
                });
        return keyHandler;
    }


    public void nouvellePartie()
    {
        this.gestionnaire=new GestionJeu();
        this.lancerAnimation();
    }

    public void goToSplash(){
        myController.setScreen(Main.SPLASH_SCREEN);
    }


    //any required method here
}
