package com.b2.flightjava.repository;

import com.b2.flightjava.model.FlightPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightPlanRepository extends JpaRepository<FlightPlan, Long> {
    @Query("SELECT f FROM flight_plan f WHERE CONCAT(f.start_city, ' ', f.end_city, ' ', f.flight.companie) LIKE %?1%")
    public List<FlightPlan> search(String key);

    @Query("SELECT f FROM flight_plan f WHERE CONCAT(f.start_date, ' ', f.end_date) LIKE %?1%")
    public List<FlightPlan> searchDate(String date);

}

