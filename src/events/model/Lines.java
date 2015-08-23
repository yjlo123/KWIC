package events.model;

import java.util.ArrayList;

/**
 * Created by siwei on 22/8/15.
 */
public class Lines {
    private ArrayList<String> lines;

    public Lines(){
        this.lines = new ArrayList<String>();
    }

    public void parse(String str){
        lines.clear();
        String[] arr = str.split(",");
        for(int i = 0; i < arr.length; i++){
            lines.add(arr[i].trim());
        }
    }

    public void add(String str){
        lines.add(str);
    }

    public String get(int i){
        return lines.get(i);
    }

    public String set(int i, String str){
        return lines.set(i, str);
    }

    public int size(){
        return lines.size();
    }

    public void clear(){
        lines.clear();
    }

    public boolean contains(String str){
        return lines.contains(str);
    }

    public String toString(){
        String result = "";
        for (int i = 0; i < lines.size(); i++){
            result += (lines.get(i)+"\n");
        }
        return result;
    }
}
