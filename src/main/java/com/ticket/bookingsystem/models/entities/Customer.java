package com.ticket.bookingsystem.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

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
    private Date dateOfBirth;

    @Column (name= "email")
    private String email;



}
