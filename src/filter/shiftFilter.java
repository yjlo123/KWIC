package filter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by haojiang on 20/8/15.
 */
public class shiftFilter extends Filter {
    //Attributes
    private ArrayList<String> titlesList;
    private ArrayList<String> ignoredWordsList;
    private ArrayList<String> outputList;
    private String outputString;
    //Methods
    public shiftFilter(){
        super();
    }
    public void run(String titles, String ignoredWords){
        initialiseStringList(titles, ignoredWords);
        CircularlyShift();
        outputString = convertToOutputString(outputList);
        //call next according to the filter chain with the outputString
    }

    private void initialiseStringList(String titles, String ignoredWords){
        titlesList = new ArrayList<String>();
        ignoredWordsList = new ArrayList<String>();
        outputList = new ArrayList<String>();
        outputString = "";
        titlesList = toStringList(titles);
        ignoredWordsList = toStringList(ignoredWords);
    }

    private void CircularlyShift(){
        for(String title : titlesList){
            ArrayList<String> singleTitleList = new ArrayList<String>();

            singleTitleList = splitEachTitle(title);
            if(!firstWordIsIgnored(singleTitleList.get(0))){
                outputList.add(toString(singleTitleList));
            }

            for(int i=0;i<singleTitleList.size()-1;i++){
                singleTitleList = Shift(singleTitleList);
                if(!firstWordIsIgnored(singleTitleList.get(0))){
                    outputList.add(toString(singleTitleList));
                }
            }
        }
    }
    private ArrayList<String> splitEachTitle(String title){
        return splitbySpace(title);
    }
    private ArrayList<String> splitbySpace(String title){
        return new ArrayList<String>(Arrays.asList(title.split(" ")));
    }
    private ArrayList<String> Shift(ArrayList<String> lst){
        lst.add(lst.remove(0));
        return lst;
    }
    private boolean firstWordIsIgnored(String firstWord){
        return ignoredWordsList.contains(firstWord);
    }
    private String convertToOutputString(ArrayList<String> strList){
        String result = "";
        for(String item: strList){
            result = result + item + "\n";
        }
        return result;
    }
}
