package com.bouboulecorp.thurii.activities.LogInSignInMenu
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.TextView
import com.bouboulecorp.thurii.activities.LogIn.LoginActivity
import com.bouboulecorp.thurii.R

class LogInSignInMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_sign_in_menu)

        // Declaring and Initializing
        // the TextView from the layout file
        val mTextView = findViewById<TextView>(R.id.textView)

        // Finding and displaying the content
        // that consists a URL as a hyperlink
        mTextView.movementMethod = LinkMovementMethod.getInstance()
    }

    fun goToLoginPage(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
