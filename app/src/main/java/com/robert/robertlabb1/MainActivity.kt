package com.robert.robertlabb1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.widget.Button
import android.widget.TextView
import com.robert.robertlabb1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding //Init Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()


        val onButton: Button = findViewById(R.id.onButton)
        val offButton: Button= findViewById(R.id.offButton)
        val aboutButton: Button = findViewById(R.id.About)
        val logOutButton: Button = findViewById(R.id.logoutButton)

        val rememberEngineStatus = binding.engineStatus


        onButton.setOnClickListener {
            rememberEngineStatus.text = "Car is turned ON"

            rememberEngineStatus.setTextColor(Color.parseColor("#FF109E00"))
            println("Car is turned ON")

        }

        offButton.setOnClickListener {

            rememberEngineStatus.text = "Car is turned OFF"
            rememberEngineStatus.setTextColor(Color.parseColor("#FFC30000"))
            println("Car is turned OFF")
        }



        logOutButton.setOnClickListener{

            //send the username to the next page
            val intentNavigate = Intent(this, SignInActivity::class.java).apply {


            }

            println("log out")
            startActivity(intentNavigate)
            //displayUsername.text = username.text.toString()
        }

        aboutButton.setOnClickListener{

            //send the username to the next page
            val intentNavigate = Intent(this, AboutActivity::class.java).apply {


            }

            println("Navigating to about")
            startActivity(intentNavigate)

        }
    }


}