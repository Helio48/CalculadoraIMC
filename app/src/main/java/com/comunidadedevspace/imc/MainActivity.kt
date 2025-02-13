package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referenciando os campos de entrada de texto e o botão
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)  // ID corrigido
        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)      // ID corrigido
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        // Definindo o evento de clique no botão
        btnCalcular.setOnClickListener {
            // Pegando os valores dos campos de entrada
            val pesoStr = edtPeso.text.toString()
            val alturaStr = edtAltura.text.toString()

            // Verificando se algum campo está vazio
            if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
                // Exibe uma mensagem de erro usando Snackbar
                Snackbar.make(
                    edtPeso, // O campo de onde a mensagem aparecerá
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                try {
                    // Convertendo os valores para Float
                    val peso = pesoStr.toFloat()
                    val altura = alturaStr.toFloat()

                    // Calculando o IMC
                    val alturaQ2 = altura * altura
                    val resultado = peso / alturaQ2

                    val intent= Intent(this, ResultActivity::class.java)
                    intent.putExtra(Key_result_imc, resultado )
                    startActivity(intent)

                    println("Resultado do IMC: $resultado")
                } catch (e: NumberFormatException) {
                    // Caso haja algum erro na conversão, mostramos uma mensagem de erro
                    Snackbar.make(
                        edtPeso,
                        "Por favor, insira números válidos",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}
