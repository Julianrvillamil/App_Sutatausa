package com.alcaldia.appsutatausa

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.CalendarCache.URI
import android.util.Log
import android.view.View
import android.content.Intent




class Tramites : AppCompatActivity() {

    val url = "https://www.psepagos.co/PSEHostingUI/ShowTicketOffice.aspx?ID=4959"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tramites)
    }

    /*Called when the user touches the button*/
    fun openCrediflores(view: View){
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}