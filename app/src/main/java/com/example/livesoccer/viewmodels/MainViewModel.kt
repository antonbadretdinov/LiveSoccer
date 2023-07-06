package com.example.livesoccer.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.livesoccer.helpers.API_TOKEN
import com.example.livesoccer.model.ScheduleModel
import com.example.livesoccer.model.TeamListModel
import com.example.livesoccer.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    private val teamsApi = RetrofitInstance.service

    private val mutableDenmarkTeamsLiveData = MutableLiveData<TeamListModel>()
    val denmarkTeamsLiveData: LiveData<TeamListModel> = mutableDenmarkTeamsLiveData

    private val mutableScotlandTeamsLiveData = MutableLiveData<TeamListModel>()
    val scotlandTeamsLiveData: LiveData<TeamListModel> = mutableScotlandTeamsLiveData

    private val mutableScheduleLiveData = MutableLiveData<ScheduleModel>()
    val scheduleLiveData: LiveData<ScheduleModel> = mutableScheduleLiveData

    fun geDenmarkList(){
        viewModelScope.launch {
            val teamsDenmarkList = withContext(Dispatchers.IO) {
                teamsApi.getDenmarkTeams(API_TOKEN)
            }
            mutableDenmarkTeamsLiveData.value = teamsDenmarkList
        }
    }

    fun getScotlandList(){
        viewModelScope.launch {
            val teamsScotlandList = withContext(Dispatchers.IO) {
                teamsApi.getScotlandTeams(API_TOKEN)
            }
            mutableScotlandTeamsLiveData.value = teamsScotlandList
        }
    }

    fun getTeamSchedule(teamId: Int){
        viewModelScope.launch {
            val teamSchedule = withContext(Dispatchers.IO){
                teamsApi.getTeamSchedule(teamId, API_TOKEN)
            }
            mutableScheduleLiveData.value = teamSchedule
        }
    }



}