package com.company.demo.dao

import com.company.demo.model.User
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import org.litote.kmongo.getCollection
import org.springframework.stereotype.Repository

@Repository
class UserDao(
        private val db: MongoDatabase
) {

    fun checkUser(username: String, password: String): Boolean {
        return db.getCollection<User>()
                .find(Filters.and(
                        Filters.eq("username", username),
                        Filters.eq("password", password)))
                .any()
    }

}