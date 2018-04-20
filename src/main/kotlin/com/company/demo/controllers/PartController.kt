package com.company.demo.controllers

import com.company.demo.dao.PartDao
import com.company.demo.model.Part
import com.google.gson.Gson
import org.json.JSONObject
import org.springframework.web.bind.annotation.*

@RestController("/part")
class PartController(
        private val partDao: PartDao,
        private val gson: Gson
) {

    @PostMapping
    fun addPart(
            @RequestBody json: String
    ): String {
        val part = gson.fromJson(json, Part::class.java)
        partDao.save(part)
        return JSONObject()
                .put("status", "ok")
                .put("id", part._id)
                .toString()

    }

    @GetMapping
    fun search(
            @RequestParam("q") q: String
    ): List<Part> {
        return partDao.findByName(q)
    }

}