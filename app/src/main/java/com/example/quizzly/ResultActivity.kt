package com.example.quizzly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)
        val tv_username:TextView=findViewById(R.id.tv_Username)
        val tv_score:TextView=findViewById(R.id.tv_score)
        val btn_finish:Button=findViewById(R.id.btn_finish)

        tv_username.text=intent.getStringExtra(Constants.USER_NAME)

        val totalquestion=intent.getStringExtra(Constants.TOTAL_QUESTIONS)
        val correctanswer=intent.getStringExtra(Constants.CORRECT_ANSWERS)
        tv_score.text="Your Score is $correctanswer out of $totalquestion"

        btn_finish.setOnClickListener(){
            val intent =Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}