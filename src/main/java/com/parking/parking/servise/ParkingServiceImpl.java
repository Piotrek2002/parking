package com.parking.parking.servise;

import com.parking.parking.model.Parking;
import com.parking.parking.model.Place;
import com.parking.parking.model.Tariff;
import com.parking.parking.model.Ticket;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ParkingServiceImpl implements ParkingService {

    private Parking parking;

    public ParkingServiceImpl(Parking parking) {
        this.parking = parking;
        Place place = new Place(1, 15, "aaa");
        Place place1 = new Place(2, 15, "bbb");
        Place place2 = new Place(3, 15, "ccc");
        Place place3 = new Place(4, 20, "ddd");
        Place place4 = new Place(5, 40, "eee");
        Map<Place, Boolean> map = new HashMap<>();
        List<Ticket> tickets=new ArrayList<>();
        LocalDateTime timeOfEntry=LocalDateTime.parse("2020-07-03T13:09:53.413");
        LocalDateTime timeOfDeparture=LocalDateTime.parse("2020-07-03T13:19:23.413");
        Tariff.Price price=Tariff.Price.CAR;
        Ticket ticket=new Ticket(timeOfEntry,timeOfDeparture,true,place,price,10,100);
        tickets.add(ticket);
        map.put(place, false);
        map.put(place1, true);
        map.put(place2, true);
        map.put(place3, true);
        map.put(place4, true);
        this.parking.setTickets(tickets);
        this.parking.setPlaces(map);
    }

    @Override
    public void addPlace(Place place) {
        Map<Place, Boolean> map = parking.getPlaces();
        map.put(place, true);
        parking.setPlaces(map);
    }

    @Override
    public void deletePlace(int placeId) {
        Map<Place, Boolean> map = parking.getPlaces();
        Set<Place> places = map.keySet();
        for (Place place : places) {
            if (place.getNumber() == placeId) {
                map.remove(place);
            }
        }

    }

    @Override
    public Ticket park(Ticket ticket) {
        Map<Place, Boolean> map = parking.getPlaces();
        Place place = ticket.getPlace();
        map.remove(place);
        map.put(place, false);
        ticket.setTimeOfEntry(LocalDateTime.now());
        ticket.setStatus(false);
        List<Ticket> tickets = parking.getTickets();
        tickets.add(ticket);
        parking.setTickets(tickets);
        return ticket;
    }

    @Override
    public Ticket getOut(Ticket ticket) {
        Map<Place, Boolean> map = parking.getPlaces();
        Place place = ticket.getPlace();
        map.remove(place);
        map.put(place, true);
        List<Ticket> tickets=parking.getTickets();
        tickets.remove(ticket);
        ticket.setTimeOfDeparture(LocalDateTime.now());
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public Ticket pay(Ticket ticket) {
        List<Ticket> tickets=parking.getTickets();
        tickets.remove(ticket);
        ticket.setStatus(true);
        long time=Duration.between(ticket.getTimeOfEntry(),LocalDateTime.now()).getSeconds();
        ticket.setCountOfHour(round(time));
        ticket.setPrice(ticket.getCountOfHour()*ticket.getTariff());
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public boolean checkTicketStatus(Ticket ticket) {
        if (ticket.isStatus()) {
            return true;
        } else {
            return false;
        }

    }


    @Override
    public boolean checkPlaceAvailability(Place place) {
        return parking.getPlaces().get(place);
    }

    @Override
    public Ticket findTicketByPlace(Place place) {
        List<Ticket> tickets = parking.getTickets();
        Ticket t = new Ticket();
        for (Ticket ticket : tickets) {
            if (place.equals(ticket.getPlace())) {
                t = ticket;
            }
        }
        return t;
    }

    @Override
    public Map<Place, Boolean> getAllPlace() {
        return parking.getPlaces();
    }

    @Override
    public List<Place> findAllFreePlace() {
        List<Place> placeList = new ArrayList<>();
        Set<Place> places = parking.getPlaces().keySet();
        for (Place place : places) {
            if (parking.getPlaces().get(place)) {
                placeList.add(place);
            }
        }
        return placeList;
    }

    @Override
    public Double monthlyIncome(int year,int month) {
        Month month1=Month.of(month);
        List<Ticket> tickets=parking.getTickets().stream().filter(f->f.getTimeOfEntry().getMonth().equals(month1))
                .filter(f->f.getTimeOfEntry().getYear()==year).collect(Collectors.toList());
        double income=0;
        for (Ticket ticket:tickets){
            income+=ticket.getPrice();
        }

        return income;
    }

    @Override
    public int numberOfTicketsPerMonth(int year,int month) {
        Month month1=Month.of(month);
        List<Ticket> tickets=parking.getTickets().stream().filter(f->f.getTimeOfEntry().getMonth().equals(month1))
                .filter(f->f.getTimeOfEntry().getYear()==year).collect(Collectors.toList());
        return tickets.size();
    }

    @Override
    public List<Ticket> ticketList() {
        return parking.getTickets();
    }

    public int round(long second){

        if (second%3600==0){
            return (int) (second/3600);
        }else {
            return (int) (second/3600+1);
        }
    }
    @Override
    public List<Place> findAllOccupiedPlace() {
        List<Place> placeList = new ArrayList<>();
        Set<Place> places = parking.getPlaces().keySet();
        for (Place place : places) {
            if (!parking.getPlaces().get(place)) {
                placeList.add(place);
            }
        }
        return placeList;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }
}
