package com.mintfrost.buns.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintfrost.buns.api.persistance.Customer;
import com.mintfrost.buns.api.persistance.CustomerRepository;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customersList = new ArrayList<>();

        customerRepository.findAll()
                .forEach(customersList::add);

        if (customersList.isEmpty()) {
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customersList, HttpStatus.OK);
    }
}
