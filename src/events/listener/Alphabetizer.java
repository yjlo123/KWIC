package events.listener;

import events.Controller;
import events.model.Lines;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by siwei on 22/8/15.
 */
public class Alphabetizer implements Listener {

    private ArrayList<Listener> listeners = new ArrayList<Listener>();

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void update() {
        // sort lines
        Lines lines = Controller.shiftedLines;
        for(int i=1;i<lines.size();i++){

            String key = lines.get(i);

            for(int j= i-1;j>=0;j--){
                if(key.compareToIgnoreCase(lines.get(j)) < 0){
                    // Shifting Each Element to its right as key is less than the existing element at current index
                    lines.set(j+1,lines.get(j));

                    // Special case scenario when all elements are less than key, so placing key value at 0th Position
                    if(j==0){
                        lines.set(0, key);
                    }
                }else{
                    // Putting Key value after element at current index as Key value is no more less than the existing element at current index
                    lines.set(j+1,key);
                    break; // You need to break the loop to save un necessary iteration
                }
            }
        }

        for (Listener l : listeners)
            l.update();
    }
}
