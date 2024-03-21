package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Person person;
    private Event event;
    private StateParticipation stateParticipation;

    public Participation(){}

    public Participation(Person person, Event event, StateParticipation stateParticipation) {
        this.person = person;
        this.event = event;
        this. stateParticipation = stateParticipation;
    }
}
