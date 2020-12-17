package com.b2.flightjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "plane")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)


public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idplane;

    @NotBlank
    private String name;

    @NotBlank
    private int ref;

    @NotBlank
    private String companie;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "flight")
    private FlightPlan flightPlan;

    public Flight(Long idplane, String name, Integer ref, String companie) {
        this.idplane = idplane;
        this.name = name;
        this.ref = ref;
        this.companie = companie;
    }

    public Flight() {

    }

    public Long getId() {
        return idplane;
    }

    public void setId(Long idplane) {
        this.idplane = idplane;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRef() {
        return ref;
    }

    public void setRef(Integer ref) {
        this.ref = ref;
    }

    public String getCompanie() {
        return companie;
    }

    public void setCompanie(String companie) {
        this.companie = companie;
    }
}
