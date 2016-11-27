package Entities;

import java.util.Date;

public class Ticket {
    private int Id;
    private Flight flight;
    private Date FlightDate;
    private boolean isSold;

    public Ticket(int Id, Flight flight, Date flightDate, boolean isSold) {
        this.Id = Id;
        this.flight = flight;
        FlightDate = flightDate;
        this.isSold = isSold;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Date getFlightDate() {
        return FlightDate;
    }

    public void setFlightDate(Date flightDate) {
        FlightDate = flightDate;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    @Override
    public String toString() {
        return "Id " + Id +
                ", Flight " + flight.getId() +
                ", Date " + FlightDate +
                (isSold ? ", Sold" : ", Not Sold");
    }
}
