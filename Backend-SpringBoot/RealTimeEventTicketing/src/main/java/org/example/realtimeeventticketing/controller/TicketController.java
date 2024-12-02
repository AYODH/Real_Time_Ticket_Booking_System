package org.example.realtimeeventticketing.controller;

import org.example.realtimeeventticketing.model.Configuration;
import org.example.realtimeeventticketing.model.Ticket;
import org.example.realtimeeventticketing.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private Configuration configuration;

    public String configureSystem(@RequestBody Configuration config){
        configuration.setTotalTickets(config.getTotalTickets());
        configuration.setTicketReleaseRate(config.getTicketReleaseRate());
        configuration.setCustomerRetrievalRate(config.getCustomerRetrievalRate());
        configuration.setMaxTicketCapacity(config.getMaxTicketCapacity());
        return "Configuration successfully configured";
    }

    @GetMapping("/release")
    public String releaseTickets(){
        ticketService.releaseTickets();
        return "Tickets successfully released";
    }

    @GetMapping("/purchase")
    public Ticket purchaseTicket(){
        return ticketService.purchaseTicket();
    }

    @GetMapping("/available")
    public int availableTickets(){
        return ticketService.availableTickets();
    }

}

