package com.example.practice_1

data class Crime(
    val id: Int,
    val title: String,
    val date: String,
    val isSolved: Boolean = false
)
