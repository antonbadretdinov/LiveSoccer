package com.example.livesoccer.network.api

import com.example.livesoccer.data.models.ScheduleModel
import com.example.livesoccer.helpers.API_TOKEN
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ScheduleApi {
    @GET("schedules/teams/{teamId}")
    suspend fun getTeamSchedule(
        @Path("teamId") teamId: Int,
        @Query("api_token") apiToken: String = API_TOKEN
    ): ScheduleModel
}