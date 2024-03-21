package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entities.Person;

public class PersonDAO {
    private final EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Person person) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(person);
            transaction.commit();
            System.out.println("Person " + person.getName() + " " + person.getSurname() + " saved!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Person findById (long id) {
        return em.find(Person.class, id);
    }

    public void delete(long id) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Person found = em.find(Person.class, id);
            if(found != null) {
                em.remove(found);
                transaction.commit();
                System.out.println("Person deleted!");
            } else {
                System.out.println("Person not found!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
