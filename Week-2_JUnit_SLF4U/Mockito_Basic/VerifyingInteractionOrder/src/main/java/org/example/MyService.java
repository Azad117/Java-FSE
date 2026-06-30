package org.example;

public class MyService {

    private PaymentService service;

    public  MyService(PaymentService service) {
        this.service = service;
    }

    public void runProcess()
    {
        service.login();
        service.paymentProcess();
        service.logout();
    }
}
