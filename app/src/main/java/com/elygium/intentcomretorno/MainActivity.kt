package com.elygium.intentcomretorno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.elygium.intentcomretorno.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var result: ActivityResultLauncher<Intent>
    private var nome = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMudarNome.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            i.putExtra("nome", nome)
            //startActivity(i)
            result.launch(i)
        }

        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.data != null && it.resultCode == 1) {
                nome = it.data?.getStringExtra("nome").toString()
                binding.textNome.text = "Olá $nome"
            } else if (it.data != null && it.resultCode == 2){
                Toast.makeText(applicationContext, "Operação cancelada", Toast.LENGTH_SHORT)
                    .show()
            }else {
                Toast.makeText(applicationContext, "Erro ao atualizar o nome", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}