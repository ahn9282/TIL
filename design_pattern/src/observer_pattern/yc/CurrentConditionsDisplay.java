package observer_pattern.yc;

import adapter_pattern.yc.DisplayAdapter;

public class CurrentConditionsDisplay implements WeatherObserver{
    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("Current : " + temp + "F, " + humidity + "% humidity");
    }
}
