package com.uni.bedanova_pma_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val button_get_location = findViewById<Button>(R.id.button_get_location)
        button_get_location.setOnClickListener{
            val intent = Intent(this, GetLocationActivity::class.java)
            startActivity(intent)
        }

        val button_saved = findViewById<Button>(R.id.button_saved_locations)
        button_saved.setOnClickListener{
            val intent = Intent(this, SavedLocationsActivity::class.java)
            startActivity(intent)
        }

        val button_about = findViewById<Button>(R.id.button_about_ssi)
        button_about.setOnClickListener{
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }


    }
}