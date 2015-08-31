package events.listener;

import events.Controller;
import java.util.ArrayList;
import static UI.GUI.showResult;

/**
 * Created by siwei on 22/8/15.
 */
public class Output implements Listener {

    private ArrayList<Listener> listeners = new ArrayList<Listener>();

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void update() {
        showResult(Controller.shiftedLines.toString());
        for (Listener l : listeners)
            l.update();
    }

}
