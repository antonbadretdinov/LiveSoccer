package com.example.livesoccer.di

import com.example.livesoccer.helpers.BASE_URL
import com.example.livesoccer.network.api.ScheduleApi
import com.example.livesoccer.network.api.TeamsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun providesTeamsService(retrofit: Retrofit): TeamsApi =
        retrofit.create(TeamsApi::class.java)

    @Singleton
    @Provides
    fun providesScheduleService(retrofit: Retrofit): ScheduleApi =
        retrofit.create(ScheduleApi::class.java)
}