package observer_pattern.yc;

public interface WeatherStation {
    void registerObserver(WeatherObserver o);

    void removeObserver(WeatherObserver o);

    void notifyObservers();
}
