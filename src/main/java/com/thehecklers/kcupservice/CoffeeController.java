package com.thehecklers.kcupservice;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {
    private final CoffeeRepository repository;

    public CoffeeController(CoffeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Coffee> getAllCoffees() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        return repository.findById(id);
    }

    @GetMapping("/search")
    Optional<Coffee> searchForCoffee(@RequestParam(required = false) String code) {
        if (code == null) {
            return Optional.of(repository.findAll().iterator().next());
        } else {
            return repository.findCoffeeByCode(code);
        }
    }
}
