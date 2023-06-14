package com.ticket.bookingsystem.models.dtos;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EventDTO {

    private String nameOfEvent;
    private double priceInEuros;
    private LocalDate firstDateOfEvent;
    private LocalDate finalDateOfEvent;
    private String location;
    private String headliner;
    private String genreOfMusic;
}

