package com.thehecklers.kcupservice;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
    Optional<Coffee> findCoffeeByCode(String code);
}
