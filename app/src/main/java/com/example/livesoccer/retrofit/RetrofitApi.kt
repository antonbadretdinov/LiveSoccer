package com.example.livesoccer.retrofit

import com.example.livesoccer.api.ScheduleApi
import com.example.livesoccer.api.TeamsApi
import com.example.livesoccer.helpers.DENMARK_ID
import com.example.livesoccer.helpers.SCOTLAND_ID
import com.example.livesoccer.model.ScheduleModel
import com.example.livesoccer.model.TeamListModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitApi: TeamsApi, ScheduleApi{
    @GET("teams/countries/$SCOTLAND_ID")
    override suspend fun getScotlandTeams(
        @Query("api_token") apiToken: String
    ): TeamListModel

    @GET("teams/countries/$DENMARK_ID")
    override suspend fun getDenmarkTeams(
        @Query("api_token") apiToken: String
    ): TeamListModel

    @GET("schedules/teams/{teamId}")
    override suspend fun getTeamSchedule(
        @Path("teamId") teamId: Int,
        @Query("api_token") apiToken: String
    ): ScheduleModel

}