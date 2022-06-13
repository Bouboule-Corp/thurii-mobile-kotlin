package com.bouboulecorp.thurii.Settings
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bouboulecorp.thurii.LogInSignInMenu.LogInSignInMenuActivity
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
}