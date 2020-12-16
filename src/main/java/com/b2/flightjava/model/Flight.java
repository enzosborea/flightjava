package com.b2.flightjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Entity
@Table(name = "plane")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)


public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idplane;

    @NotBlank
    private String name;

    @NotBlank
    private int ref;

    @NotBlank
    private String companie;

    public Flight(Integer idplane, String name, Integer ref, String companie) {
        this.idplane = idplane;
        this.name = name;
        this.ref = ref;
        this.companie = companie;
    }

    public Flight() {

    }

    public Integer getId() {
        return idplane;
    }

    public void setId(Integer idplane) {
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
