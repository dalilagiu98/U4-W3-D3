package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate localDate;
    private Gender gender;
    private List<Participation> participationList;

    public Person(){}

    public Person(String name, String surname, String email, LocalDate localDate, Gender gender, List<Participation> participationList) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.localDate = localDate;
        this.gender = gender;
        this.participationList = participationList;
    }

}
