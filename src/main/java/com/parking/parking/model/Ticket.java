package com.parking.parking.model;

import java.time.LocalDateTime;

public class Ticket {
    LocalDateTime timeOfEntry;
    LocalDateTime timeOfDeparture;
    boolean status;
    Place place;
    Tariff.Price tariff;
    Integer countOfHour;
    double price;

    public Ticket(LocalDateTime timeOfEntry, LocalDateTime timeOfDeparture, boolean status, Place place, Tariff.Price tariff, Integer countOfHour, double price) {
        this.timeOfEntry = timeOfEntry;
        this.timeOfDeparture = timeOfDeparture;
        this.status = status;
        this.place = place;
        this.tariff = tariff;
        this.countOfHour = countOfHour;
        this.price = price;
    }

    public Ticket() {
    }

    public LocalDateTime getTimeOfEntry() {
        return timeOfEntry;
    }

    public void setTimeOfEntry(LocalDateTime timeOfEntry) {
        this.timeOfEntry = timeOfEntry;
    }



    public Integer getCountOfHour() {
        return countOfHour;
    }

    public void setCountOfHour(Integer countOfHour) {
        this.countOfHour = countOfHour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getTimeOfDeparture() {

        return timeOfDeparture;
    }

    public void setTimeOfDeparture(LocalDateTime timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public double getTariff() {
        return tariff.price;
    }

    public void setTariff(Tariff.Price tariff) {
        this.tariff = tariff;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "timeOfEntry=" + timeOfEntry +
                ", timeOfDeparture=" + timeOfDeparture +
                ", status=" + status +
                ", place=" + place +
                ", tariff=" + tariff +
                ", countOfHour=" + countOfHour +
                ", price=" + price +
                '}';
    }

}
