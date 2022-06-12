package com.bouboulecorp.thurii.LogIn
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.bouboulecorp.thurii.MainActivity
import com.bouboulecorp.thurii.R

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun goToMainActivity(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun changeStatePassword(view: View) {
        val editTextPassword = findViewById<EditText>(R.id.editTextTextPassword_login)

        if (editTextPassword.inputType == 129) { // set "textPassword" to "textVisiblePassword"
            editTextPassword.inputType = 145
        } else if (editTextPassword.inputType == 145) { // set "textVisiblePassword" to "textPassword"
            editTextPassword.inputType = 129
        }

        // placing cursor at the end of the text
        editTextPassword.setSelection(editTextPassword.length())
    }
}
