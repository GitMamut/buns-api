package com.mintfrost.buns.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintfrost.buns.api.persistance.Bakery;
import com.mintfrost.buns.api.persistance.BakeryRepository;

@RestController
public class BakeryController {
    
    @Autowired
    BakeryRepository bakeryRepository;

    @GetMapping("/bakery")
    public ResponseEntity<List<Bakery>> getBakeries() {
        List<Bakery> bakeriesList = new ArrayList<>();

        bakeryRepository.findAll()
                .forEach(bakeriesList::add);

        if (bakeriesList.isEmpty()) {
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(bakeriesList, HttpStatus.OK);
    }
}
