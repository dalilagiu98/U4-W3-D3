package org.example;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventDAO;
import org.example.dao.LocationDAO;
import org.example.dao.ParticipationDAO;
import org.example.dao.PersonDAO;
import org.example.entities.*;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class Application {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        EventDAO eventDAO = new EventDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PersonDAO personDAO = new PersonDAO(em);
        ParticipationDAO participationDAO = new ParticipationDAO(em);
        Random random = new Random();

        //--------------- CREATION LOCATION, PERSON AND EVENT ----------------
        Location location1 = new Location(faker.address().city(), faker.address().cityName());
        Location location2 = new Location(faker.address().city(), faker.address().cityName());

        Person person1 = new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), LocalDate.now(), random.nextInt(0,2) == 0 ? Gender.M : Gender.F );

//        for (int i = 0; i < 20; i++) {
//            personDAO.save(new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), LocalDate.now(), random.nextInt(0,2) == 0 ? Gender.M : Gender.F));
//        }

//        locationDAO.save(location1);
//        locationDAO.save(location2);

//        personDAO.save(person1);

//        for (int i = 0; i < 20; i++) {
//            eventDAO.save(new Event(faker.chuckNorris().fact(), LocalDate.of(random.nextInt(2023, 2025), random.nextInt(1, 13), random.nextInt(1, 29)), faker.lorem().fixedString(50), random.nextInt(1, 3) == 1 ? EventType.PUBLIC : EventType.PRIVATE, random.nextInt(1,10000), random.nextInt(0,2) == 0 ? location1 : location2));
//        }

        //----------------------- EVENT PARTICIPATION --------------------------

        Person person = personDAO.findById(15);
        Event event = eventDAO.getById(72);
        Event event2 = eventDAO.getById(71);

        Participation participation = new Participation(person, event, StateParticipation.TO_BE_CONFIRMED);
//        participationDAO.save(participation);

        Participation participation1 = new Participation(person, event2, StateParticipation.TO_BE_CONFIRMED);
//        participationDAO.save(participation1);

        person.getParticipationList().forEach(System.out::println);


        em.close();
        emf.close();
    }
}
