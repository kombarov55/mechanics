package com.company.demo.conf

import com.company.demo.dbHost
import com.company.demo.dbPort
import com.google.gson.Gson
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter


@Configuration
@ComponentScan(basePackages = ["com.company.demo.controllers",  "com.company.demo.dao"])
open class RootConfig: WebMvcConfigurerAdapter() {

    @Bean
    open fun db(): MongoDatabase = KMongo.createClient(dbHost, dbPort).getDatabase("mechanics")

    @Bean
    open fun gson(): Gson = Gson()

}