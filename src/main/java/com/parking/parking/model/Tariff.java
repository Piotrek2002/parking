package com.parking.parking.model;

public class Tariff {
    public enum Price{
        TRACK(30),
        BUS(20),
        CAR(10);

        double price;

        Price(double i) {
            price=i;
        }
    }

}
