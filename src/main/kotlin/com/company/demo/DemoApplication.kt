package com.company.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = [ "com.company.demo" ])
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
