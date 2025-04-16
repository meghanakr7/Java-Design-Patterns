package ObserverYoutube;

public class EmailObeserver implements Observer{
    @Override
    public void update(String vidoeTitle) {
        System.out.println("Got notification to email user " +vidoeTitle);
    }
}
