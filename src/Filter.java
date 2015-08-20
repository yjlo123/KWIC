import java.util.ArrayList;

/**
 * Created by haojiang on 20/8/15.
 */
public class Filter {

    public ArrayList<String> data;
    public Filter Next = null;

    public Filter(){}
    public void SetNext(Filter nextFilter){
        this.Next = nextFilter;
    }
    public boolean hasNext(){
        return this.Next!=null;
    }

}
