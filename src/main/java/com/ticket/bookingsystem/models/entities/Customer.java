package com.ticket.bookingsystem.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column (name="first_name")
    private String firstName;
    @Column (name="surname")
    private String surname;
    @Column (name="date_of_birth")
    private LocalDate dateOfBirth;
    @Column (name= "email")
    private String email;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "customers_events",
            joinColumns = @JoinColumn(name = "customers_id"),
            inverseJoinColumns = @JoinColumn(name = "events_id"))
    private Set<Event> events;

}
