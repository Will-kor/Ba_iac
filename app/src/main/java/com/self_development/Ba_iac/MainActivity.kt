package com.self_development.Ba_iac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.self_development.Ba_iac.auth.AuthActivity
import com.self_development.Ba_iac.auth.NameActivity
import com.self_development.Ba_iac.auth.UserDataModel
import com.self_development.Ba_iac.setting.MyPageActivity
import com.self_development.Ba_iac.utils.FirebaseAuthUtils
import com.self_development.Ba_iac.utils.FirebaseRef

class MainActivity : AppCompatActivity() {

    private val uid = FirebaseAuthUtils.getUid()

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logout = findViewById<Button>(R.id.logoutBtn)
        logout.setOnClickListener {

            val auth = Firebase.auth
            auth.signOut()

            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)

        }

        val profile = findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener {

            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)

        }


    }


}
