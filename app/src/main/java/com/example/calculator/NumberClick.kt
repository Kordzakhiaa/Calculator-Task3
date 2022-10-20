package com.example.calculator

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView

interface NumberClick {
    fun numberClick(clickedView: View, view: View)
    class Base : NumberClick {
        @SuppressLint("SetTextI18n", "CutPasteId")
        override fun numberClick(clickedView: View, view: View) {
            if (clickedView is TextView) {
                var text: String =
                    view.findViewById<TextView>(R.id.result_text_view).text.toString()

                if (text == "0")
                    text = ""

                val number: String = clickedView.text.toString()
                view.findViewById<TextView>(R.id.result_text_view).text = text + number
            }
        }
    }
}