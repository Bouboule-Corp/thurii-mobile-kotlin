package com.bouboulecorp.thurii.Settings
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.bouboulecorp.thurii.LocaleHelper
import com.bouboulecorp.thurii.LogInSignInMenu.LogInSignInMenuActivity
import com.bouboulecorp.thurii.MainActivity
import com.bouboulecorp.thurii.R


class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val btnChangeTheme = findViewById<Button>(R.id.btn_change_theme)
        btnChangeTheme.setOnClickListener { chooseThemeDialog() }
    }

    private fun chooseThemeDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.choose_theme_text))
        val styles = arrayOf("Light", "Dark", "System default")

        val sharedPreference = getSharedPreferences("USER_VARIABLES", Context.MODE_PRIVATE)
        val checkedItem = sharedPreference.getInt("theme_selected", 2)

        val editor = sharedPreference.edit()
        builder.setSingleChoiceItems(styles, checkedItem) { dialog, which ->
            when (which) {
                0 -> {
                    editor.putInt("theme_selected", 0) // light theme
                    editor.commit()
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
                1 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    editor.putInt("theme_selected", 1) // dark theme
                    editor.commit()
                    delegate.applyDayNight()

                    dialog.dismiss()
                }
                2 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    delegate.applyDayNight()
                    editor.putInt("theme_selected", 2) // default theme
                    editor.commit()
                    dialog.dismiss()
                }
            }
        }

        val dialog = builder.create()
        dialog.show()
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
