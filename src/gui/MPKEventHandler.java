package gui;

/** CLASSE MPKEventHandler
 *
 * Un receptionnaire d'evenement clavier qui gère presque bien l'appui sur plusieurs touches.
 *
 * * SOURCE :
 *  d'après un article de Jiri Prajzner
 * http://www.brainoverload.nl/java/167/keypressedeventhandler-with-java-fx-2-0-and-multiple-keys
 ***********************************************************************************************************************
 *
 * ATTRIBUTS
 *
 * private final Set<KeyCode> buffer = EnumSet.noneOf(KeyCode.class);
 * private final MultiKeyEvent multiKeyEvent = new MultiKeyEvent();
 * private final MultiKeyEventHandler multiKeyEventHandler;
 * *********************************************************************************************************************
 *
 * METHODES
 *
 * public MPKEventHandler(final MultiKeyEventHandler handler)
 * public interface MultiKeyEventHandler
 * public class MultiKeyEvent
 * *********************************************************************************************************************
 */

import java.util.EnumSet;
import java.util.Set;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class MPKEventHandler implements EventHandler<KeyEvent> {

    private final Set<KeyCode> buffer = EnumSet.noneOf(KeyCode.class);
    private final MultiKeyEvent multiKeyEvent = new MultiKeyEvent();

    private final MultiKeyEventHandler multiKeyEventHandler;

    public MPKEventHandler(final MultiKeyEventHandler handler) {
        this.multiKeyEventHandler = handler;
    }


    public void handle(final KeyEvent event) {
        final KeyCode code = event.getCode();

        if (KeyEvent.KEY_PRESSED.equals(event.getEventType())) {
            buffer.add(code);
            multiKeyEventHandler.handle(multiKeyEvent);
        } else if (KeyEvent.KEY_RELEASED.equals(event.getEventType())) {
            buffer.remove(code);
        }
        event.consume();
    }

    public interface MultiKeyEventHandler {
        void handle(final MultiKeyEvent event);
    }

    public class MultiKeyEvent {
        public boolean isPressed(final KeyCode key) {
            return buffer.contains(key);
        }
    }
}