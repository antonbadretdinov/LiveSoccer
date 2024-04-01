package com.example.livesoccer.ui.adapters.listener

import com.example.livesoccer.data.models.TeamModel

interface SelectListener {
    fun onItemClicked(model: TeamModel)
}