package com.example.demo.flight;

import lombok.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {

    int flightId;

    int cost;

    int noOfTicketsAvailable;

    Map<Integer,Ticket> bookedTickets;

    List<Integer> bookedSeatNumber;

    int rows;

    int columns;

    public void printLayout(){
        int k=0;
        for(int i=0;i< rows;i++){
            for(int j=0;j<columns;j++){
                k++;
                if(bookedSeatNumber.contains(k)){
                    System.out.print(k+"B  ");
                    continue;
                }
                System.out.print(k+"A  ");
            }
            System.out.println();
            System.out.println();
        }
    }
    public void listFlight(){
        System.out.println(String.format("Flight Id: %s  ---- Current fair: %s  ---- Number Tickets Available: %s",
                flightId,cost,noOfTicketsAvailable));
    }

    public void printPassengers(){
        if(bookedTickets.size() == 0){
            System.out.println("No Tickets were booked in flight: " + flightId);
        }
        for(Ticket ticket: bookedTickets.values()){
            System.out.println(String.format("Passenger Id: %s ---- Number Tickets: %s",
                    ticket.getPassengerId(),ticket.getNoOfTickets()));
        }
    }
}
