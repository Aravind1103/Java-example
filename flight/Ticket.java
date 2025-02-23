package com.example.demo.flight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    int flightId;

    int passengerId;

    int noOfTickets;

    int totalFare;

    List<Integer> seatNumbers;
}
