package real.time.event.ticketing.system.lk;
import java.util.Scanner;

public class RTTicketingSystem {
    private static TicketPool ticketPool;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        configureSystem(input);
        startSystem(input);
    }

    private static void configureSystem(Scanner input) {
        System.out.println("Welcome to Tickets.lk!");
        System.out.println("Enter total number of tickets: ");
        int totalTickets = input.nextInt();

        System.out.println("Enter ticket release rate: ");
        int ticketReleaseRate = input.nextInt();

        System.out.println("Enter customer retrieval rate: ");
        int customerRetrievalRate = input.nextInt();

        System.out.println("Enter maximum ticket capacity: ");
        int maxTicketCapacity = input.nextInt();
    }

    private static void startSystem(Scanner input) {
    }
}