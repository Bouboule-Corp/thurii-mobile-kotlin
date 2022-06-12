package com.bouboulecorp.thurii.EmailRegistration

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.bouboulecorp.thurii.R

class RegisterEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_email)

        val checked = findViewById<ImageView>(R.id.checked)
        checked.visibility = View.INVISIBLE
    }
}
