package com.cloud.coffee

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
class CoffeeApplication

fun main(args: Array<String>) {
  runApplication<CoffeeApplication>(*args)
}

@RestController
class CoffeeController {

  @Autowired
  private lateinit var price: PriceClient

  @GetMapping("/ping")
  fun ping() = "Pong"

  @GetMapping("/espresso")
  fun espressoPrice() = price.coffeePrice().also {
    println(it)
  }
}


@FeignClient(name = "price")
interface PriceClient {

  @GetMapping("/price")
  fun coffeePrice(): Int
}