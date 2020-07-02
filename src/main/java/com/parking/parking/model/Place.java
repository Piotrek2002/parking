package com.parking.parking.model;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Place{" +
                "number=" + number +
                ", area=" + area +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;
        Place place = (Place) o;
        return getNumber() == place.getNumber() &&
                Double.compare(place.getArea(), getArea()) == 0 &&
                Objects.equals(getDescription(), place.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getArea(), getDescription());
    }
}
