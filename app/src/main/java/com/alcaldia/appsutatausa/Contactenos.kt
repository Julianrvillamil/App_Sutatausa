package com.alcaldia.appsutatausa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class Contactenos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactenos)
        }

    fun llamada(view: View){
        val number = "3212146951"
        val call = Uri.parse("tel:$number")
        val surf = Intent(Intent.ACTION_DIAL, call)
        startActivity(surf)
    }

    fun openSutatausaWeb(view: View){
        val url = "http://www.sutatausa-cundinamarca.gov.co/"
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }


}