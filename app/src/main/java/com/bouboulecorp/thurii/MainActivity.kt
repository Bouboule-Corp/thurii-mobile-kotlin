
package com.bouboulecorp.thurii

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_gender)

        val con_button = findViewById<Button>(R.id.continue_button)
        val btn_female = findViewById<ImageButton>(R.id.btn_female)
        val btn_male = findViewById<ImageButton>(R.id.btn_male)
        val progress = findViewById<ProgressBar>(R.id.step_bar)

        btn_female.setOnClickListener {
            btn_female.setAlpha(1.0f)
            btn_male.setAlpha(0.4f)
            con_button.setBackgroundColor(ContextCompat.getColor(this, R.color.color_logo));
        }

        btn_male.setOnClickListener {
            btn_male.setAlpha(1.0f)
            btn_female.setAlpha(0.4f)
            con_button.setBackgroundColor(ContextCompat.getColor(this, R.color.color_logo));
        }
        con_button.setOnClickListener {
            //button.setBackgroundColor(Color.parseColor("#FFBB86FC"))
            var i = progress.progress
            progress.setProgress(i + 25)
        }
    }
}