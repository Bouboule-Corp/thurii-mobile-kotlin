package com.bouboulecorp.thurii.EmailRegistration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bouboulecorp.thurii.DoubleAuth.DoubleAuthActivity
import com.bouboulecorp.thurii.R

class RegisterEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_email)

        val checked = findViewById<ImageView>(R.id.checked)

        checked.visibility = View.INVISIBLE
        ContinueBtnActive()
    }

    fun goToLastFragment(view: View) {
        super.onBackPressed();
    }

    fun ContinueBtnActive() {
        val et_password = findViewById<EditText>(R.id.et_password)
        val continue_btn = findViewById<Button>(R.id.continueBtn)
        et_password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                continue_btn.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext, R.color.custom_color_primary_
                    )
                )
            }
        })
    }

    fun goToDoubleAuth(view: View) {
        val intent = Intent(this, DoubleAuthActivity::class.java)
        startActivity(intent)
    }
}
