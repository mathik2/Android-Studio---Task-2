package com.example.task2_textinputlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    var clickCountMap = mutableMapOf<String,Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickCountDisplayView =  findViewById<TextView>(R.id.clickCountView)
        val clickMeButton =  findViewById<TextView>(R.id.clickButton)
        val userNameTextInputView =  findViewById<TextInputLayout>(R.id.nameText)
        clickMeButton.setOnClickListener{
            val userName = userNameTextInputView.editText?.text?.toString()

            val maskedUserName =
                if(userName.isNullOrEmpty()) "Somebody"
            else userName

            val oldClickCount = clickCountMap[maskedUserName]?:0
            val newClickCount = oldClickCount+1
            clickCountMap[maskedUserName]=newClickCount

            clickCountDisplayView.text ="$maskedUserName Clicked $newClickCount times"
        }
    }
}