package com.alcaldia.appsutatausa

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contacto.*


class Contacto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //botton click to get input call sendEmail method
        boton_EnviarForm.setOnClickListener {
            var nombre = nombreyApellido.text.toString().trim()
            var email = email.text.toString().trim()
            var subject = nombre + " - Mensaje de Contacto App Sutatausa"
            var telefono = telefono.text.toString().trim()
            var mensaje = mensaje.text.toString().trim()
            var contenido =
                "" + nombre + "/n" + email + "/n" + subject + "/n" + mensaje + "/n" + telefono
            //method call for email intent with these inputs as parameters
        }
    }
}