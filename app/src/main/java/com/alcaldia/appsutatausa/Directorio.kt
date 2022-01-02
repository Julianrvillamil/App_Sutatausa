package com.alcaldia.appsutatausa

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.alcaldia.appsutatausa.databinding.ActivityDirectorioBinding

class Directorio : AppCompatActivity() {

    private lateinit var binding: ActivityDirectorioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDirectorioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
                startActivity(Intent(this, MainActivity::class.java))
        }

    }
    fun MainView(view: View){
        val intent = Intent(this, MainActivity::class.java).apply{

        }
        startActivity(intent)
    }
}