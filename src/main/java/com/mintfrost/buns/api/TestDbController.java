package com.mintfrost.buns.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintfrost.buns.api.persistance.Customer;
import com.mintfrost.buns.api.persistance.CustomerRepository;

@RestController
public class TestDbController {

    @Autowired
    CustomerRepository repository;

    @GetMapping("/testdb")
    public List<Customer> CustomerRespose() {
        List<Customer> customersList = new ArrayList<>();

        StreamSupport.stream(repository.findAll().spliterator(), false)
                .forEach(customersList::add);

        return customersList;
    }
}
