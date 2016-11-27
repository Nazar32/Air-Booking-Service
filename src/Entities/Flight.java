package Entities;

import java.text.SimpleDateFormat;
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



    private Date randomDate() {
        SimpleDateFormat dfDateTime  = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());

        int year = randBetween(1900, 2013);
        int month = randBetween(0, 11);
        int hour = randBetween(9, 22);
        int min = randBetween(0, 59);
        int sec = randBetween(0, 59);


        GregorianCalendar gc = new GregorianCalendar(year, month, 1);
        int day = randBetween(1, gc.getActualMaximum(gc.DAY_OF_MONTH));

        gc.set(year, month, day, hour, min,sec);

        return gc.getTime();
    }

    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
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
