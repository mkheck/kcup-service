package com.thehecklers.kcupservice

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.*
import java.util.function.Consumer

@SpringBootApplication
internal class KcupServiceApplication {
    @Bean
    fun demoData(repository: CoffeeRepository) = CommandLineRunner {
        repository.deleteAll()

        listOf("Espresso Roast", "Kaldi Coffee", "SK Coffee", "Klatch Dark Roast")
            .map { Coffee(type = it) }
            .forEach { repository.save(it) }

        repository.findAll().forEach { println(it) }
    }
}

fun main(args: Array<String>) {
    runApplication<KcupServiceApplication>(*args)
}

