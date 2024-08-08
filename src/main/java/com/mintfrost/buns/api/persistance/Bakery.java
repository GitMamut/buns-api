package com.mintfrost.buns.api.persistance;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Bakery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY strategy lets DB take care of providing ID sequence
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    private Company company;

    protected Bakery() {
    }

    public Bakery(Long id, String name, String address, Company company) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCompany() {
        return company.getName();
    }

}
