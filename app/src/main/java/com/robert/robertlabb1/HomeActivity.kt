package com.robert.robertlabb1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()

        //Take in the username provided and welcome
        val homeIntent = intent.getStringExtra("key_username")
        val displayUsername: TextView = findViewById(R.id.usernameHomeText)

        displayUsername.text = homeIntent

        val myButton: Button = findViewById(R.id.addCar)
        myButton.setOnClickListener{

            //send the username to the next page
            val intentNavigate = Intent(this, MainActivity::class.java).apply {

            }

            println("Add a new car")
            startActivity(intentNavigate)
            //displayUsername.text = username.text.toString()
        }

        val continueButton: Button = findViewById(R.id.continueCar)
        continueButton.setOnClickListener{

            //send the username to the next page
            val intentNavigate = Intent(this, MainActivity::class.java).apply {



            }

            println("Continue with the same car")
            startActivity(intentNavigate)
            //displayUsername.text = username.text.toString()
        }
    }
}