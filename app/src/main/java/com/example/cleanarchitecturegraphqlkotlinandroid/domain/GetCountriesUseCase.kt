package com.example.cleanarchitecturegraphqlkotlinandroid.domain

class GetCountriesUseCase(
    private val countryClient: CountryClient
) {
    suspend fun execute():List<SimpleCountry>{
        return countryClient.getCountries()
            .sortedBy { it.name }
    }
}