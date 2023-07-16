package com.example.livesoccer.source

import com.example.livesoccer.api.TeamsApi
import com.example.livesoccer.model.TeamListModel

class TeamsRepository(private val teamsApi: TeamsApi) {
    suspend fun getScotlandTeams(): TeamListModel{
        return teamsApi.getScotlandTeams()
    }
    suspend fun getDenmarkTeams(): TeamListModel{
        return teamsApi.getDenmarkTeams()
    }
}