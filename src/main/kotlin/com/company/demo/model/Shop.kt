package com.company.model


data class Shop(
        val _id: String? = null,
        val name: String,
        val parts: MutableList<Part> = mutableListOf()
)