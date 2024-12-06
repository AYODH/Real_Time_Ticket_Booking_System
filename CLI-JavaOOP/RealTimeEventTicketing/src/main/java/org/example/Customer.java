package org.example;

public class Customer implements Runnable{

    private final TicketPool ticketPool;

    private final int retrieveRate;

    public Customer(TicketPool ticketPool, int retrieveRate) {
        this.ticketPool = ticketPool;
        this.retrieveRate = retrieveRate;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                ticketPool.retrieveTicket();
                Thread.sleep(1000/retrieveRate);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
