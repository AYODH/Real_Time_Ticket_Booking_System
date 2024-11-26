public class Main {
    public static void main(String[] args) {
        // Load configuration.
        Configuration configuration = Configuration.loadConfiguration("configuration.txt");
        if (configuration == null) {
            // Calling the method to prompt for configuration.
            RTTicketingSystem ticketingSystem = new RTTicketingSystem();
            configuration = ticketingSystem.getConfiguration();
            configuration.saveConfiguration("configuration.txt");
        }

        //Initial the ticket pool with the total number of tickets.
        TicketPool ticketPool = new TicketPool(configuration.getTotalTickets());

        //Display initial available ticktes.
        System.out.println("Initial available tickets: " + ticketPool.getAvailableTickets());

        // Vendor thread to release tickets.
        Vendor vendor = new Vendor(ticketPool, configuration.getTicketReleaseRate());
        Thread vendorThread = new Thread(vendor);
        vendorThread.start();

        // Customer thread to retrieve tickets.
        Customer customer = new Customer(ticketPool);
        Thread customerThread = new Thread(customer);
        customerThread.start();
    }
}
