package com.company.demo.controllers

import com.company.demo.dao.ShopDao
import com.company.model.Part
import com.google.gson.Gson
import org.json.JSONObject
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController("/part")
class PartController(
        private val shopDao: ShopDao,
        private val gson: Gson
) {

    @PostMapping
    fun addPart(
            @RequestParam("part") json: String,
            @RequestParam("shop_id") shopId: String
    ): String {

        val part = gson.fromJson(json, Part::class.java)

        val shop = shopDao.getById(shopId)
        if (shop != null) {
            shop.parts.add(part)
            shopDao.update(shop)

            return JSONObject()
                    .put("id", part._id)
                    .put("result", "ok")
                    .toString()
        } else {
            return JSONObject()
                    .put("result", "shop not found")
                    .toString()
        }


    }

}