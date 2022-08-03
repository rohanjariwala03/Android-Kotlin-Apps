package com.example.shared_pref

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.shared_pref.BMI.BMI_activity
import com.example.shared_pref.shared_pref.shared_pref_activity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSharedPref : Button = findViewById(R.id.btn_sharedPref)
        val btnBMI : Button = findViewById(R.id.btn_bmi)

        btnSharedPref.setOnClickListener {
            val intent = Intent(this, shared_pref_activity::class.java)
            startActivity(intent)
        }

        btnBMI.setOnClickListener {
            val intent = Intent(this, BMI_activity::class.java)
            startActivity(intent)
        }
    }

}