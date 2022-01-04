package com.alcaldia.appsutatausa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }


    fun contactoView(view: View){
        val intent = Intent(this, Email::class.java).apply{
        }
        startActivity(intent)
    }

    fun contactenosView(view: View){
        val intent = Intent(this, Contactenos::class.java).apply{

        }
        startActivity(intent)
    }
    fun noticiasView(view: View){
        val intent = Intent(this, Noticias::class.java).apply{

        }
        startActivity(intent)
    }

    fun TramitesView(view: View){
        val intent = Intent(this, Tramites::class.java).apply{

        }
        startActivity(intent)
    }

    fun DirectorioView(view: View){
        val intent = Intent(this, Directorio::class.java).apply{

        }
        startActivity(intent)
    }

    fun ComunicadosioView(view: View){
        val url = "http://www.sutatausa-cundinamarca.gov.co/tema/normatividad"
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
        }



}