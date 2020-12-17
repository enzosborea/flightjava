package com.b2.flightjava.repository;

import com.b2.flightjava.model.FlightPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightPlanRepository extends JpaRepository<FlightPlan, Long> {
}
