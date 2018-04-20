package com.company.demo.dao

import com.company.demo.model.Part
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import org.litote.kmongo.getCollection
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class PartDao(
        private val db: MongoDatabase
) {

    fun save(part: Part) {
        part._id = UUID.randomUUID().toString()
        db.getCollection<Part>().insertOne(part)
    }

    fun findByName(name: String): List<Part> {
        return db.getCollection<Part>()
                .find(Filters.or(
                        Filters.regex("name", "$name.*"),
                        Filters.regex("vin", "$name.*")))
                .take(20)
    }


}