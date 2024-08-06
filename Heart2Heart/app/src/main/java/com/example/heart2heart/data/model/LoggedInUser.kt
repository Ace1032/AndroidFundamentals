package com.example.heart2heart.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser<Event>(
    val userId: String,
    val displayName: String,
    var list:List<Event>
)