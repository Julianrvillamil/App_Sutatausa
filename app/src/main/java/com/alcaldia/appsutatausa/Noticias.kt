package com.alcaldia.appsutatausa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_noticias.*

class Noticias : AppCompatActivity() {

    //Private

    //FACEBOOK
    private val URL = "https://www.facebook.com/alcaldiasutatausa/"

    //SUTAWEB
    //private val URL = "http://www.sutatausa-cundinamarca.gov.co/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        //webView

        webView.webChromeClient = object : WebChromeClient(){

        }
        webView.webViewClient = object : WebViewClient(){

        }
        val settings = webView.settings
        settings.javaScriptEnabled = true

        webView.loadUrl(URL)

    }
}