package Services;

import static Services.DateGenerator.randomDate;

import Entities.AirBookingOffice;
import Entities.Flight;
import Entities.Ticket;
import res.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AirBookingOfficeService implements IAirBookingOfficeService{

    private AirBookingOffice _airBookOffice;

    public AirBookingOfficeService(AirBookingOffice airBookingOffice) {
        _airBookOffice = airBookingOffice;
    }

    public void sortFlightsByLength(boolean asc) {

        ArrayList<Flight> flights = _airBookOffice.getFlights();
        int i, j;
        Flight key;

        for (j = 1; j < flights.size(); j++)
        {
            key = flights.get(j);
            for(i = j - 1; (i >= 0) && (asc ? (flights.get(i).compareTo(key) > 0)
                                        : (flights.get(i).compareTo(key) < 0)); i--)
            {
                flights.set(i + 1, flights.get(i));
            }
            flights.set(i + 1, key);
        }

        _airBookOffice.set_flights(flights);
    }

    public void outputAllSoldFlights() {

        List<Flight> soldFlights = _airBookOffice.getSoldFlights();

        if (soldFlights.size() == 0) {
            System.out.println("There are no sold flights");
            return;
        }

        System.out.println(R.PARAFRAPHS_3 + "Sold flights");

        soldFlights.forEach(System.out::println);
    }

    public void outputSoldTickets() {
        ArrayList<Flight> flights = _airBookOffice.getFlights();

        if (flights.size() == 0) {
            System.out.println("There are no flights");
            return;
        }

        if (!_airBookOffice.existsSoldTickets()) {
            System.out.println("There is no sold ticket in all flights");
            return;
        }

        System.out.println(R.PARAFRAPHS_3 + "Sold tickets");

        flights
                .forEach(f -> outputTickets(_airBookOffice.getSoldTicketsForFlight(f)));
    }

    public void outputPercantageOfSoldTicketsForEachFlight() {
        System.out.println(R.PARAFRAPHS_3);
        _airBookOffice.getFlights()
                            .forEach(f -> System.out.println("The percentage of sold tickets in flight " +
                                                            f.getId() +
                                                            ", is : " +
                                                            ((double)_airBookOffice.getCountOfSoldTicketsForFlight(f.getId()) /
                                                            (double)_airBookOffice.getFlightById(f.getId()).getTickets().size() ) * 100 + "%" ));
    }

    private void outputFlights(List<Flight> flights) {

        if (flights.size() == 0) {
            System.out.println("There are no flights");
            return;
        }

        flights
                .forEach(System.out::println);
        System.out.println();
    }

    private void outputTickets(List<Ticket> tickets) {

        if (tickets.size() == 0) {
            System.out.println("There are no tickets");
            return;
        }

        tickets
                .forEach(System.out::println);
        System.out.println();
    }

    public void outputFlights() {
        System.out.println(R.PARAFRAPHS_1 +
                           "Flights" +
                           R.PARAFRAPHS_1);
        _airBookOffice
                    .getFlights()
                    .forEach(System.out::println);
        System.out.println();
    }

    public void fillRandomFlights(int flightsCount) {
        for (int i = 0; i < flightsCount; i++) {
            _airBookOffice.getFlights().add(new Flight(i, "Name" + i, "From", "To", Math.abs(new Random().nextInt(10_000)), 10));
        }
    }

    public void fillFlightWithTickets(Flight flight) {
        for (int i = 0; i < flight.getMaxTicketsCount(); i++) {
            flight.getTickets().add(new Ticket(i, flight, randomDate(), new Random().nextBoolean()));
        }
    }


    public static void main(String[] args) {

    }

}
