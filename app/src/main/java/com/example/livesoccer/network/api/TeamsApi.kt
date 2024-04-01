package com.example.livesoccer.network.api

import com.example.livesoccer.data.models.TeamListModel
import com.example.livesoccer.helpers.API_TOKEN
import com.example.livesoccer.helpers.DENMARK_ID
import com.example.livesoccer.helpers.SCOTLAND_ID
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamsApi {
    @GET("teams/countries/$SCOTLAND_ID")
    suspend fun getScotlandTeams(
        @Query("api_token") apiToken: String = API_TOKEN
    ): TeamListModel

    @GET("teams/countries/$DENMARK_ID")
    suspend fun getDenmarkTeams(
        @Query("api_token") apiToken: String = API_TOKEN
    ): TeamListModel
}