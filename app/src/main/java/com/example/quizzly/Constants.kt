package com.example.quizzly

object Constants {
    const val USER_NAME:String="user_name"
    const val CORRECT_ANSWERS:String="correct_answers"
    const val TOTAL_QUESTIONS:String="total_questions"

    fun getQuestions():ArrayList<Question>{
        val QuestonsList= ArrayList<Question>()
        val q1=Question(1,"Who is prime Minister of India?", R.drawable.ic_indian_flag,"King John Un","Joe Biden","Rajnath Singh", "Narendra Modi",4)
        val q2=Question(1,"Which country flag is this?", R.drawable.ic_flagyemen,"Argentina","Austria"," Australia", "America",1)
        val q3=Question(1,"Which country flag is this?", R.drawable.ic_flagyemen,"Kuwait","Kenya","Yemen", "Nepal",3)
        val q4=Question(1,"Which country flag is this?", R.drawable.ic_flagbangladesh,"Brazil","Bhutan","Bangladesh", "Nepal",3)
        val q5=Question(1,"Which country flag is this?", R.drawable.flag_of_japan,"Japan","Israel","Cuba", "Mexico",1)
        val q6=Question(1,"Which country flag is this?", R.drawable.flag_of_new_zealand,"Egypt","UAE","Saudi Arabia", "New Zealand",4)
        val q7=Question(1,"Which country flag is this?", R.drawable.flagfrance,"Canada","France","Germany", "Romania",2)
        val q8=Question(1,"Which country flag is this?", R.drawable.ic_flagsouthafrica,"Republic Congo","South Africa","Madagascar", "Malaysia",2)
        val q9=Question(1,"Which country flag is this?", R.drawable.ic_flagsrilanka,"Kazakhstan","Pakistan","Sri lanka", "Portugal",3)
        val q10=Question(1,"Which country flag is this?", R.drawable.ic_west_indies,"West Indies","Jordan","Jamaica", "Russia",1)

        QuestonsList.add(q1)
        QuestonsList.add(q2)
        QuestonsList.add(q3)
        QuestonsList.add(q4)
        QuestonsList.add(q5)
        QuestonsList.add(q6)
        QuestonsList.add(q7)
        QuestonsList.add(q8)
        QuestonsList.add(q9)
        QuestonsList.add(q10)

        return QuestonsList
    }
}