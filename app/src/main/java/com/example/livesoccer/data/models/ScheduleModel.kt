package com.example.livesoccer.data.models

data class ScheduleModel(
    val data: List<ScheduleData>?,
)

data class ScheduleData(
    val rounds: List<Round>,
)

data class Round(
    val fixtures: List<Fixture>,
)

data class Fixture(
    val participants: List<Participant>,
    val starting_at: String,
)

data class Participant(
    val id: Int,
    val image_path: String,
    val meta: Meta?,
    val name: String
)

data class Meta(
    val location: String
)