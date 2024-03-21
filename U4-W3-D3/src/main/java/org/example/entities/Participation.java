package org.example.entities;

import jakarta.persistence.*;

@Entity
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn
    private Person person;
    @ManyToOne
    @JoinColumn
    private Event event;
    private StateParticipation stateParticipation;

    public Participation(){}

    public Participation(Person person, Event event, StateParticipation stateParticipation) {
        this.person = person;
        this.event = event;
        this. stateParticipation = stateParticipation;
    }
}
