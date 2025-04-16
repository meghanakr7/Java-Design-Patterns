package ObserverWeather;

public class PhoneObserver implements Observer{
    @Override
    public void reportWeather(String temp) {
        System.out.println("Reporting weather through phone" + temp);
    }

}
