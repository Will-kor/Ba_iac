package com.self_development.Ba_iac.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.self_development.Ba_iac.MainActivity
import com.self_development.Ba_iac.R
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        val findPassword = findViewById<TextView>(R.id.findPassword)
        findPassword.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.password_setting, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("passwordChange")

            val  mAlertDialog = mBuilder.show()

            val okBtn = mDialogView.findViewById<Button>(R.id.okBtn)
            val noBtn = mDialogView.findViewById<Button>(R.id.noBtn)
            val putEmail = mDialogView.findViewById<EditText>(R.id.putEmailArea)


            okBtn.setOnClickListener {
                FirebaseAuth.getInstance().sendPasswordResetEmail(putEmail.text.toString()).addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "비밀번호 변경 메일을 전송했습니다", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this, task.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                }
                mAlertDialog.dismiss()
            }
            noBtn.setOnClickListener {
                mAlertDialog.dismiss()
            }

        }

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