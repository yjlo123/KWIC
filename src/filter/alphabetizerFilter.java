package filter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by haojiang on 20/8/15.
 */
public class alphabetizerFilter extends Filter{
    private ArrayList<String> titlesList;
    private String outputString;
    //Methods
    public alphabetizerFilter(){
        super();
    }
    public void run(String titles){
        initialise(titles);
        sort();
        outputString = convertToOutputString(titlesList);
        //call next according to the filter chain with the outputString
    }
    private void initialise(String titles){
        titlesList = new ArrayList<String>();
        outputString = "";
        titlesList = toStringList(titles);
    }
    private void sort(){
        Collections.sort(titlesList, String.CASE_INSENSITIVE_ORDER);
    }
    private String convertToOutputString(ArrayList<String> strList){
        String result = "";
        for(String item: strList){
            result = result + item + "\n";
        }
        return result;
    }
}
