package com.example.livesoccer.data.repository

import com.example.livesoccer.network.api.TeamsApi
import com.example.livesoccer.data.models.TeamListModel
import javax.inject.Inject

class TeamsRepository @Inject constructor(private val teamsApi: TeamsApi) {
    suspend fun getScotlandTeams(): TeamListModel {
        return teamsApi.getScotlandTeams()
    }
    suspend fun getDenmarkTeams(): TeamListModel {
        return teamsApi.getDenmarkTeams()
    }
}