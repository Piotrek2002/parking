package com.parking.parking.servise;

import com.parking.parking.model.Parking;
import com.parking.parking.model.Place;
import com.parking.parking.model.Ticket;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ParkingServiceImpl implements ParkingService{

private Parking parking;

    public ParkingServiceImpl() {
        Place place=new Place(1,15,"aaa");
        Place place1=new Place(2,15,"bbb");
        Place place2=new Place(3,15,"ccc");
        Place place3=new Place(4,20,"ddd");
        Place place4=new Place(5,40,"eee");
        Map<Place,Boolean> map=new HashMap();
        map.put(place,false);
        map.put(place1,false);
        map.put(place2,false);
        map.put(place3,false);
        map.put(place4,false);
        parking.setPlaces(map);
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
