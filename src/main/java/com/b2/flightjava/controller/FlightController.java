package com.b2.flightjava.controller;

import com.b2.flightjava.model.FlightPlan;
import com.b2.flightjava.repository.FlightPlanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class FlightController {
    @Autowired
    FlightPlanRepository flightPlanRepository;


    @GetMapping("/index")
    public String listFlight(Model model) {
        List<FlightPlan> flightPlans = flightPlanRepository.findAll();
        model.addAttribute("listFlight", flightPlans);

        return "indexx";
    }

    // Get All Planes
    @GetMapping("/flights")
    public List<FlightPlan> getAllFlights() {
        return flightPlanRepository.findAll();
    }

    // Create a new plane
    @PostMapping("/flights")
    public FlightPlan createNote(@Valid @RequestBody FlightPlan flightPlan) {
        return flightPlanRepository.save(flightPlan);
    }

    // Get a single plane
    @GetMapping("/flights/{id}")
    public Optional<FlightPlan> getFlightById(@PathVariable(value = "id") Long flightPlanId) {
        return flightPlanRepository.findById(flightPlanId);
    }



}
