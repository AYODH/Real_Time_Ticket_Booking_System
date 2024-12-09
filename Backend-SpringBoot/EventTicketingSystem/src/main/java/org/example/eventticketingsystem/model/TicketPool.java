package org.example.eventticketingsystem.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class TicketPool {

    private static final Logger logger = LoggerFactory.getLogger(TicketPool.class);
    private final ConcurrentLinkedQueue<Integer> tickets = new ConcurrentLinkedQueue<>();
    private final int capacity;

    public TicketPool(int capacity) {
        this.capacity = capacity;
    }

    public TicketPool() {
        this.capacity = 10;
    }

    public synchronized void addTicket(int ticketId) throws InterruptedException {
        while(tickets.size() >= capacity) {
            logger.info("Maximum capacity reached. Vendor is waiting........");
            wait();
        }
        tickets.add(ticketId);
        logger.info("Added ticket: {}" + ticketId);
        notifyAll();
    }

    public synchronized int retrieveTicket() throws InterruptedException {
        while(tickets.isEmpty()) {
            logger.info("No tickets available. Customer is waiting........");
            wait();
        }
        int ticket = tickets.poll();
        logger.info("Retrieved ticket: {}" + ticket);
        notifyAll();
        return ticket;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentSize() {
        return tickets.size();
    }
}
