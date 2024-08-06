package com.example.heart2heart.ui.notifications

data class RegisterState(
    val nameError: Int? = null,
    val dobError: Int? = null,
    val emailError: Int? = null,
    val passwordError: Int? = null,
    var result:Boolean?=null,
    var failReson: String?= null
)
