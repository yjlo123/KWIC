package filter;

import UI.GUI;

/**
 * Created by haojiang on 23/8/15.
 */
public class MainLogic {
    static GUI gui;

    private String titles="The Day after Tomorrow,Fast and Furious,Man of Steel",ignoredWords="is, the, of, and, as, a, after";
    private FilterChain chain;
    private inputFilter inputfilter;
    private shiftFilter shiftfilter;
    private alphabetizerFilter alphafilter;
    private outputFilter outputfilter;
    public MainLogic(){}
    private void init(){
        chain = new FilterChain();
        inputfilter = new inputFilter();
        shiftfilter = new shiftFilter();
        alphafilter = new alphabetizerFilter();
        outputfilter = new outputFilter();
        inputfilter.SetNext(shiftfilter);
        shiftfilter.SetNext(alphafilter);
        alphafilter.SetNext(outputfilter);
        setChain();
    }
    private void setChain(){
        chain.add(inputfilter);
        chain.add(shiftfilter);
        chain.add(alphafilter);
        chain.add(outputfilter);
        chain.setHead(inputfilter);
        chain.setTail(outputfilter);

    }
    public void run(){
        init();
        chain.run(titles,ignoredWords);
    }
}
