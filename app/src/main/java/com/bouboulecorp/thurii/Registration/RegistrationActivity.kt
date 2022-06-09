package com.bouboulecorp.thurii.Registration.RegistrationFragment

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bouboulecorp.thurii.R
import com.bouboulecorp.thurii.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        supportActionBar?.hide() // hide top bar

        setContentView(binding.root)
        val homeFragment = FragmentRegistrationGender()
        val fragment: Fragment? = supportFragmentManager.findFragmentByTag(
            FragmentRegistrationGender::class.java.simpleName
        )
        val progress = findViewById<ProgressBar>(R.id.step_bar)

        if (fragment !is FragmentRegistrationGender) {
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.fragmentContainer, homeFragment,
                    FragmentRegistrationGender::class.java.simpleName
                )
                .commit()
        }

        binding.continueBtn.setOnClickListener {
            if (progress.progress == 25) replaceFragment(FragmentRegistrationSport())
            else if (progress.progress == 50) replaceFragment(FragmentRegistrationInfo())
            progress.incrementProgressBy(25)
        }
        binding.backbtn.setOnClickListener {
            if (progress.progress == 50) {
                replaceFragment(FragmentRegistrationGender())
                progress.setProgress(25)
            } else if (progress.progress == 75) {
                replaceFragment(FragmentRegistrationSport())
                progress.setProgress(50)
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}
