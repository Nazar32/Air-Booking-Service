package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AirBookingOffice {

    private ArrayList<Flight> _flights;


    public AirBookingOffice(ArrayList<Flight> flights) {
        this._flights = new ArrayList<>();
        this._flights = flights;
    }

    public AirBookingOffice() {
        _flights = new ArrayList<>();
    }


    public ArrayList<Flight> getFlights() {
        return _flights;
    }

    public Flight getFlightById(int Id) {
        return _flights
                    .stream()
                    .filter(f -> f.getId() == Id)
                    .findFirst()
                    .get();
    }

    public List<Ticket> getSoldTicketsForFlight(Flight flight) {
        return flight
                    .getTickets()
                    .stream()
                    .filter(t -> t.isSold())
                    .collect(Collectors.toList());
    }

    public List<Flight> getSoldFlights() {
        return _flights
                   .stream()
                   .filter(f -> f.getTickets()
                                        .stream()
                                        .allMatch(t -> t.isSold()))
                                        .collect(Collectors.toList());
    }

    public long getCountOfSoldTicketsForFlight(int Id) {
        return _flights
                    .stream()
                    .filter(f -> f.getId() == Id)
                    .findFirst()
                    .get()
                        .getTickets()
                                    .stream()
                                    .filter(t -> t.isSold())
                                    .count();
    }

    public boolean existsSoldTickets() {
        return this._flights
                        .stream()
                        .anyMatch(f -> f.getTickets()
                                            .stream()
                                            .anyMatch(Ticket::isSold));
    }

    public void set_flights(ArrayList<Flight> _flights) {
        this._flights = _flights;
    }


    public void fillRandomFlights(int flightsCount) {
        for (int i = 0; i < flightsCount; i++) {
            _flights.add(new Flight(i, "Name" + i, "From", "To", Math.abs(new Random().nextInt(10_000)), 10));
        }
    }


}
