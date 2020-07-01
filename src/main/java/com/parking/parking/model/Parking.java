package com.parking.parking.model;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


public class Parking {
    Map<Place,Boolean> places;
    List<Ticket> tickets;

    public Map<Place, Boolean> getPlaces() {
        return places;
    }

    public void setPlaces(Map<Place, Boolean> places) {
        this.places = places;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Parking(Map<Place, Boolean> places, List<Ticket> tickets) {
        this.places = places;
        this.tickets = tickets;
    }

    public Parking() {
    }
}
