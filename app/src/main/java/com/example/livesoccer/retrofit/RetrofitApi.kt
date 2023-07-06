package com.example.livesoccer.retrofit

import com.example.livesoccer.helpers.DENMARK_ID
import com.example.livesoccer.helpers.SCOTLAND_ID
import com.example.livesoccer.model.ScheduleModel
import com.example.livesoccer.model.TeamListModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitApi{
    @GET("teams/countries/$SCOTLAND_ID")
    suspend fun getScotlandTeams(
        @Query("api_token") api_token: String
    ): TeamListModel

    @GET("teams/countries/$DENMARK_ID")
    suspend fun getDenmarkTeams(
        @Query("api_token") api_token: String
    ): TeamListModel

    @GET("schedules/teams/{teamId}")
    suspend fun getTeamSchedule(
        @Path("teamId") teamId: Int,
        @Query("api_token") api_token: String
    ): ScheduleModel

}