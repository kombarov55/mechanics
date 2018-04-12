package com.company.demo.dao

import com.company.model.Shop
import com.mongodb.client.MongoDatabase
import org.bson.Document
import org.litote.kmongo.find
import org.litote.kmongo.getCollection
import org.litote.kmongo.replaceOne
import org.springframework.stereotype.Repository
import java.util.regex.Pattern

@Repository
class ShopDao(
        private val db: MongoDatabase
) {

    fun save(shop: Shop) {
        db.getCollection<Shop>().insertOne(shop)
    }

    fun findByName(name: String, limit: Int, offset: Int): List<Shop> {

        val q = Document()
        q.put("name", Pattern.compile(".*$name.*"))

        return db.getCollection<Shop>()
                .find(q)
                .drop(offset).take(limit)
    }

    fun getById(id: String): Shop? {
        return db.getCollection<Shop>().find(Document().append("_id", id)).firstOrNull()
    }

    fun update(shop: Shop) {
        val d = Document()
        d.put("_id", shop._id)

        db.getCollection<Shop>().replaceOne(d, shop)
    }

    fun getAll(): List<Shop> {
        val result = mutableListOf<Shop>()
        db.getCollection<Shop>().find().forEach { shop -> result.add(shop) }
        return result
    }

}