package com.example.demo.flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightManagement {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        FlightService flightService = new FlightService();

        flightService.createFlight(100);
        flightService.createFlight(200);
        while(true){
            flightService.listFlights();
            System.out.println("1. Book Ticket  2.CancelTicket  3.PrintPassengerDetails");
            int option = sc.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("Enter passengerId: ");
                    int passengerId = sc.nextInt();
                    System.out.println("Enter flightId: ");
                    int flightId = sc.nextInt();
                    Flight flight = flightService.getFlight(flightId);
                    if(flight == null){
                        System.out.println("Invalid flightId");
                        continue;
                    }
                    flight.printLayout();
                    System.out.println("Enter number of tickets: ");
                    int noOfTickets = sc.nextInt();
                    System.out.print("Enter Seat numbers: ");
                    List<Integer> seatNumbers = new ArrayList<>();
                    while(noOfTickets >0){
                        seatNumbers.add(sc.nextInt());
                        noOfTickets--;
                    }
                    flightService.bookTickets(flightId, passengerId, seatNumbers.size(), seatNumbers);
                }
                case 2 -> {
                    System.out.println("Enter flightId: ");
                    int flightId = sc.nextInt();
                    System.out.println("Enter passengerId: ");
                    int passengerId = sc.nextInt();
                    flightService.cancelTickets(flightId, passengerId);
                }
                case 3 -> {
                    System.out.println("Enter flightId: ");
                    int flightId = sc.nextInt();
                    flightService.printPassenger(flightId);
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
