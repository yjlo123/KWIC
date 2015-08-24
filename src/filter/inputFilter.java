package filter;

/**
 * Created by haojiang on 20/8/15.
 */
public class inputFilter extends Filter {

    //Methods
    public inputFilter(){
        super();
    }
    public void run(){
        if(this.hasNext()){
            this.getNext().run();
        }
    }
}
