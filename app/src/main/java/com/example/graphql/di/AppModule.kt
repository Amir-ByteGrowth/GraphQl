package com.example.graphql.di

import com.apollographql.apollo3.ApolloClient
import com.example.graphql.data.ApolloCountryClient
import com.example.graphql.domain.CountryClient
import com.example.graphql.domain.GetCountriesUseCase
import com.example.graphql.domain.GetCountryUseCase
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
    fun providesApolloClient(): ApolloClient {
        // we can use all types of methods just like retrofit here
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun providesCountryClient(apolloClient: ApolloClient): CountryClient {
        return ApolloCountryClient(apolloClient)
    }

    @Provides
    @Singleton
    fun providesGetCountriesUseCase(apolloCountryClient: ApolloCountryClient): GetCountriesUseCase {
        return GetCountriesUseCase(apolloCountryClient)
    }

    @Provides
    @Singleton
    fun providesGetCountryUseCase(apolloCountryClient: ApolloCountryClient): GetCountryUseCase {
        return GetCountryUseCase(apolloCountryClient)
    }

}