package com.uca.lab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SharedActivity : AppCompatActivity() {

    private lateinit var nombre:TextView
    private lateinit var email:TextView
    private lateinit var telefono:TextView
    private lateinit var compartir:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)

        nombre = findViewById(R.id.nombreF)
        email = findViewById(R.id.emailF)
        telefono = findViewById(R.id.telF)
        compartir = findViewById(R.id.botonshared)
        nombre.setText(intent.getStringExtra("nombre").toString())
        email.setText(intent.getStringExtra("email").toString())
        telefono.setText(intent.getStringExtra("telefono").toString())

        compartir.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
               putExtra("nombre",nombre.text.toString())
               putExtra("email",email.text.toString())
               putExtra("telefono",telefono.text.toString())
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)

        }

    }
}