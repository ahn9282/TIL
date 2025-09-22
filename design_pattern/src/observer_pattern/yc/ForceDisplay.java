package observer_pattern.yc;

public class ForceDisplay implements WeatherObserver{
    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("Forecast : " + (pressure < 29.92 ? "Rain" : "Sunny"));
    }
}
