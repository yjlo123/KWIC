package filter;

/**
 * Created by haojiang on 20/8/15.
 */
public class outputFilter extends Filter {
    //Methods
    public outputFilter(){
        super();
    }
    public void run(){
        System.out.print(FilterChain.getOutputTitles());
    }
}
