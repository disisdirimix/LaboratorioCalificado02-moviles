package com.gutierrez.francisco.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gutierrez.francisco.usolayoutsv4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var numeroCliente: String = ""
    private var nombreCliente: String = ""
    private var productos: String = ""
    private var ciudad: String = ""
    private var direccion: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar datos del intent
        obtenerDatos()

        // Mostrar datos en la UI
        mostrarDatos()

        // Configurar botones
        configurarBotones()
    }

    private fun obtenerDatos() {
        intent.extras?.let { extras ->
            nombreCliente = extras.getString("NOMBRE_CLIENTE", "")
            numeroCliente = extras.getString("NUMERO_CLIENTE", "")
            productos = extras.getString("PRODUCTOS", "")
            ciudad = extras.getString("CIUDAD", "")
            direccion = extras.getString("DIRECCION", "")
        }
    }

    private fun mostrarDatos() {
        binding.tvNombreCliente.text = "Nombre: $nombreCliente"
        binding.tvNumeroCliente.text = "Número: $numeroCliente"
        binding.tvProductos.text = "Productos: $productos"
        binding.tvDireccion.text = "Dirección: $ciudad, $direccion"
    }

    private fun configurarBotones() {
        // Configurar botón de llamada
        binding.btnLlamar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$numeroCliente")
            }
            startActivity(intent)
        }

        // Configurar botón de WhatsApp
        binding.btnWhatsapp.setOnClickListener {
            val mensaje = "Hola $nombreCliente Tus productos: $productos están en camino a la dirección: $direccion"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://api.whatsapp.com/send?phone=$numeroCliente&text=${Uri.encode(mensaje)}")
            }
            startActivity(intent)
        }

        // Configurar botón de Maps
        binding.btnMaps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=$ciudad $direccion")
            }
            startActivity(intent)
        }
    }
}