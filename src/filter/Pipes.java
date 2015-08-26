package filter;

import java.util.ArrayList;

/**
 * Created by haojiang on 27/8/15.
 */
public class Pipes {

    public Pipes(){}
    public void callNext(Filter currentFilter, ArrayList<String> parsingData){
        currentFilter.getNext().run(parsingData);
    }
}
