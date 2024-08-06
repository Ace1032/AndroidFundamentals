package com.example.geoquiz

class User {
    private var score: Int = 0
    private lateinit var name: String


    public fun getScore(): Int {
        return score
    }
    public fun setScore(s:Int){
        this.score=s
    }


}