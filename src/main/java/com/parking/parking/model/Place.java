package com.parking.parking.model;

public class Place {
    private int number;
    private double area;
    private String description;

    public Place(int number, double area, String description) {
        this.number = number;
        this.area = area;
        this.description = description;
    }

    public Place() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
