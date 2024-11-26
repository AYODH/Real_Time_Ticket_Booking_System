import java.io.*;
import java.util.Scanner;

public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    //Getters
    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    @Override
    public String toString() {
        return "Configuration:-" +
                "\nTotal Number of Tickets = " + totalTickets +
                "\nTicket Release Rate = " + ticketReleaseRate +
                "\nCustomer Retrieval Rate = " + customerRetrievalRate +
                "\nMaximum Ticket Capacity = " + maxTicketCapacity;
    }

    //save the Configuration object to a file.
    public void saveConfiguration(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Total Number of Tickets = " + totalTickets + "\n");
            writer.newLine();
            writer.write("Ticket Release Rate=" + ticketReleaseRate + "\n");
            writer.newLine();
            writer.write("Customer Retrieval Rate=" + customerRetrievalRate + "\n");
            writer.newLine();
            writer.write("Maximum Ticket Capacity=" + maxTicketCapacity + "\n");
            System.out.println("Configuration saved successfully");
        } catch (IOException e) {
            System.out.println("Error while saving configuration: " + e.getMessage());
        }
    }

    //load the Configuration object from a file.
    public static Configuration loadConfiguration(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int totalTickets = Integer.parseInt(reader.readLine());
            int ticketReleaseRate = Integer.parseInt(reader.readLine());
            int customerRetrievalRate = Integer.parseInt(reader.readLine());
            int maxTicketCapacity = Integer.parseInt(reader.readLine());

            System.out.println("Configuration loaded successfully");
            return new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error while loading configuration: " + e.getMessage());
            return null;
        }
    }

}
