package com.example.shared_pref

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.shared_pref.BMI.BMI_activity
import com.example.shared_pref.api.ApiDataActivity
import com.example.shared_pref.musicPlayer.MusicPlayer
import com.example.shared_pref.shared_pref.shared_pref_activity
import com.example.shared_pref.videoPlayer.VideoPlayer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOpenApp : Button = findViewById(R.id.btn_bmi)

//        btnOpenApp.setOnClickListener {
//            val intent = Intent(this, shared_pref_activity::class.java)
//            startActivity(intent)
//        }
//        btnOpenApp.setOnClickListener {
//            val intent = Intent(this, BMI_activity::class.java)
//            startActivity(intent)
//        }
//        btnOpenApp.setOnClickListener {
//            val intent = Intent(this, MusicPlayer::class.java)
//            startActivity(intent)
//        }
//        btnOpenApp.setOnClickListener {
//            val intent = Intent(this, VideoPlayer::class.java)
//            startActivity(intent)
//        }

        btnOpenApp.setOnClickListener {
            val intent = Intent(this, ApiDataActivity::class.java)
            startActivity(intent)
        }
    }

}