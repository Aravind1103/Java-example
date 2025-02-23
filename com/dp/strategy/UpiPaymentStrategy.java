package com.dp.strategy;

import java.io.BufferedReader;

public class UpiPaymentStrategy implements PaymentStrategy{

    private final String upi;

    public UpiPaymentStrategy(String upi) {
        this.upi = upi;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment done by UPI");
    }
}
