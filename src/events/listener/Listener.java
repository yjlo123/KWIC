package events.listener;

import java.util.List;

/**
 * Created by siwei on 22/8/15.
 */
public interface Listener {
    void addListener(Listener listener);
    void update();
}
