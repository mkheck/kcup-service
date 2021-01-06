package com.thehecklers.kcupservice

import org.springframework.data.repository.CrudRepository
import java.util.*

interface CoffeeRepository : CrudRepository<Coffee, String> {
    fun findCoffeeByCode(code: String): Coffee
}