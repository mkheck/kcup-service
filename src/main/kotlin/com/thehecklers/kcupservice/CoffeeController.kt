package com.thehecklers.kcupservice

import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/coffees")
class CoffeeController(private val repository: CoffeeRepository) {
    @GetMapping
    fun getAllCoffees() = repository.findAll()

    @GetMapping("/{id}")
    fun getCoffeeById(@PathVariable id: String) = repository.findById(id)

    @GetMapping("/search")
    fun searchForCoffee(@RequestParam code: String?) =
        if (code.isNullOrEmpty())
            repository.findAll().first()
        else
            repository.findCoffeeByCode(code)
}
