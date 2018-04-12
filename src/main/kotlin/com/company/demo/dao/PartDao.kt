package com.company.demo.dao

import com.company.model.Part
import com.mongodb.client.MongoDatabase
import org.json.JSONObject
import org.springframework.stereotype.Repository

import org.litote.kmongo.*


@Repository
class PartDao(
        private val db: MongoDatabase
) {

    fun save(part: Part) {
        db.getCollection<Part>().insertOne(part)
    }

    fun find(jsonQ: JSONObject, size: Int = 10): List<Part> {
        return db.getCollection<Part>().find(jsonQ.toString()).take(size)
    }


}