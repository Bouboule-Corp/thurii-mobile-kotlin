package com.bouboulecorp.thurii.EmailRegistration

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bouboulecorp.thurii.DoubleAuth.DoubleAuthActivity
import com.bouboulecorp.thurii.R

class RegisterEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_email)

        val checked = findViewById<ImageView>(R.id.checked)
        val continue_btn = findViewById<Button>(R.id.continueBtn)
        val back_btn = findViewById<ImageButton>(R.id.backbtn)

        back_btn.setOnClickListener {
            super.onBackPressed();
        }
        checked.visibility = View.INVISIBLE
        continue_btn.setOnClickListener {
            val intent = Intent(this, DoubleAuthActivity::class.java)
            startActivity(intent)
        }
    }
}
