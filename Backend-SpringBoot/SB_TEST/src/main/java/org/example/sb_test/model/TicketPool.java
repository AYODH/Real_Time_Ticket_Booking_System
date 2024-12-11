package org.example.sb_test.model;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private final Queue<Integer> tickets = new LinkedList<>();

    public synchronized void addTicket(int ticket) {
        tickets.add(ticket);
    }

    public synchronized Integer retrieveTicket() {
        return tickets.poll();
    }

    public synchronized int size() {
        return tickets.size();
    }
}
