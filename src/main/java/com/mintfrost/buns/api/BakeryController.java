package com.mintfrost.buns.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mintfrost.buns.api.persistance.Bakery;
import com.mintfrost.buns.api.persistance.BakeryRepository;

@RestController
public class BakeryController {

    @Autowired
    BakeryRepository bakeryRepository;

    @GetMapping("/bakery")
    public ResponseEntity<List<Bakery>> getBakeries(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "company", required = false) String company) {
        List<Bakery> bakeriesList = new ArrayList<>();

        if (StringUtils.hasText(name) && StringUtils.hasText(company)) {
            bakeryRepository.findByNameContainingAndCompanyNameContaining(name, company)
                    .forEach(bakeriesList::add);
        } else if (StringUtils.hasText(name) || StringUtils.hasText(company)) {
            bakeryRepository.findByNameContainingOrCompanyNameContaining(name, company)
                    .forEach(bakeriesList::add);
        } else {
            bakeryRepository.findAll()
                    .forEach(bakeriesList::add);
        }

        return new ResponseEntity<>(bakeriesList, HttpStatus.OK);
    }

    @GetMapping("/bakery/{id}")
    public ResponseEntity<Bakery> getBakery(@PathVariable("id") long id) {
        Optional<Bakery> maybeBakery = bakeryRepository.findById(id);

        if (maybeBakery.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(maybeBakery.get(), HttpStatus.OK);
    }
}
