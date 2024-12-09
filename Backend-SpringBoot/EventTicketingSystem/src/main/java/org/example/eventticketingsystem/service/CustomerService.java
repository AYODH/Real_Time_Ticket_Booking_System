package org.example.eventticketingsystem.service;

import org.example.eventticketingsystem.model.TicketPool;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements Runnable{

    private final TicketPool ticketPool;

    private final int customerRetrieveRate;

    public CustomerService(TicketPool ticketPool, int customerRetrieveRate) {
        this.ticketPool = ticketPool;
        this.customerRetrieveRate = customerRetrieveRate;
    }

    @Override
    public void run() {
        try {
            while (true) {
                ticketPool.retrieveTicket();
                Thread.sleep(1000 / customerRetrieveRate);
            }
        }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
        }
    }
}
