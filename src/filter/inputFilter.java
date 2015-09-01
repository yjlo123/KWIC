package filter;

import javax.management.AttributeList;
import java.util.ArrayList;

import static UI.GUI.getText;

/**
 * Created by haojiang on 20/8/15.
 */
public class inputFilter extends Filter {

    //Methods
    public inputFilter(){
        super();
    }

    public void run(ArrayList<String> parsingPara){
        // get text from UI
        ArrayList<String> input = getText();
        this.callPipe(this, input);
    }
}
