package ObserverWeather;


import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer a) {
        observers.add(a);
    }

    @Override
    public void removeObserver(Observer a) {
        observers.remove(a);
    }

    @Override
    public void notifyObservers(String temperature) {
        for(Observer a: observers) {
            a.reportWeather(temperature);
        }
    }
}
