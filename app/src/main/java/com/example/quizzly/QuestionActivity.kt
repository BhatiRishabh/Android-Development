package com.example.quizzly

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int=1
    private var mQuestionsList: ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswers:Int=0
    private var mUserName:String?=null

    private var tv_question:TextView?=null
    private var tv_progress:TextView?=null
    private var ivImage:ImageView?=null
    private var progressBar:ProgressBar?=null
    private var tv_OptionOne:TextView?=null
    private var tvOptionTwo:TextView?=null
    private var tvOptionThree:TextView?=null
    private var tvOptionFour:TextView?=null
    private var btn_submit:Button?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        mUserName=intent.getStringExtra(Constants.USER_NAME)
        //println(mUserName)

        tv_question=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.imageView)
        progressBar=findViewById(R.id.progressBar)
        tv_OptionOne=findViewById(R.id.tvOptionOne)
        tv_progress=findViewById(R.id.tv_progress)
        tv_OptionOne=findViewById(R.id.tvOptionOne)
        tvOptionTwo=findViewById(R.id.tvOptionTwo)
        tvOptionThree=findViewById(R.id.tvOptionThree)
        tvOptionFour=findViewById(R.id.tvOptionFour)
        btn_submit=findViewById(R.id.btn_submit)
        tv_OptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btn_submit?.setOnClickListener(this)
        mQuestionsList = Constants.getQuestions()
        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionView()
        var question: Question = mQuestionsList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        ivImage?.setImageResource(question.image)
        tv_progress?.text = "$mCurrentPosition/${progressBar?.max}"
        tv_question?.text = question.question
        tv_OptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour


        if(mCurrentPosition==mQuestionsList!!.size){
            btn_submit?.text="FINISH"
        }else{
            btn_submit?.text="SUBMIT"
        }
    }

    private fun defaultOptionView(){
        val options=ArrayList<TextView>()
        tv_OptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,
                R.drawable.default_option_border_bg
                )
        }

    }
    private fun selectedOptionView(tv: TextView, selectedOption:Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOption
       tv.setBackgroundColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,
            R.drawable.selected_option_border_bg
        )
    }
    private fun answerView(answer:Int, drawableView:Int){
        when(answer){
            1->{
                tv_OptionOne?.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                tvOptionTwo?.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                tvOptionThree?.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
            tvOptionFour?.background=ContextCompat.getDrawable(this,drawableView)
        }


        }
    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tvOptionOne->{
                tv_OptionOne?.let {
                    selectedOptionView(it,1)
                }

            }
            R.id.tvOptionTwo->{
                tvOptionTwo?.let {
                    selectedOptionView(it,2)
                }

            }
            R.id.tvOptionThree->{
                tvOptionThree?.let {
                    selectedOptionView(it,3)
                }

            }
            R.id.tvOptionFour->{
                tvOptionFour?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit->{
                if(mSelectedOptionPosition==0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else ->{
                            Toast.makeText(this, "toast called", Toast.LENGTH_SHORT).show()
                            val intent1=Intent(this, ResultActivity::class.java)
                            intent1.putExtra(Constants.USER_NAME,mUserName)
                            intent1.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent1.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                            startActivity(intent1)
                            finish()
                        }
                    }
                }else{
                    val question=mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctOption!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.incorrect_option_border_bg)

                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctOption,R.drawable.correct_option_border_bg)

                    if(mCurrentPosition==mQuestionsList?.size){
                        btn_submit?.text="FINISH"

                    }else{
                        btn_submit?.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }
            }
        }


    }
}