package Entities;

import static Services.DateGenerator.randomDate;
import java.util.*;


public class Flight implements Comparable{

    private int Id;
    private String Name;
    private String From;
    private String To;
    private double Length;
    private ArrayList<Ticket> tickets;
    private int MaxTicketsCount;

    public Flight(int id, String name, String from, String to, double length, int maxTicketsCount) {
        Id = id;
        Name = name;
        From = from;
        To = to;
        Length = length;
        tickets = new ArrayList<>();
        MaxTicketsCount = maxTicketsCount;
        fillFlightWithTickets();
    }

    public void fillFlightWithTickets() {
        for (int i = 0; i < getMaxTicketsCount(); i++) {
            tickets.add(new Ticket(i, this, randomDate(), new Random().nextBoolean()));
        }
    }




    @Override
    public String toString() {
        String ticketsString = "";
        for (Ticket ticket : tickets) {
            ticketsString += ticket.toString() + '\n';
        }
    return  "Id " + Id +
            ", Name " + Name +
            ", From " + From +
            ", To " + To +
            ", Length " + Length +
            ", Max Tickets Count " + MaxTicketsCount + '\n' +
            "Tickets " + "\n" + ticketsString;
    }

    @Override
    public int compareTo(Object o) {
        return  this.getLength() > ((Flight) o).getLength() ?  1
                :  this.getLength() < ((Flight) o).getLength() ? -1
                : 0;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getMaxTicketsCount() {
        return MaxTicketsCount;
    }

    public void setMaxTicketsCount(int maxTicketsCount) {
        MaxTicketsCount = maxTicketsCount;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public double getLength() {
        return Length;
    }

    public void setLength(double length) {
        Length = length;
    }


}
