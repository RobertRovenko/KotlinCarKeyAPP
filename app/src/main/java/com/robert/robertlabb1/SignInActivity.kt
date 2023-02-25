package com.robert.robertlabb1

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_activity)

        //hide the title
        supportActionBar?.hide()


        //userList from my users class, two users available
        var userList = ArrayList<Users>(
            listOf(
                Users(
                 "Admin", "Admin"
                ),
                Users(
                    "Guest", "Guest"
                ),
                Users(
                    "Robert", "hej"
                ),

            )
        )

        //Function to see if the password is correct with the pair username
        fun checkCredentials(username: String, password: String): Boolean {
            for (user in userList) {
                if (user.username == username && user.password == password) {
                    return true // username and password match
                }
            }
            return false // username and password do not match any user in the list
        }


        //Values
        val nameText : EditText = findViewById(R.id.usernameEditText)
        val passwordText : EditText = findViewById(R.id.passwordEditText)
        val signUpButton: Button = findViewById(R.id.signUpButton)
        val loginButton: Button = findViewById(R.id.logInButton)
        val builder = AlertDialog.Builder(this)



        //SIGN IN BUTTON
        signUpButton.setOnClickListener{

            //send the username to the next page login and send over the username
            val intentNavigate = Intent(this, HomeActivity::class.java).apply {

                putExtra("key_username", nameText.text.toString())

            }

            //If the user hasn't typed in one or the other field
            if (nameText.text.isEmpty()||passwordText.text.isEmpty()){

                builder.setTitle("Sign Up")
                    .setMessage("Please enter a username and password")
                    .setPositiveButton("OK") { dialog, which ->
                        // do something when OK button is clicked
                    }
                val dialog = builder.create()
                dialog.show()


                println(userList)
                println("No username or password input")

            }else{

                // check if the username is already taken
                var isUsernameTaken = false
                for (user in userList) {
                    if (user.username == nameText.text.toString()) {
                        isUsernameTaken = true
                        break
                    }
                }
                //check if the username isn't taken
                if(isUsernameTaken){
                    builder.setTitle("Sign Up")
                        .setMessage("Username is already taken!")
                        .setPositiveButton("OK") { dialog, which ->
                            // do something when OK button is clicked
                        }
                    val dialog = builder.create()
                    dialog.show()

                }else{

                    println("Sign UP")
                    userList.add(Users(nameText.text.toString(), passwordText.text.toString()))

                    println(userList)
                    startActivity(intentNavigate)
                }


            }


        }

        //LOGIN BUTTON
        loginButton.setOnClickListener{

            //nav and data
            val intentNavigate = Intent(this, HomeActivity::class.java).apply {

                putExtra("key_username", nameText.text.toString())
            }

            //No empty fields
            if (nameText.text.isEmpty()||passwordText.text.isEmpty()
                    ){

                builder.setTitle("Log in")
                    .setMessage("Please enter a username and password")
                    .setPositiveButton("OK") { dialog, which ->
                        // do something when OK button is clicked
                    }
                val dialog = builder.create()
                dialog.show()

                println(userList)
                println("No username or password input")

            }else{

                var isUserFound = false
                var currentUser: Users? = null

                // Find the user whose username matches the input username
                for (user in userList) {
                    if (nameText.text.toString() == user.username) {
                        isUserFound = true
                        currentUser = user
                        break
                    }
                }
                //If there is no user with that name
                if(!isUserFound){

                    builder.setTitle("Log in")
                        .setMessage("There is no user registered with this name")
                        .setPositiveButton("OK") { dialog, which ->
                            // do something when OK button is clicked
                        }
                    val dialog = builder.create()
                    dialog.show()


                    //in case of wrong password
                }else if (!checkCredentials(currentUser!!.username, passwordText.text.toString() )) {
                    // Show error dialog if the password is incorrect
                    builder.setTitle("Log in")
                        .setMessage("Incorrect password")
                        .setPositiveButton("OK") { dialog, which -> }
                    val dialog = builder.create()
                    dialog.show()

                    //SUCCESS
                } else {
                    // Proceed with the login
                    println("LOGGED IN")
                    println(userList)
                    startActivity(intentNavigate)
                }
            }

            }

        }

    }
