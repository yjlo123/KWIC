package events.listener;

import UI.GUI;
import events.Controller;

import java.util.ArrayList;

/**
 * Created by siwei on 22/8/15.
 */
public class Output implements Listener {

    private ArrayList<Listener> listeners = new ArrayList<Listener>();
    private GUI gui;

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void update() {
        this.gui.showResult(Controller.shiftedLines.toString());
        for (Listener l : listeners)
            l.update();
    }

    public void setOutputGUI(GUI gui){
        this.gui = gui;
    }
}
