package com.parking.parking.model;

public class Tariff {
    public enum Price{
        HOLIDAY(20),
        NORMAL(10);

        double price;

        Price(double i) {
            price=i;
        }
    }

}
