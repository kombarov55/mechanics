package com.company.model

data class Part(
        val _id: String? = null,
        val artikul: String,
        val name: String,
        val matchingCars: MutableList<String> = mutableListOf(),
        val price: Int
)