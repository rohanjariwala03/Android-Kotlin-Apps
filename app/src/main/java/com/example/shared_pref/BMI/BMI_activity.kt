package com.example.shared_pref.BMI

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.shared_pref.R

class BMI_activity : AppCompatActivity() {

    private lateinit var etWeight : EditText
    private lateinit var etHeight : EditText
    private lateinit var tvResult : TextView
    private lateinit var tvType : TextView
    private lateinit var btnCalculate : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        tvResult = findViewById(R.id.tvResult)
        tvType = findViewById(R.id.tvType)
        btnCalculate = findViewById(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            if(validateInput(etWeight.text.toString(), etHeight.text.toString())){
                calculateBMI()
            }

        }
    }

    @SuppressLint("ResourceAsColor")
    private fun calculateBMI(){
        val bmi = etWeight.text.toString().toFloat()/((etHeight.text.toString().toFloat()/100) * (etHeight.text.toString().toFloat()/100))
        //convert into 2 decimal point
        val bmiConvert = String.format("%.2f",bmi).toFloat()
        when {
            bmiConvert < 18.4 -> {
                tvType.setText("You are Under Weight")
                tvType.setTextColor(R.color.underWeight)
            }
            bmiConvert < 24.9 -> {
                tvType.setText("You are Normal")
                tvType.setTextColor(R.color.normal)
            }
            bmiConvert < 29.9 -> {
                tvType.setText("You are Over Weight")
                tvType.setTextColor(R.color.overWeight)
            }
            else -> {
                tvType.setText("You are Obese")
                tvType.setTextColor(R.color.obese)
            }
        }
        tvResult.setText(bmiConvert.toString())
    }

    private fun validateInput(weight: String?, height: String?): Boolean{
        return  when{
            weight.isNullOrEmpty() -> {
                Toast.makeText(this,"Weight is Empty",Toast.LENGTH_LONG).show()
                return false;
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this,"Height is Empty",Toast.LENGTH_LONG).show()
                return false;
            }
            else -> {
                return true
            }
        }
    }
}