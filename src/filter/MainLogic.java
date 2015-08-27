package filter;

import UI.GUI;

/**
 * Created by haojiang on 23/8/15.
 */
public class MainLogic {

    private String titles,ignoredWords;
    private Pipes pipe;
    private inputFilter inputfilter;
    private shiftFilter shiftfilter;
    private alphabetizerFilter alphafilter;
    private outputFilter outputfilter;
    public MainLogic(){
        init();
    }

    private void init(){
        pipe = new Pipes();
        inputfilter = new inputFilter();
        shiftfilter = new shiftFilter();
        alphafilter = new alphabetizerFilter();
        outputfilter = new outputFilter();
        setChain();
    }

    private void setChain(){
        pipe.add(inputfilter);
        pipe.add(shiftfilter);
        pipe.add(alphafilter);
        pipe.add(outputfilter);
    }

    public void process(String title, String ignore){
        pipe.getHead().init(title, ignore);
    }

    public void setOutputGUI(GUI gui){
        outputfilter.setOutputGUI(gui);
    }
}
