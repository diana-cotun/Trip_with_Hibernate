package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "trip_availability")
public class TripAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trip_id")
    private Trip trip;
    @Column(name = "number_availability_seats")
    private int numberAvailabilitySeats;

    public TripAvailability() {
    }

    public TripAvailability(Trip trip, int numberAvailabilitySeats) {
        this.trip = trip;
        this.numberAvailabilitySeats = numberAvailabilitySeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public int getNumberAvailabilitySeats() {
        return numberAvailabilitySeats;
    }

    public void setNumberAvailabilitySeats(int numberAvailabilitySeats) {
        this.numberAvailabilitySeats = numberAvailabilitySeats;
    }
}
