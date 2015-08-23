package filter;
import filter.*;
import java.util.ArrayList;

/**
 * Created by haojiang on 20/8/15.
 */
public class FilterChain {

    //Attributes
    public ArrayList<Filter> chain;

    //Methods
    public FilterChain(){
        chain = new ArrayList<Filter>();
    }
    public void add(Filter filter){
        chain.add(filter);
    }
    public Filter getHead(){
        if(!chain.isEmpty()){
            return chain.get(0);
        }
        else return null;
    }
    public Filter getTail(){
        if(!chain.isEmpty()){
            return chain.get(chain.size()-1);
        }
        else return null;
    }
    public void run(String titles, String ignoredWords){
        //this.getHead().run(titles,ignoredWords);
    }
}
