package com.bouboulecorp.thurii.Settings
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bouboulecorp.thurii.LocaleHelper
import com.bouboulecorp.thurii.LogInSignInMenu.LogInSignInMenuActivity
import com.bouboulecorp.thurii.MainActivity
import com.bouboulecorp.thurii.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

    fun goToLogInSignInPage(view: View) {
        val intent = Intent(this, LogInSignInMenuActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun changeToFrench(view: View) {
        LocaleHelper.setLocale(this, "fr") //for french;
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun changeToEnglish(view: View) {
        LocaleHelper.setLocale(this, "en") //for english;
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
