package com.ticket.bookingsystem.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.bookingsystem.exceptions.EventNotFoundException;
import com.ticket.bookingsystem.models.dtos.EventDTO;
import com.ticket.bookingsystem.models.entities.Event;
import com.ticket.bookingsystem.repositories.EventRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

    private final ObjectMapper objectMapper;
    private final EventRepository eventRepository;

    public EventServiceImpl(ObjectMapper objectMapper, EventRepository eventRepository) {
        this.objectMapper = objectMapper;
        this.eventRepository = eventRepository;
    }
    @Transactional
    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = objectMapper.convertValue(eventDTO, Event.class);
        Event savedEvent = eventRepository.save(event);
        log.info("Event" + savedEvent.getNameOfEvent() + "was created");
        return objectMapper.convertValue(savedEvent, EventDTO.class);
    }
    @Override
    public EventDTO updateEventById(long id, EventDTO eventDTO) {
        Event eventFound = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        eventFound.setFirstDateOfEvent(eventDTO.getFirstDateOfEvent());
        eventFound.setFinalDateOfEvent(eventDTO.getFinalDateOfEvent());
        eventFound.setNameOfEvent(eventDTO.getNameOfEvent());
        eventFound.setPriceInEuros(eventDTO.getPriceInEuros());
        eventFound.setLocation(eventDTO.getLocation());
        eventFound.setGenreOfMusic((eventDTO.getGenreOfMusic()));
        eventFound.setHeadliner((eventDTO.getHeadliner()));
        Event eventSaved = eventRepository.save(eventFound);
        log.info("Event " + id + "was updated successfully");
        return objectMapper.convertValue(eventSaved, EventDTO.class);
    }
    @Override
    public void deleteEventById(long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            log.info("Event with id " + id + " was deleted successfully.");
        } else {
            throw new EventNotFoundException("Event not found.");
        }
    }
    @Override
    public List<EventDTO> getEvents() {
        List<Event> eventsFound = eventRepository.findAll();
        List<EventDTO> eventsFoundDTO = new ArrayList<>();
        eventsFound.forEach(event -> eventsFoundDTO.add(objectMapper.convertValue(eventsFound, EventDTO.class)));
        return eventsFoundDTO;
    }

}