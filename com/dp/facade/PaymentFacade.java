package com.dp.facade;


/**
 * Facade pattern provide a simple inteface to libray or framework or any other complex set of classes.
 * It encapsulates the complexities of subsystem and provides simpler easy to use interface. it doesn't reduce the
 * complexities. it only hides it from client. By providing simpler interface no of classes that client needs to deal
 * with is reduced
 */
public class PaymentFacade {
    private final PaymentGateway paymentGateway;
    private final NotificationService notificationService;

    public PaymentFacade(PaymentGateway paymentGateway, NotificationService notificationService) {
        this.paymentGateway = paymentGateway;
        this.notificationService = notificationService;
    }

    public void makePayment() {
        paymentGateway.processPayment();
        notificationService.sendNotification();
    }
}
