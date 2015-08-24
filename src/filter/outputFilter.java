package filter;

import UI.GUI;

import java.util.ArrayList;

/**
 * Created by haojiang on 20/8/15.
 */
public class outputFilter extends Filter {

    private static GUI gui;

    //Methods
    public outputFilter(){
        super();
    }

    public void setOutputGUI(GUI gui){
        this.gui = gui;
    }
    public void run(ArrayList<String> para){
        //System.out.print(para.get(0));
        gui.showResult(para.get(0));
    }
}
