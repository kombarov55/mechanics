package com.company.demo.dao

import com.company.demo.model.Part
import com.mongodb.client.MongoDatabase
import org.json.JSONObject
import org.springframework.stereotype.Repository

import org.litote.kmongo.*
import java.util.*


@Repository
class PartDao(
        private val db: MongoDatabase
) {

    fun save(part: Part) {
        part._id = UUID.randomUUID().toString()
        db.getCollection<Part>().insertOne(part)
    }

    fun find(jsonQ: JSONObject, size: Int = 10): List<Part> {
        return db.getCollection<Part>().find(jsonQ.toString()).take(size)
    }


}