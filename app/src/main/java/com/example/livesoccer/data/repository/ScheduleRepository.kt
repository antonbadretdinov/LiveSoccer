package com.example.livesoccer.data.repository

import com.example.livesoccer.data.models.ScheduleModel
import com.example.livesoccer.network.api.ScheduleApi
import javax.inject.Inject

class ScheduleRepository @Inject constructor(
    private val scheduleApi: ScheduleApi
) {
    suspend fun getSchedule(teamId: Int): ScheduleModel {
        return scheduleApi.getTeamSchedule(teamId)
    }
}