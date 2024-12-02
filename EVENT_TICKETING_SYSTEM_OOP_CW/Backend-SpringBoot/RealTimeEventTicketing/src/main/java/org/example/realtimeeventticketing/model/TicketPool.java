package org.example.realtimeeventticketing.model;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

@Component
public class TicketPool {

    private final List<Ticket> tickets = Collections.synchronizedList(new Vector<>());

    public synchronized void addTicket(List<Ticket> newTickets) {
        tickets.addAll(newTickets);
        System.out.println("Ticket added: " + newTickets);
    }

    public synchronized Ticket removeTicket() {
        if (tickets.isEmpty()) {
            return null;
        }
        return tickets.remove(0);
    }

    public synchronized int getAvailableTickets() {
        return tickets.size();
    }
}
