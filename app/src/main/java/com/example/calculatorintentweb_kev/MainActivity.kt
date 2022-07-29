package com.example.calculatorintentweb_kev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var ButtonCalc:Button ?= null
    var ButtonIntent:Button ?= null
    var ButtonWeb:Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButtonCalc=findViewById(R.id.Btn_calc)

        ButtonCalc!!.setOnClickListener {
            val intent= Intent(this,CalculatorActivity::class.java)
            startActivity(intent)
        }
        ButtonIntent=findViewById(R.id.Btn_intent)

        ButtonIntent!!.setOnClickListener {
            val intent= Intent(this,IntentActivity::class.java)
            startActivity(intent)
        }
        ButtonWeb=findViewById(R.id.Btn_web)

        ButtonWeb!!.setOnClickListener {
            val intent= Intent(this,WebActivity::class.java)
            startActivity(intent)
        }
    }
}