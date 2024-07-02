package com.example.servicespractice_1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class RandomNumberWorker(context: Context, params: WorkerParameters): Worker(context,params) {
    override fun doWork(): Result {

        //Log.d("RandomNumberWorker", "Thread ${Thread.currentThread().name}")

        var solution = solution("(rab)")
        val outputdata= workDataOf("random_number" to solution)
        return Result.success(outputdata)
    }

    private fun solution(inputString: String): String {
        val delimiters = arrayOf("(", ")")
        val splitResult= inputString.split(*delimiters).toMutableList()
        val reverse = reverseSolution(inputString)

        val stringbuilder = StringBuilder(inputString)
        stringbuilder.deleteCharAt(inputString.indexOf("("))
        stringbuilder.deleteCharAt(inputString.indexOf(")"))
        val temp = stringbuilder.toString()
        Log.d("MainActivity", " here is $temp")
        return "hello"

    }

    private fun reverseSolution(inputString: String):String{
        val openIndex= inputString.indexOf("(")
        val closeIndex= inputString.indexOf(")")
        val mid = inputString.subSequence(openIndex+1, closeIndex)
        return mid.toString()
    }

}