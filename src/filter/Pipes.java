package filter;

import java.util.ArrayList;

/**
 * Created by haojiang on 27/8/15.
 */
public class Pipes {

    //Attributes
    public static ArrayList<Filter> chain;
    private ArrayList<String> parsingPara;
    //Methods
    public Pipes(){
        chain = new ArrayList<Filter>();
    }
    public static void callNext(Filter currentFilter, ArrayList<String> parsingData){
        //System.out.println(this.chain.size());
        int nextFilterIndex;
        nextFilterIndex = chain.indexOf(currentFilter)+1;
        //System.out.println(nextFilterIndex);
        chain.get(nextFilterIndex).run(parsingData);
    }
    public void add(Filter filter) {
       // System.out.println("Here!");
        chain.add(filter);

    }
    public Filter getHead(){
        return chain.get(0);
    }
    public void run(String titles, String ignoredWords){
        parsingPara = new ArrayList<String>();
        parsingPara.add(titles);
        parsingPara.add(ignoredWords);
        this.getHead().run(parsingPara);
    }
}
