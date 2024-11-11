package real.time.event.ticketing.system.lk;

public class Vendor implements Runnable{

    private TicketPool ticketPool;

    public Vendor (TicketPool ticketPool){
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {}
}
