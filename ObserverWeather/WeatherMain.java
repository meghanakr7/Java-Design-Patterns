package ObserverWeather;

public class WeatherMain {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        station.registerObserver(new PhoneObserver());
        station.registerObserver(new LaptopObserver());

        station.notifyObservers("33.f");
        


    }
}
