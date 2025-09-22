package observer_pattern.yc;

public interface WeatherObserver {
    void update(float temp, float humidity, float pressure);
}
