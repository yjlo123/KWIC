package events.listener;

import events.Controller;

import java.util.ArrayList;

/**
 * Created by siwei on 22/8/15.
 */
public class CircularShift implements Listener {

    private ArrayList<Listener> listeners = new ArrayList<Listener>();

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void update() {
        Controller.shiftedLines.clear();
        // shift for each line
        for(int i = 0; i < Controller.lines.size(); i++){
            String[] words = Controller.lines.get(i).split(" +");
            // shift start from each word in the line
            for (int j = 0; j < words.length; j++){
                // if not start with a ignore word
                if (!Controller.ignoreWords.contains(words[j].toLowerCase())){
                    Controller.shiftedLines.add(shift(words, j));
                }
            }
        }

        // send event to listeners
        for (Listener l : listeners)
            l.update();
    }

    private String shift(String[] arr, int n){
        int length = arr.length;
        String result = "";
        for(int i = 0; i < length; i++){
            String currentWord = arr[(i+n)%length].trim();
            result += (changeCase(currentWord)+" ");
        }
        return result.trim();
    }

    // ignore words in lower case, keyword in upper case
    private String changeCase(String str){
        if (Controller.ignoreWords.contains(str.toLowerCase())){
            return str.toLowerCase();
        }else{
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }
}
