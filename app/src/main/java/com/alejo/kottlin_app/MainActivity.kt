package com.alejo.kottlin_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn_sin = findViewById<Button>(R.id.btnSin)
        val btn_cos = findViewById<Button>(R.id.btnCos)
        val btn_tan = findViewById<Button>(R.id.btnTan)
        val entry_number = findViewById<EditText>(R.id.entryNumber)
        val result = findViewById<TextView>(R.id.resultView)

        btn_sin.setOnClickListener {
            if (entry_number.text.isEmpty()) {
                result.text = "Ingrese un número"
                return@setOnClickListener
            }
            val number = entry_number.text.toString().toDouble()
            val resultado = sin(Math.toRadians(number))
            result.text = "Sin de $number° = ${resultado}"
        }

        btn_cos.setOnClickListener {
            if (entry_number.text.isEmpty()) {
                result.text = "Ingrese un número"
                return@setOnClickListener
            }
            val number = entry_number.text.toString().toDouble()
            val resultado = cos(Math.toRadians(number))
            result.text = "Coseno de $number° = ${resultado}"
        }

        btn_tan.setOnClickListener {
            if (entry_number.text.isEmpty()) {
                result.text = "Ingrese un número"
                return@setOnClickListener
            }
            val valor = entry_number.text.toString().toDouble()
            // Comprobar si la tangente es indefinida
            if (valor % 90 == 0.0 && (valor/ 90) % 2 != 0.0) {
                result.text = "Tangente de $valor° es indefinida"
            } else {
                val resultado = tan(Math.toRadians(valor))

                result.text = "Tangente de $valor°: $resultado"
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}