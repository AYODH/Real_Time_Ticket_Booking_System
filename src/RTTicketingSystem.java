import java.util.Scanner;

public class RTTicketingSystem {
    private Scanner input;

    public RTTicketingSystem() {
        input = new Scanner(System.in);
    }

    //ask the user for parameter to configure.
    public Configuration getConfiguration() {
            System.out.println("Welcome to the Real-Time Event Ticketing System.");

            int totalTickets = promptForInteger("Enter total number of tickets: ");
            int ticketReleaseRate = promptForInteger("Enter ticket release rate (tickets per second): ");
            int customerRetrievalRate = promptForInteger("Enter customer retrieval rate (tickets per second): ");
            int maxTicketCapacity = promptForInteger("Enter max ticket capacity: ");

            return new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
    }

    private int promptForInteger(String message) {
        int value = -1;
        while (value < 0) {
            System.out.println(message);
            try {
                value = Integer.parseInt(input.nextLine());
                if (value < 0) {
                    System.out.println("Please enter a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid user entered.");
            }
        }
        return value;
    }

}