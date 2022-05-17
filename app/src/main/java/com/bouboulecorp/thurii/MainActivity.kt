
package com.bouboulecorp.thurii

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bouboulecorp.thurii.databinding.ActivityRegistrationBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)

//        setContentView(R.layout.activity_registration)
        setContentView(binding.root)

        val homeFragment = FragmentRegistrationGender()
        val fragment : Fragment? =
            supportFragmentManager.findFragmentByTag(FragmentRegistrationGender::class.java.simpleName)

        if (fragment !is FragmentRegistrationGender) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, homeFragment, FragmentRegistrationGender::class.java.simpleName)
                .commit()
        }

        val con_button = findViewById<Button>(R.id.continueBtn)
        val progress = findViewById<ProgressBar>(R.id.step_bar)

        con_button.setOnClickListener {
            var i = progress.progress
            progress.setProgress(i + 25)
        }

        binding.continueBtn.setOnClickListener {
            replaceFragment(FragmentRegistrationSport())
        }
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}