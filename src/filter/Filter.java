package filter;

import javax.xml.soap.SAAJResult;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by haojiang on 20/8/15.
 */
public class Filter {

    //Attributes
    public ArrayList<String> data;
    public Filter Next = null;

    //Methods
    public Filter(){}
    public void SetNext(Filter nextFilter){
        this.Next = nextFilter;
    }
    public boolean hasNext(){
        return this.Next!=null;
    }
    public ArrayList<String> toStringList(String str){
        return new ArrayList<String>(Arrays.asList(str.split("\n")));
    }
    public String toString(ArrayList<String> strList){
        String result = "";
        for(String item : strList){
            result = result+" "+item;
        }
        return  result;
    }

}