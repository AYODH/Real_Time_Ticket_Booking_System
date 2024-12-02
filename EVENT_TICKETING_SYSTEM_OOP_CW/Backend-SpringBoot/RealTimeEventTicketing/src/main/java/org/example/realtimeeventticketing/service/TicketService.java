package org.example.realtimeeventticketing.service;

import org.example.realtimeeventticketing.model.Configuration;
import org.example.realtimeeventticketing.model.Ticket;
import org.example.realtimeeventticketing.model.TicketPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketPool ticketPool;

    @Autowired
    private Configuration configuration;

    public void releaseTickets(){
        List<Ticket> newTickets = new ArrayList<>();
        for (int i = 0; i < configuration.getTicketReleaseRate();){
            newTickets.add(new Ticket("Vendor1","Event1"));
        }
        ticketPool.addTicket(newTickets);
    }

    public Ticket purchaseTicket(){
        return ticketPool.removeTicket();
    }

    public int availableTickets(){
        return ticketPool.getAvailableTickets();
    }
}
