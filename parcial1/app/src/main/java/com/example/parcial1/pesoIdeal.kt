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

class pesoIdeal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_peso_ideal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        backHome()
        calcPesoIdeal()
    }

    fun backHome(){
        val btn = findViewById<Button>(R.id.backBt2)
        btn.setOnClickListener{
            val saltar = Intent(this, home::class.java)
            startActivity(saltar)
        }
    }

    fun calcPesoIdeal() {

        val imcResultView = findViewById<TextView>(R.id.masaCorpCalTx2)
        val imcCategoryView = findViewById<TextView>(R.id.respCalc) // Para mostrar el valor del IMC
        val sexo = findViewById<EditText>(R.id.sexoImp)
        val altura = findViewById<EditText>(R.id.altImp)
        val calcBt = findViewById<Button>(R.id.calcBt2)

        calcBt.setOnClickListener{

            val sexoText = sexo.text.toString()
            val alturaText = altura.text.toString()


            if (sexoText.isEmpty() || alturaText.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese su sexo y altura", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sexo = sexoText.toFloatOrNull()
            val altura = alturaText.toFloatOrNull()



            if (sexo == null || altura == null || altura <= 0) {
                Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (sexo?.toInt() == 1){
                val calclt = altura - 100

                imcResultView.text = String.format("$calclt Kg")
                imcCategoryView.text = String.format("Tu peso ideal es: $calclt Kg")

            }else if (sexo?.toInt() == 2){
                val calclt = altura - 105

                imcResultView.text = String.format("$calclt Kg")
                imcCategoryView.text = String.format("Tu peso ideal es: $calclt Kg")

            }else {
                imcResultView.text = String.format("null Kg")
                imcCategoryView.text = String.format("Tu peso ideal es: null Kg")
            }

        }

    }
}