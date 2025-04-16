package ObserverYoutube;


public class PhoneObserver implements Observer{
    @Override
    public void update(String videoTitle) {
        System.out.println("Got update to phone " +videoTitle);
    }

}
