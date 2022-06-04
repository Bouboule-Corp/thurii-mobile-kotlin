
package com.bouboulecorp.thurii

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bouboulecorp.thurii.databinding.ActivityRegistrationBinding

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
            if (progress.progress == 25) replaceFragment(FragmentRegistrationSport())
            var i = progress.progress
            progress.incrementProgressBy(25)
//            else if (progress.progress == 50) replaceFragment(FragmentRegistrationInfo())
        }
        binding.backbtn.setOnClickListener {
            if (progress.progress == 50) {
                replaceFragment(FragmentRegistrationGender())
                progress.setProgress(25)
            }
        }
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}