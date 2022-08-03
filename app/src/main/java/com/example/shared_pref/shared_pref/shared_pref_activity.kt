package com.example.shared_pref.shared_pref

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.shared_pref.R

class shared_pref_activity : AppCompatActivity() {

    private lateinit var txtName : EditText
    private lateinit var sharedPref : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        txtName = findViewById(R.id.txtName)
        sharedPref = getSharedPreferences("shared_pref", MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    override fun onPause() {
        super.onPause()
        val name = txtName.text.toString()
        editor.apply{
            putString("name",name)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val n = sharedPref.getString("name","")
        txtName.setText(n)
    }
}