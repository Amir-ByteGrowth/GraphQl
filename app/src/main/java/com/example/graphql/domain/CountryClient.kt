package com.example.graphql.domain

import com.example.CountryQuery

interface CountryClient {

    suspend fun getCountries(): List<SimpleCountry>

    suspend fun getCountry(code:String) : DetailedCountry?
}