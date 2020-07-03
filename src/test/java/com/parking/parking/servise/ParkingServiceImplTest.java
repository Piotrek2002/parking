package com.parking.parking.servise;

import com.parking.parking.model.Parking;
import com.parking.parking.model.Place;
import com.parking.parking.model.Tariff;
import com.parking.parking.model.Ticket;
import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.validation.constraints.Max;
import java.time.LocalDateTime;
import java.util.*;

class ParkingServiceImplTest {



    @Test
    void addPlace() {
        Parking parking=new Parking();
        ParkingServiceImpl parkingService=new ParkingServiceImpl(parking);
        Place place = new Place(1, 15, "aaa");
        Place place1 = new Place(2, 15, "bbb");
        Place place2 = new Place(3, 15, "ccc");
        Place place3 = new Place(4, 20, "ddd");
        Place place4 = new Place(5, 40, "eee");
        Place place5=new Place(6,20,"fff");
        parkingService.addPlace(place5);
        List<Place> placeList= new ArrayList<>();
        Set<Place> places=parkingService.getAllPlace().keySet();
        for (Place p : places) {

                placeList.add(p);

        }

        assertThat(placeList,hasItems(place1,place2,place3,place4,place,place5));

    }

    @Test
    void deletePlace() {
        Parking parking=new Parking();
        ParkingServiceImpl parkingService=new ParkingServiceImpl(parking);
        Place place = new Place(1, 15, "aaa");
        Place place1 = new Place(2, 15, "bbb");
        Place place2 = new Place(3, 15, "ccc");
        Place place3 = new Place(4, 20, "ddd");
        Place place4 = new Place(5, 40, "eee");
        parkingService.deletePlace(4);
        List<Place> placeList= new ArrayList<>();
        Set<Place> places=parkingService.getAllPlace().keySet();
        for (Place p : places) {

            placeList.add(p);

        }

        assertThat(placeList,hasItems(place1,place2,place4,place));
    }


    @Test
    void getAllPlace() {
        Parking parking=new Parking();
        ParkingServiceImpl parkingService=new ParkingServiceImpl(parking);
        Place place = new Place(1, 15, "aaa");
        Place place1 = new Place(2, 15, "bbb");
        Place place2 = new Place(3, 15, "ccc");
        Place place3 = new Place(4, 20, "ddd");
        Place place4 = new Place(5, 40, "eee");


        Map<Place,Boolean> test=parkingService.getAllPlace();
        assertThat(test, IsMapContaining.hasEntry(place,false));
        assertThat(test, IsMapContaining.hasEntry(place1,true));
        assertThat(test, IsMapContaining.hasEntry(place2,true));
        assertThat(test, IsMapContaining.hasEntry(place3,true));
        assertThat(test, IsMapContaining.hasEntry(place4,true));

    }

    @Test
    void findAllFreePlace() {
        Parking parking=new Parking();
        ParkingServiceImpl parkingService=new ParkingServiceImpl(parking);
        Place place = new Place(1, 15, "aaa");
        Place place1 = new Place(2, 15, "bbb");
        Place place2 = new Place(3, 15, "ccc");
        Place place3 = new Place(4, 20, "ddd");
        Place place4 = new Place(5, 40, "eee");

        List<Place> places=parkingService.findAllFreePlace();

        assertThat(places,hasItems(place1,place2,place3,place4));


        parkingService.park(parkingService.findTicketByPlace(place4));
        assertThat(places,hasItems(place1,place2,place3));
    }

    @Test
    void monthlyIncome() {
        Parking parking=new Parking();
        ParkingServiceImpl parkingService=new ParkingServiceImpl(parking);
        assertThat(parkingService.monthlyIncome(2020,07),is(100.0));

    }

    @Test
    void numberOfTicketsPerMonth() {
        Parking parking=new Parking();
        ParkingServiceImpl parkingService=new ParkingServiceImpl(parking);
        assertThat(parkingService.numberOfTicketsPerMonth(2020,07),is(1));
    }

    @Test
    void ticketList() {
        Parking parking=new Parking();
        ParkingServiceImpl parkingService=new ParkingServiceImpl(parking);
        assertThat(parking.getTickets(),is(parkingService.ticketList()));

    }

    @Test
    void findAllOccupiedPlace() {
        Parking parking=new Parking();
        ParkingServiceImpl parkingService=new ParkingServiceImpl(parking);

        List<Place> places=parkingService.findAllOccupiedPlace();

        assertThat(places,hasItems());



    }

    @Test
    void round() {
        Parking parking=new Parking();
        ParkingServiceImpl parkingService=new ParkingServiceImpl(parking);
        int result=parkingService.round(3600);
        assertEquals(1,result);
        int result1=parkingService.round(3601);
        assertEquals(2,result1);

    }
}