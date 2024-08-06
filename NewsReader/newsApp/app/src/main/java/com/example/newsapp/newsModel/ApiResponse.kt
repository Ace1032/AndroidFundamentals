package com.example.newsapp.newsModel

data class ApiResponse(
    val status: String,
    val totalResults: Int,
    val results : List<Article>
)
