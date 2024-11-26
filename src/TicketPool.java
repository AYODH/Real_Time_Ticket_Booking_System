import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketPool {
    private int availableTickets;
    private final Lock lock = new ReentrantLock();

    public TicketPool(int initialTickets) {
        this.availableTickets = initialTickets;
    }

    public void addTickets(int tickets) {
        lock.lock();
        try {
            availableTickets += tickets;
            System.out.println(tickets + " tickets added. Total tickets: " + availableTickets);
        } finally {
            lock.unlock();
        }
    }

    public void removeTickets(){
        lock.lock();
        try {
            if (availableTickets > 0) {
                availableTickets--;
                System.out.println("1 ticket purchased. Total tickets: " + availableTickets);
            } else {
                System.out.println("No tickets available for purchase.");
            }
        } finally {
            lock.unlock();
        }
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}
