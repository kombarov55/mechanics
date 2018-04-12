package com.company.demo.controllers

import com.company.demo.dao.ShopDao
import com.company.model.Shop
import com.google.gson.Gson
import org.json.JSONObject
import org.springframework.web.bind.annotation.*

@RestController()
class ShopController(
        private val shopDao: ShopDao,
        private val gson: Gson
) {

    @GetMapping("/")
    fun helloWorld() = "Hello world!"

    @PostMapping("/shop")
    fun saveShop(@RequestBody json: String): String {
        val shop = gson.fromJson(json, Shop::class.java)
        shopDao.save(shop)
        return JSONObject()
                .put("id", shop._id)
                .put("result", "ok")
                .toString()
    }

    @GetMapping("/shop")
    fun findShopByName(
            @RequestParam("name", defaultValue = "") name: String,
            @RequestParam("limit", defaultValue = "10") limit: Int,
            @RequestParam("offset", defaultValue = "0") offset: Int
    ): List<Shop> {
        return shopDao.findByName(name, limit, offset)
    }
}