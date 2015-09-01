package events.listener;

import events.Controller;

import java.util.ArrayList;

import static UI.GUI.getText;
import static UI.GUI.showResult;

/**
 * Created by siwei on 22/8/15.
 */
public class Input implements Listener {

    private ArrayList<Listener> listeners = new ArrayList<Listener>();

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void update() {
        // get text from UI
        ArrayList<String> input = getText();
        // parser string
        Controller.lines.parse(input.get(0));
        Controller.ignoreWords.parse(input.get(1).toLowerCase());

        for (Listener l : listeners)
            l.update();
    }
}
