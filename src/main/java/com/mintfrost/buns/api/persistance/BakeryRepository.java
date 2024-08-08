package com.mintfrost.buns.api.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BakeryRepository extends CrudRepository<Bakery, Long>{
    List<Bakery> findByNameContaining(String name);
    
    // this search uses join on company table
    List<Bakery> findByCompanyNameContaining(String companyName);
    
    // the same as above, but manually created (and without proper escaping)
    @Query("SELECT b FROM Bakery b JOIN Company c on b.company.id = c.id WHERE c.name LIKE %?1%")
    List<Bakery> findAllBakeriesWithCompanyNames(String companyName);
    
    List<Bakery> findByNameContainingOrCompanyNameContaining(String name, String companyName);

    List<Bakery> findByNameContainingAndCompanyNameContaining(String name, String companyName);
}
