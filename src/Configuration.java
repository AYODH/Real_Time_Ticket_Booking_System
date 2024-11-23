import java.io.*;
import java.util.Scanner;

public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    //save the Configuration object to a file.
    public void saveConfiguration(String filename) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("totalTickets=" + totalTickets + "\n");
            writer.newLine();
            writer.write("ticketReleaseRate=" + ticketReleaseRate + "\n");
            writer.newLine();
            writer.write("customerRetrievalRate=" + customerRetrievalRate + "\n");
            writer.newLine();
            writer.write("maxTicketCapacity=" + maxTicketCapacity + "\n");
            writer.newLine();
        }catch(IOException e){
            System.out.println("Error while saving configuration: " + e.getMessage());
        }
    }

    //load the Configuration object from a file.
    public static Configuration loadConfiguration(String filename) {
        Configuration config = new Configuration();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            config.setTotalTickets(Integer.parseInt(reader.readLine().split("=")[1]));
            config.setTicketReleaseRate(Integer.parseInt(reader.readLine().split("=")[1]));
            config.setCustomerRetrievalRate(Integer.parseInt(reader.readLine().split("=")[1]));
            config.setMaxTicketCapacity(Integer.parseInt(reader.readLine().split("=")[1]));
        }catch(IOException | NumberFormatException e){
            System.out.println("Error while loading configuration: " + e.getMessage());
        }
        return config;
    }
}
