package org.example.sb_test.service;

import org.example.sb_test.model.TicketPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class TicketService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private static final Logger logger = LoggerFactory.getLogger(TicketService.class);
    private final TicketPool ticketPool = new TicketPool();
    private ScheduledExecutorService executorService;
    private int totalTickets;
    private int ticketsProduced = 0;
    private int maxTicketCapacity;


    public void configure(int totalTickets, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public void startSystem(int releaseRate, int retrievalRate) {
        executorService = Executors.newScheduledThreadPool(2);

        Runnable producer = () -> {
            synchronized (ticketPool) {
                if (ticketsProduced < totalTickets && ticketPool.size() < maxTicketCapacity) {
                    ticketPool.addTicket(++ticketsProduced);
                    logger.info("Ticket {} produced. Pool size: {}", ticketsProduced, ticketPool.size());
                } else if (ticketPool.size() >= maxTicketCapacity) {
                    logger.warn("Max capacity reached.");
                }
            }
        };
        Runnable consumer = () -> {
            synchronized (ticketPool) {
                Integer ticket = ticketPool.retrieveTicket();
                if (ticket != null) {
                    logger.info("Ticket {} consumed. Pool size: {}", ticket, ticketPool.size());
                } else {
                    logger.warn("No tickets available to consume.");
                }
            }
        };

        executorService.scheduleAtFixedRate(producer, 0, 1000 / releaseRate, TimeUnit.MILLISECONDS);
        executorService.scheduleAtFixedRate(consumer, 0, 1000 / retrievalRate, TimeUnit.MILLISECONDS);
    }

    public void stopSystem() {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdownNow();
            logger.info("System stopped.");
        }
    }

    public int getCurrentPoolSize() {
        return ticketPool.size();
    }

    // Update broadcastUpdate in TicketService
    private void broadcastUpdate(String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = timestamp + " - " + message;
        messagingTemplate.convertAndSend("/topic/tickets", logMessage);
    }

    private void produceTickets(int ticketReleaseRate) {
        broadcastUpdate("Produced ticket #" + ticketsProduced); // Producer logic
    }

    private void consumeTickets(int retrievalRate) {
        broadcastUpdate("Consumed a ticket");  // Consumer logic
    }
}
