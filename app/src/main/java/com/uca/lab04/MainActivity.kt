package com.uca.lab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameInput: TextInputEditText
    private lateinit var emailInput: TextInputEditText
    private lateinit var telefonoInput: TextInputEditText
    private lateinit var botonShared:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInput = findViewById(R.id.nombreInput)
        emailInput = findViewById(R.id.emailInput)
        telefonoInput = findViewById(R.id.telefonoInput)
        botonShared = findViewById(R.id.buttonEnviar)

        botonShared.setOnClickListener {
            val intent = Intent(this,SharedActivity::class.java)
            intent.putExtra("nombre",nameInput.text.toString())
            intent.putExtra("email",emailInput.text.toString())
            intent.putExtra("telefono",telefonoInput.text.toString())
            startActivity(intent)
        }
    }
}