package com.example.calculatorintentweb_kev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    lateinit var ButtonAdd: Button
    lateinit var ButtonSubtract: Button
    lateinit var ButtonDivide: Button
    lateinit var ButtonMultiply: Button
    lateinit var edit_fnum:EditText
    lateinit var edit_snum:EditText
    lateinit var text_answer:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        edit_fnum=findViewById(R.id.Edit_fnum)
        edit_snum=findViewById(R.id.Edit_snum)
        text_answer=findViewById(R.id.Txt_Answer)

        ButtonAdd=findViewById(R.id.Btn_add)
        ButtonAdd!!.setOnClickListener {
            var firstnum= edit_fnum.text.toString()
            var secondnum= edit_snum.text.toString()
            if (firstnum.isEmpty() && secondnum.isEmpty()){
                text_answer.text="Please fill in all inputs."
            }else{
                var answer=firstnum.toDouble() + secondnum.toDouble()
                text_answer.text=answer.toString()
            }

        }
        ButtonDivide=findViewById(R.id.Btn_division)
        ButtonDivide!!.setOnClickListener {
            var firstnum= edit_fnum.text.toString()
            var secondnum= edit_snum.text.toString()
            if (firstnum.isEmpty() && secondnum.isEmpty()){
                text_answer.text="Please fill in all inputs."
            }else{
                var answer=firstnum.toDouble() / secondnum.toDouble()
                text_answer.text=answer.toString()
            }

        }
        ButtonMultiply=findViewById(R.id.Btn_multiplication)
        ButtonMultiply!!.setOnClickListener {

            var firstnum= edit_fnum.text.toString()
            var secondnum= edit_snum.text.toString()
            if (firstnum.isEmpty() && secondnum.isEmpty()){
                text_answer.text="Please fill in all inputs."
            }else{
                var answer=firstnum.toDouble() * secondnum.toDouble()
                text_answer.text=answer.toString()
            }
        }
        ButtonSubtract=findViewById(R.id.Btn_subtract)
        ButtonSubtract!!.setOnClickListener {

            var firstnum= edit_fnum.text.toString()
            var secondnum= edit_snum.text.toString()
            if (firstnum.isEmpty() && secondnum.isEmpty()){
                text_answer.text="Please fill in all inputs."
            }else{
                var answer=firstnum.toDouble() - secondnum.toDouble()
                text_answer.text=answer.toString()
            }

        }

    }
}