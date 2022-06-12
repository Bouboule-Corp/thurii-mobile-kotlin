package com.bouboulecorp.thurii.DoubleAuth

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bouboulecorp.thurii.R

class DoubleAuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_double_auth)

        val back_btn = findViewById<ImageButton>(R.id.backbtn)

        back_btn.setOnClickListener {
            super.onBackPressed();
        }

        val TelAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.country_tel_code,
            R.layout.spinner_item
        )
        val tels = findViewById<Spinner>(R.id.tel_spinner)
        tel_listener(TelAdapter, tels)
    }

    fun tel_listener(TelAdapater:ArrayAdapter<CharSequence>, tels:Spinner) {
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
