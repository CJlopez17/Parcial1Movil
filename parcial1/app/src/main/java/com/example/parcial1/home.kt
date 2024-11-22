package com.example.parcial1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        GoMasaCorp()
        GoPesoIdeal()
    }

    fun GoMasaCorp(){
        val btn = findViewById<Button>(R.id.masaCorpBt)
        btn.setOnClickListener{
            val saltar = Intent(this, masaCorporal::class.java)
            startActivity(saltar)
        }
    }

    fun GoPesoIdeal(){
        val btn = findViewById<Button>(R.id.pesoIdealBt)
        btn.setOnClickListener{
            val saltar = Intent(this, pesoIdeal::class.java)
            startActivity(saltar)
        }
    }

}