package com.self_development.Ba_iac.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.self_development.Ba_iac.R

class JoinActivity : AppCompatActivity() {

    private val TAG = JoinActivity::class.java.simpleName

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        val email = findViewById<EditText>(R.id.emailArea)
        val pwd = findViewById<EditText>(R.id.passwordArea)
        val pwdPwd = findViewById<EditText>(R.id.passwordPwdArea)

        auth = Firebase.auth

        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener {

            val emailCheck = email.text.toString()
            val pwdCheck = pwd.text.toString()
            val pwdCheckCheck = pwdPwd.text.toString()

            if (emailCheck.isEmpty() || pwdCheck.isEmpty() || pwdCheckCheck.isEmpty()) {

                Toast.makeText(this, "모든 정보를 입력하여 주십시오", Toast.LENGTH_SHORT).show()

            } else {

                createUser()

            }

            if (pwdCheck.equals(pwdCheckCheck)) {

                createUser()

            } else {

                Toast.makeText(this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()

            }


        }


    }

    private fun createUser() {

        val email = findViewById<EditText>(R.id.emailArea)
        val pwd = findViewById<EditText>(R.id.passwordArea)

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
                    Toast.makeText(this, "이메일 중복", Toast.LENGTH_SHORT).show()

                }
            }

    }

}