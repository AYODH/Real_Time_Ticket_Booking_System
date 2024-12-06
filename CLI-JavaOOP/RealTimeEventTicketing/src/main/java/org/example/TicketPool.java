package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private final int capacity;

    private final Queue<Integer> tickets = new LinkedList<>();

    public TicketPool(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void addTicket(int ticketId) throws InterruptedException {
        while(tickets.size() >= capacity) {
            LoggerUtil.logInfo("Maximum capacity reached. Vendor is waiting........");
            System.out.println("Maximum capacity reached. Vendor is waiting........");
            wait();
        }
        tickets.add(ticketId);
        LoggerUtil.logInfo("Added ticket: " + ticketId);
        System.out.println("Added ticket: " + ticketId);
        notifyAll();
    }

    public synchronized int retrieveTicket() throws InterruptedException {
        while(tickets.isEmpty()) {
            LoggerUtil.logInfo("No tickets available. Customer is waiting........");
            System.out.println("No tickets available. Customer is waiting........");
            wait();
        }
        int ticket = tickets.poll();
        LoggerUtil.logInfo("Retrieved ticket: " + ticket);
        System.out.println("Retrieved ticket: " + ticket);
        notifyAll();
        return ticket;
    }
}
