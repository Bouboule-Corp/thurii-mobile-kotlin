package com.bouboulecorp.thurii.Settings
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.bouboulecorp.thurii.LocaleHelper
import com.bouboulecorp.thurii.LogInSignInMenu.LogInSignInMenuActivity
import com.bouboulecorp.thurii.MainActivity
import com.bouboulecorp.thurii.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // access the items of the list
        val theme = resources.getStringArray(R.array.theme)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                theme
            )
            spinner.adapter = adapter

            val sharedPreference = getSharedPreferences("USER_VARIABLES", Context.MODE_PRIVATE)
            when (sharedPreference.getString("mapbox_style", "mapbox://styles/mapbox/outdoors-v11")) {
                "mapbox://styles/mapbox/dark-v10" -> spinner.setSelection(1) // dark theme
                "mapbox://styles/mapbox/satellite-streets-v11" -> spinner.setSelection(2) // satellite theme
                else -> {
                    spinner.setSelection(0)
                }
            }

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(
                        this@SettingsActivity,
                        getString(R.string.selected_item) + " " +
                        "" + theme[position],
                        Toast.LENGTH_SHORT
                    ).show()

                    val editor = sharedPreference.edit()

                    when (position) {
                        1 -> editor.putString("mapbox_style", "mapbox://styles/mapbox/dark-v10") // dark theme
                        2 -> editor.putString("mapbox_style", "mapbox://styles/mapbox/satellite-streets-v11") // satellite theme
                        else -> {
                            editor.putString("mapbox_style", "mapbox://styles/mapbox/outdoors-v11")
                        }
                    }

                    editor.commit()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    fun goToLogInSignInPage(view: View) {
        val intent = Intent(this, LogInSignInMenuActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun changeToFrench(view: View) {
        LocaleHelper.setLocale(this, "fr") // for french;
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun changeToEnglish(view: View) {
        LocaleHelper.setLocale(this, "en") // for english;
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
