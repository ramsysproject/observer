package com.emramirez.weatherstation.publisher;

import com.emramirez.weatherstation.subscriber.Observer;

import java.util.HashSet;
import java.util.Set;

public class WeatherPublisher implements WeatherSubject {

    private Set<Observer> observers;
    private float temperature;
    private float humidity;

    public WeatherPublisher() {
        this.observers = new HashSet<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    public void takeMeasurements(float temperature, float humidity) {
        setHumidity(humidity);
        setTemperature(temperature);
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
