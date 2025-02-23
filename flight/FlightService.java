package com.example.demo.flight;

import java.util.*;

public class FlightService {

    Map<Integer,Flight> flights = new HashMap<>();


    public Flight getFlight(int flightId){
        return flights.get(flightId);
    }
    public void createFlight(int flightId) {
        flights.put(flightId,new Flight(flightId,500,9,new HashMap<>(),new ArrayList<>(),3,3));
    }

    public void cancelFlight(int flightId) {
        flights.remove(flightId);
    }


    public void bookTickets(int flightId, int passengerId, int noOfTickets, List<Integer> seatNumbers) {
        Flight flight = flights.get(flightId);
        if (flight == null){
            System.out.println("Flight not available for flightId: " + flightId);
            return;
        }

        if(flight.getNoOfTicketsAvailable() < noOfTickets && flight.getBookedSeatNumber().contains(seatNumbers)){
            System.out.println("Tickets unavailable");
            return;
        }

        Ticket ticket = Ticket.builder()
                .flightId(flightId)
                .passengerId(passengerId)
                .noOfTickets(noOfTickets)
                .seatNumbers(seatNumbers)
                .totalFare(noOfTickets * flight.getCost())
                .build();

        flight.getBookedTickets().put(passengerId,ticket);

        flight.setNoOfTicketsAvailable(flight.getNoOfTicketsAvailable() - noOfTickets);
        flight.setCost(flight.getCost() + noOfTickets * 200);
        flight.getBookedSeatNumber().addAll(seatNumbers);
        flights.put(flightId,flight);
    }

    public void cancelTickets(int flightId,int passengerId){
        Flight flight = flights.remove(flightId);
        if (flight == null){
            System.out.println("Flight not available for flightId: " + flightId);
            return;
        }

        Ticket ticket = flight.getBookedTickets().remove(passengerId);

        if (ticket == null){
            System.out.println("Ticket not found for passengerId: " + passengerId);
            return;
        }

        flight.setNoOfTicketsAvailable(flight.getNoOfTicketsAvailable() + ticket.getNoOfTickets());
        flight.setCost(flight.getCost() - ticket.getNoOfTickets() * 200);
        flight.getBookedSeatNumber().removeAll(ticket.getSeatNumbers());

        flights.put(flightId,flight);
    }

    public void listFlights(){
        for(Flight flight:flights.values()){
            flight.listFlight();
        }
    }

    public void printPassenger(int flightId){
        Optional.ofNullable(flights.get(flightId))
                .ifPresentOrElse(Flight::printPassengers,
                        () ->System.out.println("Flight not available for flightId: " + flightId));
    }
}
