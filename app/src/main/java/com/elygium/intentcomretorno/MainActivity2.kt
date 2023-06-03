package com.elygium.intentcomretorno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elygium.intentcomretorno.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val nome = i.extras?.getString("nome")

        binding.editNome.setText(nome)
        binding.buttonOk.setOnClickListener {
            i.putExtra("nome", binding.editNome.text.toString())
            setResult(1, i)
            finish()
        }
        binding.buttonCancelar.setOnClickListener {
            setResult(2, i)
            finish()
        }
    }
}