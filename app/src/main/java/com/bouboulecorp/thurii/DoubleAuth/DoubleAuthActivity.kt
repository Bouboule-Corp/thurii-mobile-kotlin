package com.bouboulecorp.thurii.DoubleAuth

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.EditText
import android.widget.Button
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bouboulecorp.thurii.R

class DoubleAuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_double_auth)

        val TelAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.country_tel_code,
            R.layout.spinner_item
        )
        val tels = findViewById<Spinner>(R.id.tel_spinner)
        tel_listener(TelAdapter, tels)

        continueBtnActive()
    }

    fun goToRegisterMail(view: View) {
        super.onBackPressed()
    }

    fun continueBtnActive() {
        val tel_number = findViewById<EditText>(R.id.tel_number)
        val continue_btn = findViewById<Button>(R.id.continueBtn)
        tel_number.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {}

            override fun onTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {
                continue_btn.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext, R.color.custom_color_primary_
                    )
                )
            }
        })
    }

    fun tel_listener(TelAdapater: ArrayAdapter<CharSequence>, tels: Spinner) {
        TelAdapater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tels.adapter = TelAdapater
        tels.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position != 0) {
                    val selectedItem = parent!!.getItemAtPosition(position)
                    Toast.makeText(
                        applicationContext,
                        "$selectedItem Selected",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}
