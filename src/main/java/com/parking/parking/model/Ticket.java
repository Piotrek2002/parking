package com.parking.parking.model;

import java.time.LocalDateTime;

public class Ticket {
    LocalDateTime timeOfEntry;
    Tariff tariff;
    Integer countOfHour;
    double price;

    public Ticket(LocalDateTime timeOfEntry, Tariff tariff, Integer countOfHour, double price) {
        this.timeOfEntry = timeOfEntry;
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

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
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
}
