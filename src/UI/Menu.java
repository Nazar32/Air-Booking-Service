package UI;

import Entities.AirBookingOffice;
import Services.AirBookingOfficeService;
import Services.IAirBookingOfficeService;
import org.omg.CORBA.Environment;
import res.R;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private final BufferedReader _reader;
    AirBookingOffice _airBookingOffice;
    IAirBookingOfficeService _airBookingOfficeService;

    public Menu(AirBookingOffice airBookingOffice,
                IAirBookingOfficeService airBookingOfficeService) throws IOException {

        _reader = new BufferedReader(new InputStreamReader(System.in));
        _airBookingOffice = airBookingOffice;
        _airBookingOfficeService = airBookingOfficeService;
        _airBookingOfficeService.fillRandomFlights(10);

    }


    public void showMenu() throws IOException, InterruptedException {

        System.out.println("1) Sort flights by length (1)" + R.PARAFRAPHS_1 +
                "2) Show all sold flights (2)" + R.PARAFRAPHS_1 +
                "3) Show all sold tickets (3)" + R.PARAFRAPHS_1 +
                "4) Show percentage of sold tickets by flights (4)" + R.PARAFRAPHS_1 +
                "5) Show all flights (5)" + R.PARAFRAPHS_1 +
                "6) Exit (6)");

        String s = _reader.readLine();


        switch(s) {
            case "1":
                System.out.println("Input value 1 for ascending sorting and value 2 for descending sorting : ");
                String s1 = _reader.readLine();
                if (s1.equals("1")) {
                    System.out.println(R.PARAFRAPHS_3 + "After ascending sorting: ");
                    _airBookingOfficeService.sortFlightsByLength(true);
                    _airBookingOfficeService.outputFlights();
                    _reader.readLine();
                    showMenu();
                }
                else if (s1.equals("2")) {
                    System.out.println(R.PARAFRAPHS_3 + "After descending sorting: ");
                    _airBookingOfficeService.sortFlightsByLength(false);
                    _airBookingOfficeService.outputFlights();
                    _reader.readLine();
                    showMenu();
                }
                else {
                    System.out.println("Input valid value");
                    _reader.readLine();
                    showMenu();
                }
                break;
            case "2" :
                _airBookingOfficeService.outputAllSoldFlights();
                _reader.readLine();
                showMenu();
                break;
            case "3" :
                _airBookingOfficeService.outputSoldTickets();
                _reader.readLine();
                showMenu();
                break;
            case "4" :
                _airBookingOfficeService.outputPercantageOfSoldTicketsForEachFlight();
                _reader.readLine();
                showMenu();
                break;
            case "5" :
                _airBookingOfficeService.outputFlights();
                _reader.readLine();
                showMenu();
                break;
            case "6":
                System.exit(0);
            default:
                System.out.println("Input valid value");
                _reader.readLine();
                showMenu();
        }
    }



    public static void main(String[] args) throws IOException, InterruptedException {
        AirBookingOffice airBookingOffice = new AirBookingOffice();
        IAirBookingOfficeService airBookingOfficeService = new AirBookingOfficeService(airBookingOffice);
        Menu menu = new Menu(airBookingOffice, airBookingOfficeService);
        menu.showMenu();
    }
}
