package com.self_development.Ba_iac.setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.self_development.Ba_iac.R
import com.self_development.Ba_iac.auth.UserDataModel
import com.self_development.Ba_iac.utils.FirebaseAuthUtils
import com.self_development.Ba_iac.utils.FirebaseRef

class MyPageActivity : AppCompatActivity() {

    private val TAG = MyPageActivity::class.java.simpleName

    private val uid = FirebaseAuthUtils.getUid()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        getMyData()

    }

    private fun getMyData() {

        val myProfileImage = findViewById<ImageView>(R.id.myProfileImage)
        val myProfileNickname = findViewById<TextView>(R.id.myProfileNickname)

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                Log.d(TAG, dataSnapshot.toString())
                val data = dataSnapshot.getValue(UserDataModel::class.java)

                val school = data!!.school

                myProfileNickname.text = "이름 : " + data!!.nickname

                if(school == "아비도스 고등학교") {
                    myProfileImage.setImageResource(R.drawable.idcard_abydos)
                } else if(school == "게헨나 학원") {
                    myProfileImage.setImageResource(R.drawable.idcard_gehenna)
                } else if(school == "밀레니엄 사이언스 스쿨") {
                    myProfileImage.setImageResource(R.drawable.idcard_millennium)
                } else if(school == "트리니티 종합학원") {
                    myProfileImage.setImageResource(R.drawable.idcard_trinity)
                } else if(school == "백귀야행 종합학원") {
                    myProfileImage.setImageResource(R.drawable.idcard_hyakkiyako)
                } else if(school == "산해경 고급중학교") {
                    myProfileImage.setImageResource(R.drawable.idcard_shanhaijing)
                } else if(school == "붉은겨울 연방학원") {
                    myProfileImage.setImageResource(R.drawable.idcard_redwinter)
                }


            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        FirebaseRef.userInfoRef.child(uid).addValueEventListener(postListener)

    }


}