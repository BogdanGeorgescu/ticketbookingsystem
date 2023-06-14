package com.ticket.bookingsystem.services;


import com.ticket.bookingsystem.models.dtos.EventDTO;

import java.util.List;

public interface EventService {
    EventDTO createEvent(EventDTO eventDTO);

    EventDTO updateEventById(long id, EventDTO eventDTO);

    void deleteEventById(long id);

    List<EventDTO> getEvents();
}




