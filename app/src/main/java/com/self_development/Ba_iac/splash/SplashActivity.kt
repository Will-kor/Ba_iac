package com.self_development.Ba_iac.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.self_development.Ba_iac.MainActivity
import com.self_development.Ba_iac.R
import com.self_development.Ba_iac.auth.AuthActivity
import com.self_development.Ba_iac.auth.NameActivity
import com.self_development.Ba_iac.utils.FirebaseAuthUtils

class SplashActivity : AppCompatActivity() {

    private val TAG = SplashActivity::class.java.simpleName

    //private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //val uid = auth.currentUser?.uid.toString()
        val uid = FirebaseAuthUtils.getUid()

        if (uid == "null") {

            Handler().postDelayed({
                val intent = Intent(this, AuthActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
                finish()
            }, 2000)

        } else {

            Handler().postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
                finish()
            }, 2000)

        }


    }
}