package org.example.eventticketingsystem.controller;

import org.example.eventticketingsystem.model.TicketPool;
import org.example.eventticketingsystem.service.CustomerService;
import org.example.eventticketingsystem.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketPool ticketPool;
    private Thread vendorThread;
    private Thread customerThread;

    @Autowired
    public TicketController(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    @PostMapping("/start")
    public ResponseEntity<String> startSystem(@RequestParam int totalTickets, @RequestParam int ticketReleaseRate, @RequestParam int customerRetrieveRate) {
        if(vendorThread != null && vendorThread.isAlive() || customerThread != null && customerThread.isAlive()) {
            return ResponseEntity.badRequest().body("System is already running");
        }

        VendorService vendor = new VendorService(ticketPool, ticketReleaseRate, totalTickets);
        CustomerService customer = new CustomerService(ticketPool, customerRetrieveRate);

        vendorThread = new Thread(vendor);
        customerThread = new Thread(customer);

        vendorThread.start();
        customerThread.start();

        return ResponseEntity.ok("System started successfully");
    }

    @PostMapping("/stop")
    public ResponseEntity<String> stopSystem() {
        if (vendorThread != null && vendorThread.isAlive()) {
            vendorThread.interrupt();
        }
        if (customerThread != null && customerThread.isAlive()) {
            customerThread.interrupt();
        }

        return ResponseEntity.ok("System stopped successfully");
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus(){
        String status = "Current tickets: " + ticketPool.getCurrentSize() + " / " + ticketPool.getCapacity();
        return ResponseEntity.ok(status);
    }
}
