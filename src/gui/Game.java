package gui;

import game.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

/** Classe Game : controleur de la vue Game.fxml
 * @implements ControlledScreens
 *
 *
 *
 *
 * SOURCE :
 * Issue d'un article de Angela Caicedo:
 * (https://blogs.oracle.com/acaicedo/entry/managing_multiple_screens_in_javafx1)
 */
public class Game implements Initializable, ControlledScreen {

    private ScreensController myController;
    private GestionJeu gestionnaire;
    private Timeline timeline;

    private String message = "Appuyez sur F2 pour lancer une nouvelle partie";
    public AnchorPane root = new AnchorPane();

    public Group caracteres = new Group();




    @Override
    public void initialize() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Initialisation");

        System.out.println("Coords : "+Main.largeurCaractere+" "+Main.hauteurTexte);
        Text t = new Text ((Main.LARGEUR_VUE*Main.largeurCaractere/2)-(this.message.length()/2)*Main.largeurCaractere, (Main.HAUTEUR_VUE*Main.hauteurTexte/2), "Appuyez sur F2 pour lancer une partie");
        t.setFont(Font.font ("Monospaced", 10));
        caracteres.getChildren().add(t);

    }




    public void majAffichage(){
//        System.out.println("Maj Affichage");
        caracteres.getChildren().clear();
        int hauteur = (int) root.getHeight();

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


    void arreterAnimation() {
        timeline.stop();
    }

    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }


    public void handleKey(KeyEvent ke)
    {
        System.out.println("On a appuyé sur une touche");
        ke.consume();
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
