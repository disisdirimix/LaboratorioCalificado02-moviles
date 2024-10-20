package com.gutierrez.francisco.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnEjercicio01: Button
    private lateinit var btnRegistro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEjercicio01 = findViewById(R.id.btnEjercicio01)
        btnRegistro = findViewById(R.id.btnRegistro)

        btnEjercicio01.setOnClickListener {
            val intent = Intent(this, Ejercicio01::class.java)
            startActivity(intent)
        }

        btnRegistro.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }
}