public class Vendor implements Runnable{

    private final TicketPool ticketPool;
    private final int ticketsToRelease;

    public Vendor (TicketPool ticketPool, int ticketsToRelease) {
        this.ticketPool = ticketPool;
        this.ticketsToRelease = ticketsToRelease;
    }

    @Override
    public void run() {
        for (int i = 0; i < ticketsToRelease; i++) {
            ticketPool.addTickets(1);
            try {
                Thread.sleep(1000); // Simulate ticket release rate
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
