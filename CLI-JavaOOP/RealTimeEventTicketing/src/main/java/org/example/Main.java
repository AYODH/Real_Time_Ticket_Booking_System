package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        Configuration config = new Configuration();

        while (running){
            System.out.println("********************************************");
            System.out.println("Welcome to Real-Time Event Ticketing System.");
            System.out.println("********************************************");
            System.out.print("Load configuration from file? (y/n): ");
            String loadInput = scanner.nextLine().trim().toLowerCase();
            if (loadInput.equals("y")){
                config = Configuration.loadFromFile("config.json");
                if(config == null) continue;
            } else {
                config = promptConfiguration(scanner);
                config.saveToFile("config.json");
            }

            TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());
            Thread vendor = new Thread(new Vendor(ticketPool, config.getTicketReleaseRate(), config.getTotalTickets()));
            Thread customer = new Thread(new Customer(ticketPool, config.getCustomerRetrievalRate()));

            vendor.start();
            customer.start();

            System.out.println("Press Enter to stop the system...");
            scanner.nextLine();

            vendor.interrupt();
            customer.interrupt();

            try {
                vendor.join();
                customer.join();
            } catch (InterruptedException e) {
                LoggerUtil.logError("Thread interrupted", e);
            }

            System.out.println("System completed. Resart? (y/n): ");
            running = scanner.nextLine().trim().toLowerCase().equals("y");
        }

        scanner.close();
        System.out.println("System terminated.");
    }

    private static Configuration promptConfiguration(Scanner scanner){
        Configuration config = new Configuration();
        System.out.print("Enter total tickets: ");
        config.setTotalTickets(validateInput(scanner));
        System.out.print("Enter ticket release rate: ");
        config.setTicketReleaseRate(validateInput(scanner));
        System.out.print("Enter customer retrieval rate: ");
        config.setCustomerRetrievalRate(validateInput(scanner));
        System.out.print("Enter max ticket capacity: ");
        config.setMaxTicketCapacity(validateInput(scanner));
        return config;
    }

    private static int validateInput(Scanner scanner){
        while(true){
            try{
                int input = Integer.parseInt(scanner.nextLine());
                if(input > 0) return input;
                System.out.println("Input must be greater than 0.");
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}