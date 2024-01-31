package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entity.Trip;

public class TripRepository {

    private EntityManager entityManager;

    public TripRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save (Trip trip) {
        EntityTransaction transaction = entityManager.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        entityManager.persist(trip);
    }

    public Trip find(int id) {
        return entityManager.find(Trip.class, id);
    }

}
