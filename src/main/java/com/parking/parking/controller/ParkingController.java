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

    @PostMapping("/parkCar")
    @ResponseBody
    public String parkCar(@RequestBody Ticket ticket) {
        if (parkingService.findAllFreePlace().contains(ticket.getPlace())) {
            ticket.setTariff(Tariff.Price.CAR);
            parkingService.park(ticket);
            return "parkowanie " + ticket.toString();
        } else {
            return "miejsce jest niedostępne";
        }

    }

    @PostMapping("/parkTrack")
    @ResponseBody
    public String parkTrack(@RequestBody Ticket ticket) {
        if (parkingService.findAllFreePlace().contains(ticket.getPlace())) {
        ticket.setTariff(Tariff.Price.TRACK);
        parkingService.park(ticket);
        return "parkowanie " + ticket.toString();
         } else {
         return "miejsce jest niedostępne";
         }

    }

    @PostMapping("/parkBus")
    @ResponseBody
    public String parkBus(@RequestBody Ticket ticket) {
        if (parkingService.findAllFreePlace().contains(ticket.getPlace())) {
        ticket.setTariff(Tariff.Price.BUS);
        parkingService.park(ticket);
        return "parkowanie " + ticket.toString();
         } else {
         return "miejsce jest niedostępne";
         }

    }

    @GetMapping("/ticketList")
    @ResponseBody
    public List<Ticket> ticketList() {
        return parkingService.ticketList();
    }

    @PostMapping("/pay")
    @ResponseBody
    public Ticket pay(@RequestBody Ticket ticket) {
        Ticket ticket1 = parkingService.findTicketByPlace(ticket.getPlace());
        return parkingService.pay(ticket1);
    }
    @PostMapping("/getOut")
    @ResponseBody
    public Ticket getOut(@RequestBody Ticket ticket){
        Ticket ticket1 = parkingService.findTicketByPlace(ticket.getPlace());
        return parkingService.getOut(ticket1);
    }
    @PostMapping("/checkPlaceAvailability")
    @ResponseBody
    public String checkPlaceAvailability(@RequestBody Place place){
        if (parkingService.checkPlaceAvailability(place)){
            return "Miejsce dostepne: "+place.toString();
        }else {
            return "Miejsce nie dostępne";
        }

    }
    @GetMapping("monthlyIncome/year/month")
    @ResponseBody
    public double monthlyIncome(@PathVariable int year,@PathVariable int month){
        return parkingService.monthlyIncome(year,month);
    }
    @GetMapping("numberOfTicketsPerMonth/year/month")
    @ResponseBody
    public int numberOfTicketsPerMonth(@PathVariable int year,@PathVariable int month){
        return parkingService.numberOfTicketsPerMonth(year, month);
    }

}
