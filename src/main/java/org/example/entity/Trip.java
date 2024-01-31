package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String destination;
    @Column(name = "start_date")
    private String startDate;

    @OneToOne(mappedBy = "trip", cascade = CascadeType.ALL)
    private TripAvailability tripAvailability;

    public Trip() {
    }

    public Trip(String destination, String startDate) {
        this.destination = destination;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
