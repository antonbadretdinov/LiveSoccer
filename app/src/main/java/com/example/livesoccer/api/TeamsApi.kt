package com.example.livesoccer.api

import com.example.livesoccer.helpers.API_TOKEN
import com.example.livesoccer.model.TeamListModel

interface TeamsApi {

    suspend fun getDenmarkTeams(apiToken: String = API_TOKEN): TeamListModel
    suspend fun getScotlandTeams(apiToken: String = API_TOKEN): TeamListModel
}