package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entities.Location;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location){
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(location);
            transaction.commit();
            System.out.println("Location " + location.getName() + " in " + location.getCity() + " saved!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Location findById (long id) {
        return em.find(Location.class, id);
    }

    public void delete(long id){
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Location found = em.find(Location.class, id);
            if(found != null) {
                em.remove(found);
                transaction.commit();
                System.out.println("Location deleted!");
            } else {
                System.out.println("Location not found!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
