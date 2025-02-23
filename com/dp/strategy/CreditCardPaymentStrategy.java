package com.dp.strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy{

    private final String cardNo;
    private final String name;

    public CreditCardPaymentStrategy(String cardNo, String name) {
        this.cardNo = cardNo;
        this.name = name;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment done by credit card");
    }
}
