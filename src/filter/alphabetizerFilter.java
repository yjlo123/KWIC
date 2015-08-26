package filter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void run(ArrayList<String> parsingPara){
        initialise(parsingPara.get(0));
        Collections.sort(titlesList);
        this.outputString = convertToOutputString(this.titlesList);
        String replace = parsingPara.set(0,outputString);// Save and Provide OutputFilter with SORTED String
        //call next according to the filter chain
        this.callNext(this,parsingPara);
    }
    private void initialise(String titles){
        this.titlesList = new ArrayList<String>();
        this.outputString = "";
        this.titlesList = toList(titles);
    }
    public ArrayList<String> toList(String str){
        return new ArrayList<String>(Arrays.asList(str.split("\n")));
    }
    private String convertToOutputString(ArrayList<String> strList){
        String result = "";
        for(String item: strList){
            result = result + item + "\n";
        }
        return result;
    }
}
