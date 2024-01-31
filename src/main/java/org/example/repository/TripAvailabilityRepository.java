package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.entity.Passenger;
import org.example.entity.Trip;
import org.example.entity.TripAvailability;
import org.hibernate.query.Query;


public class TripAvailabilityRepository {

    private EntityManager entityManager;

    public TripAvailabilityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(TripAvailability tripAvailability) {
        EntityTransaction transaction = entityManager.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        entityManager.persist(tripAvailability);
    }

    public void updateSits(int idTrip) {
        EntityTransaction transaction = entityManager.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        TypedQuery<TripAvailability> query = entityManager.createQuery("select a from TripAvailability a where a.trip.id = :idTrip", TripAvailability.class);
        TripAvailability availability = query.setParameter("idTrip", idTrip).getSingleResult();
        int numberAvailability = availability.getNumberAvailabilitySeats();
        availability.setNumberAvailabilitySeats(numberAvailability - 1);
        transaction.commit();
    }

}