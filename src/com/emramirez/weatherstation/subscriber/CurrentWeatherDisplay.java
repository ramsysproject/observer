package com.emramirez.weatherstation.subscriber;

import com.emramirez.weatherstation.publisher.WeatherSubject;

public class CurrentWeatherDisplay implements Observer {

    private WeatherSubject weatherSubject;
    private float temperature;
    private float humidity;

    public CurrentWeatherDisplay(WeatherSubject weatherSubject) {
        this.weatherSubject = weatherSubject;
        weatherSubject.addObserver(this);
    }

    @Override
    public void update() {
        this.temperature = weatherSubject.getTemperature();
        this.humidity = weatherSubject.getHumidity();
    }

    public void shutDown() {
        weatherSubject.removeObserver(this);
    }

    @Override
    public String toString() {
        return "CurrentWeatherDisplay{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
