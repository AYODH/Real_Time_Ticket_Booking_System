public class Customer implements Runnable {
    private TicketPool ticketPool;
    private int ticketsToPurchase;

    public Customer(TicketPool ticketPool, int ticketsToPurchase) {
        this.ticketPool = ticketPool;
        this.ticketsToPurchase = ticketsToPurchase;
    }

    public void run() {

    }
}
