package com.self_development.ba_iac.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.self_development.ba_iac.R

class JoinActivity : AppCompatActivity() {

    private val TAG = JoinActivity::class.java.simpleName

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        auth = Firebase.auth

        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener {

            val email = findViewById<EditText>(R.id.emailArea)
            val pwd = findViewById<EditText>(R.id.passwordArea)

            //Log.d(TAG, email.text.toString())
            //Log.d(TAG, pwd.text.toString())

            auth.createUserWithEmailAndPassword(email.text.toString(), pwd.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        Log.d(TAG, user?.uid.toString())

                        val intent = Intent(this, NameActivity::class.java)
                        startActivity(intent)

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)

                    }
                }

        }


    }
}