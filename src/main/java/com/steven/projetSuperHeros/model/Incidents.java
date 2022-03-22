package com.steven.projetSuperHeros.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "incidents")
public class Incidents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;

    @ManyToMany( mappedBy = "realisableIncidents")
    private List<Hero> heroes;

    public Incidents() {

    }

    public List<Hero> getHeroes() {
        return heroes;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return this.type;
    }
}
