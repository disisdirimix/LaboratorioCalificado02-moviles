package com.gutierrez.francisco.usolayoutsv4

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Ejercicio01 : AppCompatActivity() {
    // Aqui definimos las propiedades y los IDs de nuestra vista asociandolos con los componentes necesarios
    private lateinit var VistaVerde: View
    private lateinit var btnMostrar: Button
    private lateinit var btnOcultar: Button
    // Creamos una funcion para que pueda enviar la logica a nuestra vista de usuario
    // en este caso viene a ser el archivo "activity_ejercicio01"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio01)
        // Inicializamos nuestras propiedades usando "findViewById" para asociarlas con los
        // IDs correspondientes en el archivo XML de la vista
        VistaVerde = findViewById(R.id.VistaVerde)
        btnMostrar = findViewById(R.id.btnMostrar)
        btnOcultar = findViewById(R.id.btnOcultar)
        // En esta parte pasamos a hacer que al darle click al boton de mostrar aplicacion el "setOnClickListener"
        // quiere decir que enviara la respuesta desde la logica del negocio a la vista para que al darle click pase a ser visible
        // Nuestro componente con el id "VistaVerde"
        btnMostrar.setOnClickListener {
            VistaVerde.visibility = View.VISIBLE
        }
        // Aqui caso contrario a lo anterior hace el mismo procedimiento pero este procede a ocultar la vista
        // Ya que lo convierte en "GONE" esto quiere decir que la desaparecera
        btnOcultar.setOnClickListener {
            VistaVerde.visibility = View.GONE
        }
    }
}
