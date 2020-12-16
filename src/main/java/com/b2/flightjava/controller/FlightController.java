package com.b2.flightjava.controller;

import com.b2.flightjava.model.Flight;
import com.b2.flightjava.repository.FlightRepository;
import com.b2.flightjava.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightController {
    @Autowired
    FlightRepository flightRepository;

    // Get All Planes
    @GetMapping("/flights")
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Create a new plane
    @PostMapping("/flights")
    public Flight createNote(@Valid @RequestBody Flight flight) {
        return flightRepository.save(flight);
    }

    // Get a single plane
    @GetMapping("/flights/{id}")
    public Flight getFlightById(@PathVariable(value = "id") Integer flightId) {
        return flightRepository.findById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("Flight", "id", flightId));
    }

    // Update a plane
    @PutMapping("/flights/{id}")
    public Flight updateFlight(@PathVariable(value = "id") Integer flightId,
                           @Valid @RequestBody Flight flightDetails) {

        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("Flight", "id", flightId));

        flight.setName(flightDetails.getName());
        flight.setRef(flightDetails.getRef());
        flight.setCompanie(flightDetails.getCompanie());


        Flight updatedFlight = flightRepository.save(flight);
        return updatedFlight;
    }

    // Delete a plane
    @DeleteMapping("/flights/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable(value = "id") Integer flightId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("Flight", "id", flightId));

        flightRepository.delete(flight);

        return ResponseEntity.ok().build();
    }


}
