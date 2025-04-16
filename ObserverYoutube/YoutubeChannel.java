package ObserverYoutube;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subscriber {
    private List<Observer> subscribers = new ArrayList<>();
    
    @Override
    public void addSubscriber(Observer sub) {
        subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(Observer sub) {
        subscribers.remove(sub);
    }
    
    
    @Override
    public void notifySubscribers(String videoString) {
        for(Observer a: subscribers) {
            a.update(videoString);
        }
        
    }
}
