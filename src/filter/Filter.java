package filter;

import javax.xml.soap.SAAJResult;
import java.lang.reflect.Array;
import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Created by haojiang on 20/8/15.
 */
public class Filter {

    //Attributes


    //Methods
    public Filter(){
    }
    public ArrayList<String> toStringList(String str){
        return new ArrayList<String>(Arrays.asList(str.split(",")));
    }
    public ArrayList<String> toIgnoredList(String str){
        String[] result = str.split(",");
        for (int i = 0; i < result.length; i++){
            result[i] = result[i].trim();
        }
        return new ArrayList<String>(Arrays.asList(result));
    }

    public String toString(ArrayList<String> strList){
        String result = "";
        for(String item : strList){
            result = result+" "+item;
        }
        return  result.trim();
    }

    public void init(String titles, String ignoredwords){
    }

    public void callPipe(Filter filter, ArrayList<String> parsingData){
        Pipes.callNext(filter, parsingData);
    }

    public void run(ArrayList<String> para){}

}
