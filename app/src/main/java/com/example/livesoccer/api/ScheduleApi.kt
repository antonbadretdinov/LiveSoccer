package com.example.livesoccer.api

import com.example.livesoccer.helpers.API_TOKEN
import com.example.livesoccer.model.ScheduleModel

interface ScheduleApi {

    suspend fun getTeamSchedule(teamId: Int, apiToken: String = API_TOKEN): ScheduleModel
}