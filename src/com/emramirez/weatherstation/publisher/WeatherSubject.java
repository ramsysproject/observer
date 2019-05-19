package com.emramirez.weatherstation.publisher;

import com.emramirez.weatherstation.subscriber.Observer;

public interface WeatherSubject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    float getTemperature();
    float getHumidity();
}
