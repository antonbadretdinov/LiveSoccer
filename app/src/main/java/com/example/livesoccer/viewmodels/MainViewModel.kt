package com.example.livesoccer.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.livesoccer.model.ScheduleModel
import com.example.livesoccer.model.TeamListModel
import com.example.livesoccer.retrofit.RetrofitInstance
import com.example.livesoccer.source.ScheduleRepository
import com.example.livesoccer.source.TeamsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    private val scheduleRepository = ScheduleRepository(RetrofitInstance.service)
    private val teamsRepository = TeamsRepository(RetrofitInstance.service)

    private val mutableDenmarkTeamsLiveData = MutableLiveData<TeamListModel>()
    val denmarkTeamsLiveData: LiveData<TeamListModel> = mutableDenmarkTeamsLiveData

    private val mutableScotlandTeamsLiveData = MutableLiveData<TeamListModel>()
    val scotlandTeamsLiveData: LiveData<TeamListModel> = mutableScotlandTeamsLiveData

    private val mutableScheduleLiveData = MutableLiveData<ScheduleModel>()
    val scheduleLiveData: LiveData<ScheduleModel> = mutableScheduleLiveData

    fun getDenmarkList(){
        viewModelScope.launch {
            val teamsDenmarkList = withContext(Dispatchers.IO) {
                teamsRepository.getDenmarkTeams()
            }
            mutableDenmarkTeamsLiveData.value = teamsDenmarkList
        }
    }

    fun getScotlandList(){
        viewModelScope.launch {
            val teamsScotlandList = withContext(Dispatchers.IO) {
                teamsRepository.getScotlandTeams()
            }
            mutableScotlandTeamsLiveData.value = teamsScotlandList
        }
    }

    fun getTeamSchedule(teamId: Int){
        viewModelScope.launch {
            val teamSchedule = withContext(Dispatchers.IO){
                scheduleRepository.getSchedule(teamId)
            }
            mutableScheduleLiveData.value = teamSchedule
        }
    }



}