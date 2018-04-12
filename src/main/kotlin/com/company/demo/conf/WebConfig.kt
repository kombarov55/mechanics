package com.company.conf

import com.company.controller.PartController
import com.company.controller.ShopController
import org.springframework.stereotype.Component
import spark.Spark.*


@Component
class WebConfig(
        private val partController: PartController,
        private val shopController: ShopController
) {

    init {
        port(8080)
        get("/", { req, resp -> "Hello world!" })
        path("/part", {
            post("", partController::save)
        })
        path("/shop", {
            post("", shopController::save)
            get("byName", shopController::findByName)
        })
    }

}