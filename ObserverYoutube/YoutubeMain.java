package ObserverYoutube;

public class YoutubeMain {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel();
        channel.addSubscriber(new PhoneObserver());
        channel.notifySubscribers("How to eat pizza");

        channel.addSubscriber(new EmailObeserver());
        channel.notifySubscribers("Troubling to sleep?");


    }
}
