package ObserverWeather;

public interface Subject {
    public void registerObserver(Observer a);
    public void removeObserver(Observer a);
    public void notifyObservers(String temp);
}
