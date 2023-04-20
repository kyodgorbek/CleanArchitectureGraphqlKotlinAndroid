package com.example.cleanarchitecturegraphqlkotlinandroid.domain

class GetCountryUseCase(
    private val countryClient: CountryClient
) {
    suspend fun execute(code:String):DetailedCountry?{
        return countryClient.getCountry(code)
    }
}