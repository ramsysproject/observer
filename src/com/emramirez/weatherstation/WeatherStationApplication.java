package com.emramirez.weatherstation;

import com.emramirez.weatherstation.publisher.WeatherPublisher;
import com.emramirez.weatherstation.publisher.WeatherSubject;
import com.emramirez.weatherstation.subscriber.CurrentWeatherDisplay;
import com.emramirez.weatherstation.subscriber.Observer;

public class WeatherStationApplication {

    public static void main(String... args) {
        WeatherSubject weatherSubject = new WeatherPublisher();
        Observer currentWeatherDisplay = new CurrentWeatherDisplay(weatherSubject);
        System.out.println(currentWeatherDisplay.toString());
        ((WeatherPublisher) weatherSubject).takeMeasurements(45, 80);
        System.out.println(currentWeatherDisplay.toString());
        ((WeatherPublisher) weatherSubject).takeMeasurements(47, 90);
        System.out.println(currentWeatherDisplay.toString());
        ((WeatherPublisher) weatherSubject).takeMeasurements(50, 100);
        System.out.println(currentWeatherDisplay.toString());

        ((CurrentWeatherDisplay) currentWeatherDisplay).shutDown();
        ((WeatherPublisher) weatherSubject).takeMeasurements(100, 100);
        System.out.println(currentWeatherDisplay.toString());
    }
}
