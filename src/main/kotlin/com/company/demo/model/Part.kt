package com.company.demo.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Part(
        @JsonProperty(value = "id")
        var _id: String? = null,
        val name: String? = null,
        val price: Int? = null,
        val photo: String? = null,
        val matchingCars: List<String>? = emptyList(),
        val amount: Int? = null,
        val status: Int? = null,
        val shop: String? = null,
        val minOrder: Int? = null,
        val measure: String? = null,
        val vin: String? = null
)