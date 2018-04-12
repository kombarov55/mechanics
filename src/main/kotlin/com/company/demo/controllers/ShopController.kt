package com.company.demo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ShopController {

    @GetMapping("/")
    fun helloWorld() = "Hello world!"
}