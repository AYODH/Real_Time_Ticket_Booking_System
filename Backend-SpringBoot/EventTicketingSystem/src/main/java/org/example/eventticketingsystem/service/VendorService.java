package org.example.eventticketingsystem.service;

import org.example.eventticketingsystem.model.TicketPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VendorService implements Runnable{

    private final TicketPool ticketPool;
    private final int ticketReleaseRate;
    private final int totalTickets;

    public VendorService(TicketPool ticketPool, int ticketReleaseRate, int totalTickets) {
        this.ticketPool = ticketPool;
        this.ticketReleaseRate = ticketReleaseRate;
        this.totalTickets = totalTickets;
    }

    @Override
    public void run() {
        try{
            for(int i = 1; i <= totalTickets; i++) {
                ticketPool.addTicket(i);
                Thread.sleep(1000/ticketReleaseRate);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
