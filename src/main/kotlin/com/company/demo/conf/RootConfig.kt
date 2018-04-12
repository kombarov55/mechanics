package com.company.conf

import com.company.dbHost
import com.company.dbPort
import com.google.gson.Gson
import com.mongodb.client.MongoDatabase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.litote.kmongo.*


@Configuration
@ComponentScan(basePackages = ["com.company"])
open class RootConfig(
) {

    @Bean
    open fun db(): MongoDatabase = KMongo.createClient(dbHost, dbPort).getDatabase("mechanics")

    @Bean
    open fun gson(): Gson = Gson()

}