package com.self_development.Ba_iac.auth

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.self_development.Ba_iac.MainActivity
import com.self_development.Ba_iac.R
import com.self_development.Ba_iac.utils.FirebaseRef
import java.io.ByteArrayOutputStream

class NameActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private var nickname = ""
    private var school = ""
    private var uid = ""

    lateinit var imageArea : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        auth = Firebase.auth

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)

        val textArea = findViewById<TextView>(R.id.selectTextArea)
        imageArea = findViewById(R.id.imageArea)

        val joinBtn = findViewById<Button>(R.id.joinBtn)

        val user = auth.currentUser

        btn1.setOnClickListener {
            textArea.setText("아비도스 고등학교")
            imageArea.setImageResource(R.drawable.select_abydos)
        }

        btn2.setOnClickListener {
            textArea.setText("게헨나 학원")
            imageArea.setImageResource(R.drawable.select_gehenna)
        }

        btn3.setOnClickListener {
            textArea.setText("밀레니엄 사이언스 스쿨")
            imageArea.setImageResource(R.drawable.select_millennium)
        }

        btn4.setOnClickListener {
            textArea.setText("트리니티 종합학원")
            imageArea.setImageResource(R.drawable.select_trinity)
        }

        btn5.setOnClickListener {
            textArea.setText("백귀야행 종합학원")
            imageArea.setImageResource(R.drawable.select_hyakkiyako)
        }

        btn6.setOnClickListener {
            textArea.setText("산해경 고급중학교")
            imageArea.setImageResource(R.drawable.select_shanhaijing)
        }

        btn7.setOnClickListener {
            textArea.setText("붉은겨울 연방학원")
            imageArea.setImageResource(R.drawable.select_redwinter)
        }

        joinBtn.setOnClickListener {

            nickname = findViewById<EditText>(R.id.nickNameArea).text.toString()
            school = textArea.text.toString()
            uid = user?.uid.toString()

            val userModel = UserDataModel(nickname, school, uid)

            FirebaseRef.userInfoRef.child(uid).setValue(userModel)

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("이미지", school)
            startActivity(intent)


        }

    }



}