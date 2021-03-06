package gui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.HashMap;

/** CLASSE ScreensController
 *
 * Un chargeur de panels plus efficace que de precharger X panel et de les laisser tourner en fond
 *
 * * SOURCE :
 * Issue d'un article de Angela Caicedo:
 * (https://blogs.oracle.com/acaicedo/entry/managing_multiple_screens_in_javafx1)
 ***********************************************************************************************************************
 *
 * ATTRIBUTS
 *
 * private HashMap<String, Node> screens = new HashMap<>();
 * *********************************************************************************************************************
 *
 * METHODES
 * public void addScreen(String name, Node screen)
 * public boolean loadScreen(String name, String resource)
 * public boolean setScreen(final String name)
 * public boolean unloadScreen(String name)
 *
 * *********************************************************************************************************************
 */

public class ScreensController extends StackPane {

    private HashMap<String, Node> screens = new HashMap<>();

    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }

    public boolean loadScreen(String name, String resource) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            ControlledScreen myScreenController = myLoader.getController();
            myScreenController.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
                System.out.println("Probleme de chargement du controleur : " + e.getMessage());
            return false;
        }
    }

    public boolean setScreen(final String name) {

        if (screens.get(name) != null) { //screen loaded
            final DoubleProperty opacity = opacityProperty();

            //Is there is more than one screen
            if (!getChildren().isEmpty()) {
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO,
                                new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(1000),

                                t -> {
                                    //remove displayed screen
                                    getChildren().remove(0);
                                    //add new screen
                                    getChildren().add(0, screens.get(name));
                                    Timeline fadeIn = new Timeline(
                                            new KeyFrame(Duration.ZERO,
                                                    new KeyValue(opacity, 0.0)),
                                            new KeyFrame(new Duration(800),
                                                    new KeyValue(opacity, 1.0)));
                                    fadeIn.play();
                                }, new KeyValue(opacity, 0.0)));
                fade.play();
            } else {
                //no one else been displayed, then just show
                setOpacity(0.0);
                getChildren().add(screens.get(name));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO,
                                new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(2500),
                                new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {
            System.out.println("screen hasn't been loaded!\n");
            return false;
        }
    }


    public boolean unloadScreen(String name) {
        if(screens.remove(name) == null) {
            System.out.println("Screen didn't exist");
            return false;
        } else {
            return true;
        }
    }


}