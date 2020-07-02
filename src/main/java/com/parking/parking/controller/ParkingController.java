package com.parking.parking.controller;

import com.parking.parking.model.Place;
import com.parking.parking.model.Tariff;
import com.parking.parking.model.Ticket;
import com.parking.parking.servise.ParkingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ParkingController {
    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/placeList")
    @ResponseBody
    public Map<Place, Boolean> list() {
        return parkingService.getAllPlace();
    }

    @GetMapping("/freePlaceList")
    @ResponseBody
    public List<Place> freePlaceList() {
        return parkingService.findAllFreePlace();
    }

    @PostMapping("/addPlace")
    @ResponseBody
    public Place addPlace(@RequestBody Place place) {
        parkingService.addPlace(place);
        return place;
    }

    @DeleteMapping("/deletePlace")
    @ResponseBody
    public Place deletePlace(@RequestBody Place place) {
        parkingService.deletePlace(place.getNumber());
        return place;
    }



}
