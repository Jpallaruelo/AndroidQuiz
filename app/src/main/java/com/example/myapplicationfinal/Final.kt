package com.example.myapplicationfinal
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Final: AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun FinalLevel(view: View){

        var intent = Intent(this,MainActivity ::class.java)
        startActivity(intent)


    }

}