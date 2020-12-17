package com.b2.flightjava.service;


import com.b2.flightjava.model.FlightPlan;
import com.b2.flightjava.repository.FlightPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightPlanService {
    @Autowired
    private FlightPlanRepository repo;

    public List<FlightPlan> listAll(String key) {
        if (key != null) {
            return repo.search(key);
        }
        return  repo.findAll();
    }

    public List<FlightPlan> listDate(String date) {
        if (date != null) {
            return repo.searchDate(date);
        }
        return  repo.findAll();
    }


    public FlightPlan get(Long idflight_plan) {
        return repo.findById(idflight_plan).get();
    }
}