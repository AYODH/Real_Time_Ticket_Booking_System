package org.example.realtimeeventticketing.model;

import jakarta.persistence.*;

// Entity table.
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "event")
    private String event;

    //Constructors, getters and setters
    public Ticket() {}

    public Ticket(String vendor, String event) {
        this.vendor = vendor;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
