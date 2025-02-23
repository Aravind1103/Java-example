package com.dp.strategy;

import java.util.Collections;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void initiatePayment(double amount){
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method.");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}
