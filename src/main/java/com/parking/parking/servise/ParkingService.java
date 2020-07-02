package com.parking.parking.servise;

import com.parking.parking.model.Place;
import com.parking.parking.model.Ticket;

import java.util.List;
import java.util.Map;

public interface ParkingService {
    void addPlace(Place place);
    void deletePlace(int placeId);
    Ticket park(Ticket ticket);
    Ticket getOut(Ticket ticket);
    Ticket pay(Ticket ticket);
    boolean checkTicketStatus(Ticket ticket);
    boolean checkPlaceAvailability(Place place);
    Ticket findTicketByPlace(Place place);
    Map<Place, Boolean> getAllPlace();
    List<Place> findAllFreePlace();
    Double monthlyIncome();
    int numberOfTicketsPerMonth();
    List<Ticket> ticketList();



}
