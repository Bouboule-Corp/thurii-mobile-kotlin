
package com.bouboulecorp.thurii

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bouboulecorp.thurii.databinding.ActivityRegistrationBinding
import java.util.zip.Inflater

class RegistrationActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        supportActionBar?.hide() //hide top bar

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
        val progress = findViewById<ProgressBar>(R.id.step_bar)

        binding.continueBtn.setOnClickListener {
            var i = progress.progress
            progress.incrementProgressBy(25)
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