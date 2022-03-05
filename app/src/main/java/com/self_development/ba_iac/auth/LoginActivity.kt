package com.self_development.ba_iac.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.self_development.ba_iac.MainActivity
import com.self_development.ba_iac.R

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {

            val email = findViewById<EditText>(R.id.emailArea)
            val pwd = findViewById<EditText>(R.id.passwordArea)

            auth.signInWithEmailAndPassword(email.text.toString(), pwd.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)

                    } else {

                        Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()

                    }
                }

        }



    }
}