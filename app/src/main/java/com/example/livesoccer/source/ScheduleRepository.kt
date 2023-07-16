package com.example.livesoccer.source

import com.example.livesoccer.api.ScheduleApi
import com.example.livesoccer.model.ScheduleModel

class ScheduleRepository(private val scheduleApi: ScheduleApi) {

    suspend fun getSchedule(teamId: Int): ScheduleModel{
        return scheduleApi.getTeamSchedule(teamId)
    }
}