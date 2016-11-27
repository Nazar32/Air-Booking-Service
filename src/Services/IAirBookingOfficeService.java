package Services;


import Entities.Flight;

import java.util.List;

public interface IAirBookingOfficeService {

    void sortFlightsByLength(boolean asc);
    void outputAllSoldFlights();
    void outputSoldTickets();
    void outputPercantageOfSoldTicketsForEachFlight();
    void outputFlights();
}