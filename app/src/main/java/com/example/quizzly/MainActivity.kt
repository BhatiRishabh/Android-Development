package com.example.quizzly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_Start:Button=findViewById(R.id.btn_Start)
        val etd_text:EditText=findViewById(R.id.etd_text)
        btn_Start.setOnClickListener{
            if(etd_text.text.isEmpty()){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show()
            }
            else{
               val intent= Intent(this,QuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME,etd_text.text.toString())
                startActivity(intent)
            }
        }

    }
}


