package com.parking.parking.servise;

import com.parking.parking.model.Parking;
import com.parking.parking.model.Place;
import com.parking.parking.model.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ParkingServiceImpl implements ParkingService{

private Parking parking;

    public ParkingServiceImpl() {

    }

    @Override
    public void addPlace() {

    }

    @Override
    public void deletePlace() {

    }

    @Override
    public void park(int ticketId) {

    }

    @Override
    public void getOut(int ticketId) {

    }

    @Override
    public void pay(int ticketId) {

    }

    @Override
    public boolean checkTicketStatus(int ticketId) {
        return false;
    }


    @Override
    public boolean checkPlaceAvailability() {
        return false;
    }

    @Override
    public Ticket findTicketByPlaceNumber() {
        return null;
    }

    @Override
    public List<Place> getAllPlace() {
        return null;
    }

    @Override
    public List<Place> findAllFreePlace() {
        return null;
    }

    @Override
    public Double monthlyIncome() {
        return null;
    }

    @Override
    public int numberOfTicketsPerMonth() {
        return 0;
    }
}
