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

    fun checkUser(user: User): Boolean {
        return db.getCollection<User>()
                .find(Filters.and(
                        Filters.eq("username", user.username),
                        Filters.eq("password", user.password)))
                .any()
    }

}