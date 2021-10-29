package com.example.activityresultapi

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView:TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = this.findViewById(R.id.textView)
        button = this.findViewById(R.id.button)

        button.setOnClickListener {
            // 開啟頁面跳轉
            myActivityLauncher.launch("Hello,技術最TOP")
        }
    }

    class MyActivityResultContract: ActivityResultContract<String, String>(){
        override fun createIntent(context: Context, input: String?): Intent {
            return Intent(context,SecondActivity::class.java).apply {
                putExtra("name",input)
            }
        }

        override fun parseResult(resultCode: Int, intent: Intent?): String? {
            val data = intent?.getStringExtra("result")
            return if (resultCode == Activity.RESULT_OK && data != null) data
            else null
        }
    }

    private val myActivityLauncher = registerForActivityResult(MyActivityResultContract()){result ->
        Toast.makeText(applicationContext,result,Toast.LENGTH_SHORT).show()
        textView.text = "回傳資料：$result"
    }
}