package com.example.cleanarchitecturegraphqlkotlinandroid.data

import com.example.cleanarchitecturegraphqlkotlinandroid.CountriesQuery
import com.example.cleanarchitecturegraphqlkotlinandroid.CountryQuery
import com.example.cleanarchitecturegraphqlkotlinandroid.domain.DetailedCountry
import com.example.cleanarchitecturegraphqlkotlinandroid.domain.SimpleCountry

fun CountryQuery.Country.toDetailCountry():DetailedCountry{
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name

    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",

    )
}