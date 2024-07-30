package com.mintfrost.buns.api.persistance;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    protected Company() {
    }

    public Company(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Column
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private Set<Bakery> bakery;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
