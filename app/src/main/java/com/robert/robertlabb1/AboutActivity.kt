package com.robert.robertlabb1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.hide()


        val returnToCar: Button = findViewById(R.id.returnHome)
        returnToCar.setOnClickListener{

            //send the username to the next page
            val intentNavigate = Intent(this, MainActivity::class.java).apply {



            }

            println("log in")
            startActivity(intentNavigate)
            //displayUsername.text = username.text.toString()
        }
    }
}