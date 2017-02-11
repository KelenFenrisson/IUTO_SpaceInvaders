package gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import game.GestionJeu;

public class Main extends Application {



    public static final String SPLASH_SCREEN = "splash";
    public static final String SPLASH_SCREEN_FXML = "splash.fxml";

    public static final String GAME_SCREEN = "game";
    public static final String GAME_SCREEN_FXML = "game.fxml";

    @Override
    public void init(){
        GestionJeu gestionnaire = new GestionJeu();
    }


    @Override
    public void start(Stage primaryStage) {

        // On instancie une nouvelle "Pile" de vues
        ScreensController mainContainer = new ScreensController();
        // On la charge
        mainContainer.loadScreen(Main.SPLASH_SCREEN, Main.SPLASH_SCREEN_FXML);
        mainContainer.loadScreen(Main.GAME_SCREEN, Main.GAME_SCREEN_FXML);

        // On definit la vue en cours
        mainContainer.setScreen(Main.SPLASH_SCREEN);

        // On instancie un nouveau groupe
        Group root = new Group();
        // On ajoute toutes les vues de la pile de vues dans les enfants du groupe
        root.getChildren().addAll(mainContainer);

        // La nouvelle scène devient le groupe et par extension la vue en cours.
        Scene scene = new Scene(root);

        // On regle la scène dans la fenetre a la vue en cours
        primaryStage.setScene(scene);

        //On montre
        primaryStage.show();
    }


        public static void main(String[] args) {
        launch(args);
    }
}
