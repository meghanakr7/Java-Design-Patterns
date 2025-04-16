package ObserverWeather;

public class LaptopObserver implements Observer{
    @Override
    public void reportWeather(String temp) {
        System.out.println("Reporting Weather through Laptop " +temp);
    }
}
