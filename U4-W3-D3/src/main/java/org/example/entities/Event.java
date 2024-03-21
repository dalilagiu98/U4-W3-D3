package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Event {

    //ATTRIBUTES LIST:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private LocalDate eventDate;
    private String description;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    private int maxNumberParticipants;
    @ManyToOne
    @JoinColumn
    private Location location;
    @OneToMany(mappedBy = "event" )
    private List<Participation> participation;


    //CONSTRUCTORS:
    public Event() {}
    public Event(String title, LocalDate eventDate, String description, EventType eventType, int maxNumberParticipants, Location location) {
        this.title = title;
        this.eventDate = eventDate;
        this.description = description;
        this.eventType = eventType;
        this.maxNumberParticipants = maxNumberParticipants;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxNumberParticipants=" + maxNumberParticipants +
                '}';
    }
}
