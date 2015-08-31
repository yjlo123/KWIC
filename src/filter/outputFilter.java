package filter;

import UI.GUI;

import java.util.ArrayList;

/**
 * Created by haojiang on 20/8/15.
 */
public class outputFilter extends Filter {

    //Methods
    public outputFilter(){
        super();
    }

    public void run(ArrayList<String> para){
        GUI.showResult(para.get(0));
    }
}
