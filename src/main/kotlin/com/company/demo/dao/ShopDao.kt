package com.company.dao

import com.company.model.Shop
import com.mongodb.client.MongoDatabase
import org.springframework.stereotype.Repository

import org.litote.kmongo.*

@Repository
class ShopDao(
        private val db: MongoDatabase
) {

    fun save(shop: Shop) {
        db.getCollection<Shop>().insertOne(shop)
    }

    fun findByName(name: String, size: Int? = 5): List<Shop> {
        return db.getCollection<Shop>().find("{name: $name/i").take(size ?: 5)
    }

}