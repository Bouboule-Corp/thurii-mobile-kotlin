package com.bouboulecorp.thurii.LogInSignInMenu
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.bouboulecorp.thurii.R
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.bouboulecorp.thurii.LogIn.LogInActivity
import com.bouboulecorp.thurii.Registration.RegistrationFragment.RegistrationActivity

class LogInSignInMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_sign_in_menu)

        // Declaring and Initializing
        // the TextView from the layout file
        val mTextView = findViewById<TextView>(R.id.text_link)

        // Finding and displaying the content
        // that consists a URL as a hyperlink
        mTextView.movementMethod = LinkMovementMethod.getInstance()

        val sharedPreference = getSharedPreferences("USER_VARIABLES", Context.MODE_PRIVATE)
        when (sharedPreference.getInt("theme_selected", 2)) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.applyDayNight()
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.applyDayNight()
            }
            2 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                delegate.applyDayNight()
            }
        }
    }

    fun goToLogInPage(view: View) {
        val intent = Intent(this, LogInActivity::class.java)
        startActivity(intent)
    }

    fun goToSignInPage(view: View) {
        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
    }
}
