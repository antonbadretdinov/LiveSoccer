package com.example.livesoccer.ui.adapters.listener

import com.example.livesoccer.model.TeamModel

interface SelectListener {
    fun onItemClicked(model: TeamModel)
}