package gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/** CLASSE Main
 *
 ***********************************************************************************************************************
 *
 * ATTRIBUTS
 *
 * public static final int HAUTEUR_VUE = 60;
 * public static final int LARGEUR_VUE = 100;
 * public static int largeurCaractere;
 * public static int hauteurTexte;
 * public static final String SPLASH_SCREEN = "Splash";
 * public static final String SPLASH_SCREEN_FXML = "Splash.fxml";
 * public static final String GAME_SCREEN = "Game";
 * public static final String GAME_SCREEN_FXML = "Game.fxml";
 * *********************************************************************************************************************
 *
 * METHODES
 *
 * public void init()
 * public void start(Stage primaryStage)
 * public static void main(String[] args)
 * *********************************************************************************************************************
 */

public class Main extends Application {

    public static final int HAUTEUR_VUE = 60;
    public static final int LARGEUR_VUE = 100;
    public static int largeurCaractere;
    public static int hauteurTexte;

    public static final String SPLASH_SCREEN = "Splash";
    public static final String SPLASH_SCREEN_FXML = "Splash.fxml";
    public static final String GAME_SCREEN = "Game";
    public static final String GAME_SCREEN_FXML = "Game.fxml";


    @Override
    public void init(){
        // Un truc malin pour recuperer la taille en pixels d'un caractere ?
        Text t=new Text("█");
        t.setFont(Font.font("Monospaced",10));
        Main.hauteurTexte =(int) t.getLayoutBounds().getHeight();
        Main.largeurCaractere = (int) t.getLayoutBounds().getWidth();
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



        Scene scene = new Scene(root,LARGEUR_VUE*largeurCaractere,HAUTEUR_VUE*hauteurTexte);
        // System.out.println("Dimensions : "+scene.getWidth()+"x"+scene.getHeight()); (c'etait pour avoir les dimensions pour mon image ;) )
        // On regle la scène dans la fenetre a la vue en cours
        primaryStage.setScene(scene);

        // Vu qu'on est dépendants de la taille de la police, on interdit le resize.
        primaryStage.setResizable(false);
        //On montre
        primaryStage.show();
    }

        public static void main(String[] args) {
        launch(args);
    }
}
