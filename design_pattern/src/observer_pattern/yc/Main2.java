package observer_pattern.yc;

public class Main2 {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay
                = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay =  new StatisticsDisplay();
        ForceDisplay forecastDisplay = new ForceDisplay();

        weatherData.registerObserver(currentConditionsDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
    }
}
