package com.example.tunisia

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val selectedName = intent.getStringExtra("country_name")
        val selectedImage = intent.getIntExtra("country_image", 0)

        val selectedNameTextView: TextView = findViewById(R.id.detailTextView)
        val selectedImageView: ImageView = findViewById(R.id.countryImage2)

        if (selectedName != null) {
            selectedNameTextView.text = "Name: $selectedName"
        }

        if (selectedImage != 0) {
            selectedImageView.setImageResource(selectedImage)
        }
    }
}
