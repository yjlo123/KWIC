package events;

import UI.GUI;
import events.listener.Alphabetizer;
import events.listener.CircularShift;
import events.listener.Input;
import events.listener.Output;
import events.model.Lines;

/**
 * Created by siwei on 22/8/15.
 */
public class Controller {

    public static Lines lines = new Lines();
    public static Lines shiftedLines = new Lines();
    public static Lines ignoreWords = new Lines();

    private Input input = new Input();
    private Output output = new Output();
    private CircularShift circularShift =  new CircularShift();
    private Alphabetizer alphabetizer = new Alphabetizer();

    public Controller(){
        init();
    }

    public void init(){
        input.addListener(circularShift);
        circularShift.addListener(alphabetizer);
        alphabetizer.addListener(output);
    }

    public void process(String title, String ignore){
        lines.parse(title);
        ignoreWords.parse(ignore.toLowerCase());
        input.update();
    }

    public void setOutputGUI(GUI gui){
        output.setOutputGUI(gui);
    }

}
