package filter;

import javax.management.AttributeList;
import java.util.ArrayList;

/**
 * Created by haojiang on 20/8/15.
 */
public class inputFilter extends Filter {

    //Methods
    public inputFilter(){
        super();
    }

    public void init(String titles, String ignoredwords){
        ArrayList<String> parsingData = new ArrayList<String >();
        parsingData.add(titles);
        parsingData.add(ignoredwords);
        this.run(parsingData);
    }
    public void run(ArrayList<String> parsingPara){
        this.callNext(this,parsingPara);
    }
}
