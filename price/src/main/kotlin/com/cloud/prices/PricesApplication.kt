package com.cloud.prices

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class PricesApplication

fun main(args: Array<String>) {
  runApplication<PricesApplication>(*args)
}

@RestController
class PriceController {

  @GetMapping("/price")
  fun price() = 2
}
