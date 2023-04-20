package com.example.cleanarchitecturegraphqlkotlinandroid.di

import com.apollographql.apollo3.ApolloClient
import com.example.cleanarchitecturegraphqlkotlinandroid.data.ApolloCountryClient
import com.example.cleanarchitecturegraphqlkotlinandroid.domain.CountryClient
import com.example.cleanarchitecturegraphqlkotlinandroid.domain.GetCountriesUseCase
import com.example.cleanarchitecturegraphqlkotlinandroid.domain.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApolloClient():ApolloClient{
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient):CountryClient{
        return ApolloCountryClient(apolloClient)

    }
    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryClient: CountryClient):GetCountriesUseCase{
        return GetCountriesUseCase(countryClient)

    }
    @Provides
    @Singleton
    fun provideGetCountryUseCase(countryClient: CountryClient):GetCountryUseCase{
        return GetCountryUseCase(countryClient)

    }
}