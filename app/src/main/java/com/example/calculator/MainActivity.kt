package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.result_text_view)

    }

    @SuppressLint("SetTextI18n")
    fun numberClick(clickedView: View) {

        if (clickedView is TextView) {

            var text: String = resultTextView.text.toString()

            if (text == "0")
                text = ""

            val number: String = clickedView.text.toString()

            resultTextView.text = text + number
        }

    }

    fun operationClick(clickedView: View) {
        if (resultTextView.text.isEmpty()) {
            Toast.makeText(this@MainActivity, "Input Any Number!", Toast.LENGTH_SHORT).show()
        } else {
            if (clickedView is TextView) {
                operand = resultTextView.text.toString().toDouble()
                operation = clickedView.text.toString()
                resultTextView.text = ""
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun equalsClick(clickedView: View) {
        if (resultTextView.text.isEmpty()) {
            Toast.makeText(this@MainActivity, "Input Any Number!", Toast.LENGTH_SHORT).show()
        } else {
            if (clickedView is TextView) {
                val secOperand: Double = resultTextView.text.toString().toDouble()
                when (operation) {
                    "+" -> resultTextView.text = (operand + secOperand).toString()
                    "-" -> resultTextView.text = (operand - secOperand).toString()
                    "*" -> resultTextView.text = (operand * secOperand).toString()
                    "/" -> resultTextView.text = (operand / secOperand).toString()
                    "." -> resultTextView.text = resultTextView.append(".").toString()
                }
            }
        }
    }

    fun onClear(view: View) {
        this.resultTextView.text = ""
    }

    fun delClick(clickedView: View) {
        val text = this.resultTextView.text
        val n = 1
        val result = text.dropLast(n)
        this.resultTextView.text = result
    }

    fun plusMinusSign(clickedView: View) {
        if (resultTextView.text.isEmpty()) {
            Toast.makeText(this@MainActivity, "Input Any Number!", Toast.LENGTH_SHORT).show()
        } else {
            val number = this.resultTextView.text.toString().toInt()
            this.resultTextView.text = (number * -1).toString()
        }
    }

    fun sqrtSign(clickedView: View) {
        if (resultTextView.text.isEmpty()) {
            Toast.makeText(this@MainActivity, "Input Any Number!", Toast.LENGTH_SHORT).show()
        } else {
            val number = this.resultTextView.text.toString().toDouble()
            val result: Double = sqrt(number)
            this.resultTextView.text = result.toString()
        }
    }
}

