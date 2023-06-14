package com.ticket.bookingsystem.controlers;

import com.ticket.bookingsystem.models.dtos.EventDTO;
import com.ticket.bookingsystem.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/events")
public class EventController {
    EventService eventService;
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@RequestBody @Valid EventDTO eventDTO) {
        return ResponseEntity.ok(eventService.createEvent(eventDTO));
    }
    @GetMapping
    public List<EventDTO> getEvents() {
        return eventService.getEvents();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEventById(@PathVariable long eventid, @RequestBody @Valid EventDTO
            eventDTO) {
        return ResponseEntity.ok(eventService.updateEventById(eventid, eventDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteEventById(@PathVariable long id) {
        eventService.deleteEventById(id);
    }
}

