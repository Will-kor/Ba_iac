package com.self_development.Ba_iac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.self_development.Ba_iac.auth.AuthActivity
import com.self_development.Ba_iac.setting.MyPageActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var storage = FirebaseStorage.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewFlipper = findViewById<ViewFlipper>(R.id.banner)
        val storageRef = storage.reference
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

        for(i in 0..4) {
            storageRef.child("banner/" + i + ".jpg").downloadUrl.addOnSuccessListener {
                val imageView = ImageView(this)
                Glide.with(this@MainActivity).load(it).into(imageView)
                viewFlipper.addView(imageView)
                viewFlipper.flipInterval = 8000
                viewFlipper.isAutoStart = true
                viewFlipper.startFlipping()
                viewFlipper.setInAnimation(this, R.anim.slide_in_right)
                viewFlipper.setOutAnimation(this, R.anim.slide_out_left)
            }.addOnFailureListener {

            }
        }
    }
}

