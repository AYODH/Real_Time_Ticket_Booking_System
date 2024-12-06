package org.example;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Configuration {

    private int totalTickets;

    private int ticketReleaseRate;

    private int customerRetrievalRate;

    private int maxTicketCapacity;

    //Getters and Setters
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

    //Save configuration to a JSON file
    public void saveToFile(String filePath) {
        try(FileWriter writer = new FileWriter(filePath)){
            Gson gson = new Gson();
            gson.toJson(this, writer);
        } catch (IOException e){
            System.out.println("Failed to save configuration: " + e.getMessage());
        }
    }

    //Load configuration from a JSON file
    public static Configuration loadFromFile(String filePath) {
        try(FileReader reader = new FileReader(filePath)){
            Gson gson = new Gson();
            return gson.fromJson(reader, Configuration.class);
        } catch (IOException e){
            System.out.println("Failed to load configuration: " + e.getMessage());
            return null;
        }
    }
}
