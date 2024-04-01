package com.example.livesoccer.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.livesoccer.data.models.ScheduleModel
import com.example.livesoccer.data.models.TeamListModel
import com.example.livesoccer.data.repository.ScheduleRepository
import com.example.livesoccer.data.repository.TeamsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
    private val teamsRepository: TeamsRepository
) : ViewModel() {

    private val mutableDenmarkTeamsLiveData = MutableLiveData<TeamListModel>()
    val denmarkTeamsLiveData: LiveData<TeamListModel> = mutableDenmarkTeamsLiveData

    private val mutableScotlandTeamsLiveData = MutableLiveData<TeamListModel>()
    val scotlandTeamsLiveData: LiveData<TeamListModel> = mutableScotlandTeamsLiveData

    private val mutableScheduleLiveData = MutableLiveData<ScheduleModel>()
    val scheduleLiveData: LiveData<ScheduleModel> = mutableScheduleLiveData

    fun getDenmarkList() {
        viewModelScope.launch {
            val teamsDenmarkList = withContext(Dispatchers.IO) {
                teamsRepository.getDenmarkTeams()
            }
            mutableDenmarkTeamsLiveData.value = teamsDenmarkList
        }
    }

    fun getScotlandList() {
        viewModelScope.launch {
            val teamsScotlandList = withContext(Dispatchers.IO) {
                teamsRepository.getScotlandTeams()
            }
            mutableScotlandTeamsLiveData.value = teamsScotlandList
        }
    }

    fun getTeamSchedule(teamId: Int) {
        viewModelScope.launch {
            val teamSchedule = withContext(Dispatchers.IO) {
                scheduleRepository.getSchedule(teamId)
            }
            mutableScheduleLiveData.value = teamSchedule
        }
    }


}