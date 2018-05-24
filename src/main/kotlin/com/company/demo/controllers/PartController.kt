package com.company.demo.controllers

import com.company.demo.dao.PartDao
import com.company.demo.dao.UserDao
import com.company.demo.model.Part
import com.company.demo.model.User
import com.google.gson.Gson
import org.json.JSONObject
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(allowedHeaders = ["HEAD", "GET", "PUT", "POST", "DELETE", "PATCH"], origins = ["*"])
class PartController(
        private val partDao: PartDao,
        private val userDao: UserDao,
        private val gson: Gson
) {

    @PostMapping("/part")
    fun addPart(
            @RequestParam("part") part: String,
            @RequestParam("user") user: String
    ): String {
        val part = gson.fromJson(part, Part::class.java)
        val user = gson.fromJson(user, User::class.java)
        if (userDao.checkUser(user) == false) {
            return JSONObject()
                    .put("error", "no such user")
                    .toString()
        } else {
            partDao.save(part)
            return JSONObject()
                    .put("id", part._id)
                    .toString()
        }
    }

    @GetMapping("/part")
    fun search(
            @RequestParam("q") q: String
    ): List<Part> {
        return partDao.findByName(q)
    }

}