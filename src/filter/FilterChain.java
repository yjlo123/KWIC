package filter;
import filter.*;
import java.util.ArrayList;

/**
 * Created by haojiang on 20/8/15.
 */
public class FilterChain {

    //Attributes
    private ArrayList<Filter> chain;
    private Filter Head = null;
    private Filter Tail = null;
    private static String inputTitles="";
    private static String inputIgnoredWords="";
    private static String outputTitles="";

    //Methods
    public FilterChain(){
        chain = new ArrayList<Filter>();
    }
    public void add(Filter filter){
        chain.add(filter);
    }
    public void setHead(Filter head){
        this.Head = head;
    }
    public void setTail(Filter tail){
        this.Tail = tail;
    }
    public Filter getHead(){
        return Head;
    }
    public Filter getTail(){
        return Tail;
    }
    public void run(String titles, String ignoredWords){
        this.inputTitles = titles;
        this.inputIgnoredWords = ignoredWords;
        this.getHead().run();
    }
    public static String getInputTitles(){
        return inputTitles;
    }
    public static String getInputIgnoredWords(){
        return inputIgnoredWords;
    }
    public static void setOutputTitles(String output){
        outputTitles = output;
    }
    public static String getOutputTitles(){
        return outputTitles;
    }
}
