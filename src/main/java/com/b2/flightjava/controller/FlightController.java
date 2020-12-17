package com.b2.flightjava.controller;

import com.b2.flightjava.model.FlightPlan;
import com.b2.flightjava.repository.FlightPlanRepository;

import com.b2.flightjava.service.FlightPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class FlightController {
    @Autowired
    FlightPlanRepository flightPlanRepository;

    @Autowired
    private FlightPlanService service;

    @GetMapping("/")
    public String home(Model model, @Param("key") String key) {
        List<FlightPlan> flightPlansKey = service.listAll(key);
        model.addAttribute("listFlight", flightPlansKey);
        model.addAttribute("key", key);

        return "indexx";
    }


    // Create a new plane
    @PostMapping("/flights")
    public FlightPlan createNote(@Valid @RequestBody FlightPlan flightPlan) {
        return flightPlanRepository.save(flightPlan);
    }

    // Get a single plane
    @GetMapping("/{id}")
    public Optional<FlightPlan> getFlightById(@PathVariable(value = "id") Long flightPlanId) {
        return flightPlanRepository.findById(flightPlanId);
    }
}
