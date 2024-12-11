package org.example.sb_test.controller;

import org.example.sb_test.model.TicketConfig;
import org.example.sb_test.service.LogService;
import org.example.sb_test.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TicketingController {

    private final TicketService ticketService;

    public TicketingController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/configure")
    public String configure(@RequestBody TicketConfig config) {
        ticketService.configure(config.getTotalTickets(), config.getMaxTicketCapacity());
        return "Configuration saved.";
    }

    @PostMapping("/start")
    public String startSystem(@RequestParam int releaseRate, @RequestParam int retrievalRate) {
        ticketService.startSystem(releaseRate, retrievalRate);
        return "System started.";
    }

    @PostMapping("/stop")
    public String stopSystem() {
        ticketService.stopSystem();
        return "System stopped.";
    }

    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("currentPoolSize", ticketService.getCurrentPoolSize());
        return status;
    }

    @GetMapping("/logs")
    public List<String> getLogs() {
        return LogService.getRecentLogs(); // Simulate log retrieval (Replace this with actual log storage and retrieval logic)
    }
}
