package com.example.activityresultapi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(){

    private lateinit var textView3: TextView
    private lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)

        textView3 = this.findViewById(R.id.textView3)
        button2 = this.findViewById(R.id.button2)

        val name = intent.getStringExtra("name")
        textView3.text = "接收到的資料為：$name"

        button2.setOnClickListener {
            val intent = Intent().apply {
                putExtra("result","Hello，依然范特西稀，我是回傳的資料！")
            }
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}