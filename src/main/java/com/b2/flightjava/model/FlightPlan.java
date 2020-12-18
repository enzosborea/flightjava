package com.b2.flightjava.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import java.util.Date;

@Entity(name = "flight_plan")

// nom de la table en bdd
@Table(name = "flight_plan")
public class FlightPlan implements Serializable {

    // champs bdd
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idflight_plan;

    // champs bdd
    @NotBlank
    private Date start_date;

    // champs bdd
    @NotBlank
    private Date end_date;

    // champs bdd
    @NotBlank
    private String start_city;

    // champs bdd
    @NotBlank
    private String end_city;

    // champs bdd
    @NotBlank
    private int price;

    // champs bdd
    @NotBlank
    private int person;

    // relation bdd OneToOne
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plane_idplane", nullable = false)
    private Flight flight;

    //Constructeur
    public FlightPlan(Long idflight_plan, Date start_date, Date end_date, String start_city, String end_city, Integer price, Integer person, Flight flight) {
        this.idflight_plan = idflight_plan;
        this.start_date = start_date;
        this.end_date = end_date;
        this.start_city = start_city;
        this.end_city = end_city;
        this.price = price;
        this.person = person;
        this.flight = flight;
    }

    //Constructeur
    public FlightPlan() {
    }

    //Get et Set

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Long getIdflight_plan() {
        return idflight_plan;
    }

    public void setIdflight_plan(Long idflight_plan) {
        this.idflight_plan = idflight_plan;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getStart_city() {
        return start_city;
    }

    public void setStart_city(String start_city) {
        this.start_city = start_city;
    }

    public String getEnd_city() {
        return end_city;
    }

    public void setEnd_city(String end_city) {
        this.end_city = end_city;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }
}

