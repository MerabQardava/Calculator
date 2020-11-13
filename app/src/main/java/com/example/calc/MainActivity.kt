package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
private lateinit var resultTextView: TextView
private var operand: Double =0.0
private var operation: String=""


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView=findViewById(R.id.resulTextView)

    }



    fun numberClick(view: View){
        if(view is TextView){


            val number: String =view.text.toString()
            var result: String = resultTextView.text.toString()
            if (result=="0"){
                result =""
            }


            resultTextView.text= result + number


        }
    }
    fun operationClick(view: View){
        if (view is TextView){
            if(!TextUtils.isEmpty(resultTextView.text)){
                operand= resultTextView.text.toString().toDouble()
            }
            operation= view.text.toString()
            resultTextView.text=""
        }

    }
    fun equalsClick (view: View){
        val secOperandText: String= resultTextView.text.toString()
        var secOperand: Double=0.0

        if(!TextUtils.isEmpty(secOperandText)){
            secOperand=secOperandText.toDouble()
        }
        when(operation){
            "+" -> resultTextView.text= (operand + secOperand).toString()
            "-" -> resultTextView.text= (operand - secOperand).toString()
            "*" -> resultTextView.text= (operand * secOperand).toString()
            "/" -> resultTextView.text= (operand / secOperand).toString()
        }
    }
    fun clear (view: View){
        resultTextView.text=""

        }
    fun backSpace(view: View){
        resultTextView.text= resultTextView.text.substring(0, resultTextView.length()-1)

    }
    fun dot (view: View){
        resultTextView.text= resultTextView.text
    }
    }

