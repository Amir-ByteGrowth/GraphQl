package com.example.graphql.data

import com.example.CountriesQuery
import com.example.CountryQuery
import com.example.graphql.domain.DetailedCountry
import com.example.graphql.domain.SimpleCountry


fun CountryQuery.Country.toDetailCountry() : DetailedCountry{
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital  ?: "No capital",
        continent = continent.name,
        languages = languages.mapNotNull { it.name },
        currency = currency ?: "No currency"

    )
}

fun CountriesQuery.Country.toSimpleCountry() : SimpleCountry{
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital  ?: "No capital",


    )
}