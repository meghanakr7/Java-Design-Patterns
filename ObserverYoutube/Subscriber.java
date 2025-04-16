package ObserverYoutube;

public interface Subscriber {
    void addSubscriber(Observer sub);
    void removeSubscriber(Observer sub);
    void notifySubscribers(String vidoeTitle);
}
