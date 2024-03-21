package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entities.Participation;

public class ParticipationDAO {
    private final EntityManager em;

    public ParticipationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Participation participation){
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(participation);
            transaction.commit();
            System.out.println("Participation for the event " + participation.getEvent() + " for the person: " + participation.getPerson().getName() + " " + participation.getPerson().getSurname());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Participation findById(long id) {
        return em.find(Participation.class, id);
    }

    public void delete(long id) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Participation found = em.find(Participation.class, id);
            if(found != null) {
                em.remove(found);
                transaction.commit();
                System.out.println("Participation deleted!");
            } else {
                System.out.println("Participation not found!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
