package com.example.livesoccer.data.models


data class TeamListModel(
    val `data`: List<TeamModel>,
    val timezone: String
)

data class TeamModel(
    val id: Int,
    val image_path: String,
    val name: String,
)
