package com.company.demo

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.CrossOrigin

var dbHost = "localhost"
var dbPort = 27017

@SpringBootApplication
@CrossOrigin
@EnableAutoConfiguration
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
