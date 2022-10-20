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
    fun itemNumberClicked(clickedView: View) {
        if (clickedView is TextView) {
            var text = resultTextView.text.toString()
            if (text == "0") text = ""
            val number = clickedView.text.toString()
            resultTextView.text = text + number
        }
    }

    fun operationClick(clickedView: View) = checkResultTextView {
        if (clickedView is TextView) {
            operand = resultTextView.text.toString().toDouble()
            operation = clickedView.text.toString()
            resultTextView.text = ""
        }
    }

    @SuppressLint("SetTextI18n")
    fun equalsClick(clickedView: View) = checkResultTextView {
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


    fun onTextCleared(view: View) = resultTextView.setText("")

    fun deleteButtonClicked(clickedView: View) {
        val text = this.resultTextView.text
        val number = 1
        val result = text.dropLast(number)
        this.resultTextView.text = result
    }

    fun plusMinusSign(clickedView: View) = checkResultTextView {
        val number = this.resultTextView.text.toString().toInt()
        this.resultTextView.text = (number * -1).toString()
    }

    fun sqrtSign(clickedView: View) = checkResultTextView {
        val number = this.resultTextView.text.toString().toDouble()
        val result: Double = sqrt(number)
        this.resultTextView.text = result.toString()
    }

    private fun checkResultTextView(block: () -> Unit) = if (resultTextView.text.isEmpty()) {
        Toast.makeText(this@MainActivity, "Input Any Number!", Toast.LENGTH_SHORT).show()
    } else {
        block.invoke()
    }
}