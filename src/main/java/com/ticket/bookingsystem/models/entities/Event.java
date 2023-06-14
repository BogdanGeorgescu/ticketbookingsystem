package com.ticket.bookingsystem.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "Events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "name_of_event")
    private String nameOfEvent;
    @Column (name= "price_in_euros")
    private double priceInEuros;
    @Column (name= "first_date_of_event")
    private LocalDate firstDateOfEvent;
    @Column  (name= "final_date_of_event")
    private LocalDate finalDateOfEvent;
    @Column  (name= "location")
    private String location;
    @Column   (name = "headliner")
    private String Headliner;
    @Column (name= "genre_of_music")
    private String genreOfMusic;
    @ManyToMany(mappedBy = "events")
    private Set<Customer> customers;
}
