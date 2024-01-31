package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.Passenger;
import org.example.repository.PassengerRepository;
import org.example.repository.TripAvailabilityRepository;
import org.example.repository.TripRepository;
import org.example.utils.HibernateUtils;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();

        TripRepository tripRepository = new TripRepository(entityManager);
        TripAvailabilityRepository availabilityRepository = new TripAvailabilityRepository(entityManager);
        PassengerRepository passengerRepository = new PassengerRepository(entityManager);

        Passenger passenger = new Passenger("Andrei", tripRepository.find(4));

        passengerRepository.save2(passenger,4);
        availabilityRepository.updateSeats(4);

        entityManager.close();


//      creezi pasager nou si il setezi pe un trip existent
//      scadem locurile odata ce introducem pasagerul in DB
//
    }
}