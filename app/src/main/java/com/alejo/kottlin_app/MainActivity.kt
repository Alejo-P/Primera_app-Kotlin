package com.alejo.kottlin_app

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val num1 = findViewById<EditText>(R.id.entryNumbre1)
        val num2 = findViewById<EditText>(R.id.entryNumber2)
        val result = findViewById<TextView>(R.id.textViewTotal)
        val button = findViewById<TextView>(R.id.calculateButton)

        button.setOnClickListener {
            val total = num1.text.toString().toInt() + num2.text.toString().toInt()
            result.text = total.toString()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}