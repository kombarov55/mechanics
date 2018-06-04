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

    @CrossOrigin(allowedHeaders = ["HEAD", "GET", "PUT", "POST", "DELETE", "PATCH"], origins = ["*"])
    @PostMapping("/part")
    fun addPart(
            @RequestBody json: String
    ): String {

        val obj = JSONObject(json)

        val parts = gson.fromJson(obj.getJSONObject("part").toString(), Array<Part>::class.java)
        val username = obj.getString("username")
        val password = obj.getString("password")

        if (userDao.checkUser(username, password) == false) {
            return JSONObject()
                    .put("error", "no such user")
                    .toString()
        } else {
            for (part in parts) {
                partDao.save(part)
            }
            return JSONObject()
                    .put("parts", parts)
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