package com.example.parcial1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class masaCorporal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_masa_corporal)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        setupCalculateIMC()
        setupBackHome()
    }

    private fun setupBackHome() {
        val backButton = findViewById<Button>(R.id.backBt)
        backButton.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }
    }

    private fun setupCalculateIMC() {

        val pesoInput = findViewById<EditText>(R.id.pesoImp)
        val alturaInput = findViewById<EditText>(R.id.altImp)
        val calcButton = findViewById<Button>(R.id.calcBt)
        val imcResultView = findViewById<TextView>(R.id.masaCorpCalTx) // Para mostrar el valor del IMC
        val imcCategoryView = findViewById<TextView>(R.id.respCalc) // Para mostrar la categoría del IMC

        calcButton.setOnClickListener {

            val pesoText = pesoInput.text.toString()
            val alturaText = alturaInput.text.toString()


            if (pesoText.isEmpty() || alturaText.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese su peso y altura", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val peso = pesoText.toFloatOrNull()
            val altura = alturaText.toFloatOrNull()


            if (peso == null || altura == null || peso <= 0 || altura <= 0) {
                Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val calcAlt = altura * altura
            val imc = peso / calcAlt



            val categoria = when {
                imc < 18.5 -> "Bajo peso"
                imc <= 24.9 -> "Normal"
                imc <= 29.9 -> "Sobrepeso"
                else -> "Obesidad"
            }


            imcResultView.text = String.format("$imc")
            imcCategoryView.text = categoria
        }
    }
}