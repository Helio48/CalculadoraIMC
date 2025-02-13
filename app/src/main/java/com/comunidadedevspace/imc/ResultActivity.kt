package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.security.Key

const val Key_result_imc = "ResultActivity.Key_imc"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(Key_result_imc,0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvclassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        val classificacao: String?  = if(result <= 18.5f){
            "MAGRAZA"
        } else if(result > 18.5f && result <= 24.9f){
            "NORMAL"
        } else if(result > 25f && result <= 29.9f){
            "SOBREPESO"
        } else if(result > 30f && result <= 39.9f){
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        tvclassificacao.text = classificacao

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}