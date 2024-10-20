package com.gutierrez.francisco.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gutierrez.francisco.usolayoutsv4.databinding.ActivityRegistroBinding

class Registro : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnRegistrar.setOnClickListener {
            if (validateFields()) {
                navigateToDetail()
            }
        }
    }

    private fun validateFields(): Boolean {
        var isValid = true

        // Validar nombre
        if (binding.etNombreCliente.text.toString().isEmpty()) {
            binding.tilNombreCliente.error = "Campo requerido"
            isValid = false
        } else {
            binding.tilNombreCliente.error = null
        }

        // Validar número
        if (binding.etNumeroCliente.text.toString().isEmpty()) {
            binding.tilNumeroCliente.error = "Campo requerido"
            isValid = false
        } else {
            binding.tilNumeroCliente.error = null
        }

        // Validar productos
        if (binding.etProductos.text.toString().isEmpty()) {
            binding.tilProductos.error = "Campo requerido"
            isValid = false
        } else {
            binding.tilProductos.error = null
        }

        // Validar ciudad
        if (binding.etCiudad.text.toString().isEmpty()) {
            binding.tilCiudad.error = "Campo requerido"
            isValid = false
        } else {
            binding.tilCiudad.error = null
        }

        // Validar dirección
        if (binding.etDireccion.text.toString().isEmpty()) {
            binding.tilDireccion.error = "Campo requerido"
            isValid = false
        } else {
            binding.tilDireccion.error = null
        }

        return isValid
    }

    private fun navigateToDetail() {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("NOMBRE_CLIENTE", binding.etNombreCliente.text.toString())
            putExtra("NUMERO_CLIENTE", binding.etNumeroCliente.text.toString())
            putExtra("PRODUCTOS", binding.etProductos.text.toString())
            putExtra("CIUDAD", binding.etCiudad.text.toString())
            putExtra("DIRECCION", binding.etDireccion.text.toString())
        }
        startActivity(intent)
    }
}