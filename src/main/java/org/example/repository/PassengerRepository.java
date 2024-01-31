package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entity.Passenger;
import org.example.entity.Trip;

public class PassengerRepository {

    private EntityManager entityManager;

    public PassengerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Passenger passenger) {
        EntityTransaction transaction = entityManager.getTransaction();
        if(!transaction.isActive()) {
            transaction.begin();
        }
        entityManager.persist(passenger);
    }

    public void save2(Passenger passenger, int tripId) {
        EntityTransaction transaction = entityManager.getTransaction();
        if(!transaction.isActive()) {
            transaction.begin();
        }
        Trip trip = entityManager.find(Trip.class, tripId);
        passenger.setTrip(trip);
        entityManager.persist(passenger);

    }
}
