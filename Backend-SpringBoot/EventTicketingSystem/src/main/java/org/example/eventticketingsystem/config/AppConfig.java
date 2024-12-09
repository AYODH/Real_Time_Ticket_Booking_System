package org.example.eventticketingsystem.config;

import org.example.eventticketingsystem.model.TicketPool;
import org.example.eventticketingsystem.service.CustomerService;
import org.example.eventticketingsystem.service.VendorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AppConfig {

    //Bean to initialize the TicketPool with a predefined capacity.
    @Bean
    public TicketPool ticketPool() {
        int capacity = 5;
        return new TicketPool(capacity);
    }

    //Executor for running vendor and customer threads.
    @Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2); // Two threads for Vendor and Customer
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("TicketingSystem-");
        executor.initialize();
        return executor;
    }

    //Vendor Service Bean.
    @Bean
    public VendorService vendorService(TicketPool ticketPool) {
        return new VendorService(ticketPool, 2, 10);
    }

    //Customer Service Bean.
    @Bean
    public CustomerService customerService(TicketPool ticketPool) {
        return new CustomerService(ticketPool, 1);
    }

}
