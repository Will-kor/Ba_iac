package com.self_development.Ba_iac

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.self_development.Ba_iac.auth.AuthActivity
import com.self_development.Ba_iac.setting.MyPageActivity


class MainActivity : AppCompatActivity() {

    private var storage = FirebaseStorage.getInstance()
    var currentBIndex = 0
    val countBIndexes = 4 //배너 이미지 개수

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storageRef = storage.reference
        val logout = findViewById<Button>(R.id.logoutBtn)
        val viewFlipper = findViewById<ViewFlipper>(R.id.banner)
        val bannerLarrow = findViewById<TextView>(R.id.leftarrow)
        val bannerRarrow = findViewById<TextView>(R.id.rightarrow)

        var downX = 0f
        var upX = 0f

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

        for(i in 0..countBIndexes) {
            storageRef.child("banner/" + i + ".jpg").downloadUrl.addOnSuccessListener {
                val imageView = ImageView(this)
                Glide.with(this).load(it).into(imageView)
                viewFlipper.addView(imageView)
                viewFlipper.setFlipInterval(8000)
                viewFlipper.isAutoStart = true
                viewFlipper.startFlipping()
                viewFlipper.setInAnimation(this, R.anim.slide_in_right)
                viewFlipper.setOutAnimation(this, R.anim.slide_out_left)
            }.addOnFailureListener {

            }
        }

        viewFlipper.setOnTouchListener { v: View, event:MotionEvent ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    downX = event.x
                    true
                }
                MotionEvent.ACTION_UP -> {
                    upX = event.x
                    if (upX < downX) {
                        viewFlipper.setInAnimation(this, R.anim.slide_in_right)
                        viewFlipper.setOutAnimation(this, R.anim.slide_out_left)
                        if (currentBIndex < countBIndexes - 1) {
                            viewFlipper.showNext()
                            currentBIndex++
                                if (currentBIndex == countBIndexes - 1) {
                                    bannerRarrow.setTextColor(Color.parseColor("#d3d3d3"))
                                }
                                else if (currentBIndex == 0) {
                                    bannerLarrow.setTextColor(Color.parseColor("#d3d3d3"))
                                }
                                else{
                                    bannerRarrow.setTextColor(Color.parseColor("#202020"))
                                    bannerLarrow.setTextColor(Color.parseColor("#202020"))
                                }
                        }
                    }
                    else if (upX > downX) {
                        viewFlipper.setInAnimation(this, R.anim.slide_in_left)
                        viewFlipper.setOutAnimation(this, R.anim.slide_out_right)
                        if (currentBIndex > 0) {
                            viewFlipper.showPrevious()
                            currentBIndex--
                                if (currentBIndex == 2) {
                                    bannerRarrow.setTextColor(Color.parseColor("#d3d3d3"))
                                }
                                else if (currentBIndex == 0) {
                                    bannerLarrow.setTextColor(Color.parseColor("#d3d3d3"))
                                }
                                else{
                                    bannerRarrow.setTextColor(Color.parseColor("#202020"))
                                    bannerLarrow.setTextColor(Color.parseColor("#202020"))
                                }
                        }
                    }
                    viewFlipper.setInAnimation(this, R.anim.slide_in_right)
                    viewFlipper.setOutAnimation(this, R.anim.slide_out_left)
                    true
                }
                else -> {
                    false
                }
            }
        }

        bannerLarrow.setText("<")
        bannerLarrow.setTextSize(18F)
        bannerLarrow.setTextColor(Color.parseColor("#d3d3d3"))

        bannerRarrow.setText(">")
        bannerRarrow.setTextSize(18F)
        bannerRarrow.setTextColor(Color.parseColor("#202020"))
    }
}