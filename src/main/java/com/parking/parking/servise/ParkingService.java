package com.parking.parking.servise;

import com.parking.parking.model.Place;
import com.parking.parking.model.Ticket;

import java.util.List;

public interface ParkingService {
    void addPlace(Place place);
    void deletePlace(int placeId);
    void park(int ticketId);
    void getOut(int ticketId);
    void pay(int ticketId);
    boolean checkTicketStatus(int ticketId);
    boolean checkPlaceAvailability();
    Ticket findTicketByPlaceNumber();
    List<Place> getAllPlace();
    List<Place> findAllFreePlace();
    Double monthlyIncome();
    int numberOfTicketsPerMonth();



}
