package com.example.cleanarchitecturegraphqlkotlinandroid.data

import com.apollographql.apollo3.ApolloClient
import com.example.cleanarchitecturegraphqlkotlinandroid.CountriesQuery
import com.example.cleanarchitecturegraphqlkotlinandroid.CountryQuery
import com.example.cleanarchitecturegraphqlkotlinandroid.domain.CountryClient
import com.example.cleanarchitecturegraphqlkotlinandroid.domain.DetailedCountry
import com.example.cleanarchitecturegraphqlkotlinandroid.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
):CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailCountry()
    }
}