package events.listener;

import java.util.ArrayList;

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


        for (Listener l : listeners)
            l.update();
    }
}
