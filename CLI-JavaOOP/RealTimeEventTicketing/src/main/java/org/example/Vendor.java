package org.example;

public class Vendor implements Runnable{

    private final TicketPool ticketPool;

    private final int ticketReleaseRate;

    private final int totalTickets;

    public Vendor(TicketPool ticketPool, int ticketReleaseRate, int totalTickets) {
        this.ticketPool = ticketPool;
        this.ticketReleaseRate = ticketReleaseRate;
        this.totalTickets = totalTickets;
    }

    @Override
    public void run() {
        for(int i = 1; i <= totalTickets; i++) {
            try {
                ticketPool.addTicket(i);
                Thread.sleep(1000/ticketReleaseRate);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
