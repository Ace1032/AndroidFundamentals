package com.example.geoquiz

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.geoquiz.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var scoreText: TextView
    private lateinit var questinText:TextView
    private var score:Int=0
    lateinit var RandQues: Ques
    var ans:Boolean = false
    var countQues:Int=0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        trueButton=binding.tureId
        falseButton=binding.falseId
        scoreText=binding.scoreId
        questinText=binding.questionView
        var qHelper=QuestionHelper()
        try {
            if(savedInstanceState!=null){
                score=savedInstanceState.getInt("score")
                countQues=savedInstanceState.getInt("countQue")
                loadQuestion(qHelper)
                loadScore()
            }
        } catch (exception: Exception){
            Log.d("exception ", exception.toString())
        }


        qHelper.uploadQuestion()
        Thread.sleep(1000L)
        loadQuestion(qHelper)
        trueButton.setOnClickListener{
            if(ans==true)   score++
            loadScore()
            loadQuestion(qHelper)
        }
        falseButton.setOnClickListener{
            if(ans==false) score++
            loadScore()
            loadQuestion(qHelper)
        }

    }
    private fun loadScore(){

        scoreText.text="Your Score: "+score.toString()+"/"+countQues.toString()
    }
    private fun loadQuestion(qh:QuestionHelper){
        RandQues=qh.getRandomQuestion()
        questinText.text= RandQues.getQ()
        ans=RandQues.isAns()
        countQues++
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("score",score)
        outState.putInt("countQue", countQues)
    }
}

