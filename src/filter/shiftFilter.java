package filter;

import events.Controller;

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
    private String inputignoredwords="",inputtitles="";

    //Methods
    public shiftFilter(){
        super();

    }
    public void run(ArrayList<String> parsingPara){
        inputignoredwords = parsingPara.get(1);
        inputtitles = parsingPara.get(0);
        initialiseStringList(inputtitles, inputignoredwords);
        CircularlyShift();
        outputString = convertToOutputString(outputList);
        String replace = parsingPara.set(0,outputString);// Save and Provide AlphaFilter with the UNSORTED String.
        //call next according to the filter chain
        this.callPipe(this,parsingPara);
    }

    private void initialiseStringList(String titles, String ignoredWords){
        titlesList = new ArrayList<String>();
        ignoredWordsList = new ArrayList<String>();
        outputList = new ArrayList<String>();
        outputString = "";
        titlesList = toStringList(titles);
        ignoredWordsList = toIgnoredList(ignoredWords);
    }
    private void CircularlyShift(){
        for(String title : titlesList){
            ArrayList<String> singleTitleList = new ArrayList<String>();
            singleTitleList = splitEachTitle(title);
            for(int i=0;i<singleTitleList.size();i++){
                singleTitleList = Shift(singleTitleList);
                if(!firstWordIsIgnored(singleTitleList.get(0))){
                    outputList.add(toString(singleTitleList));
                }
            }
        }
    }
    private String changeCase(String str){
        if(str.length()>=2){
            if (firstWordIsIgnored(str.toLowerCase())){
                return str.toLowerCase();
            }else{
                return str.substring(0, 1).toUpperCase() + str.substring(1);
            }
        }
        else{
            return str.toUpperCase();
        }
    }
    private ArrayList<String> splitEachTitle(String title){
        String[] result = title.split(" +");
        for (int i = 0; i < result.length; i++){
            result[i] = result[i].trim();
            result[i] = changeCase(result[i]);
        }
        return new ArrayList<String>(Arrays.asList(result));
    }
    private ArrayList<String> Shift(ArrayList<String> lst){
        lst.add(lst.remove(0));
        return lst;
    }
    private boolean firstWordIsIgnored(String firstWord){
        boolean result = false;
        for(int i = 0; i<ignoredWordsList.size();i++){
            if(ignoredWordsList.get(i).equalsIgnoreCase(firstWord)){
                result = true;
            }
        }
        return result;
    }
    private String convertToOutputString(ArrayList<String> strList){
        String result = "";
        for(String item: strList){
            result = result + item + "\n";
        }
        return result;
    }
}
