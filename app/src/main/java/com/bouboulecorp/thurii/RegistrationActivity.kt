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
        supportActionBar?.hide() // hide top bar

        setContentView(binding.root)
        val homeFragment = FragmentRegistrationGender()
        val fragment: Fragment? = supportFragmentManager.findFragmentByTag(
                                    FragmentRegistrationGender::class.java.simpleName)
        val progress = findViewById<ProgressBar>(R.id.step_bar)

        if (fragment !is FragmentRegistrationGender) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer,
                        homeFragment, FragmentRegistrationGender::class.java.simpleName)
                .commit()
        }

        binding.continueBtn.setOnClickListener {
            progress.incrementProgressBy(25)
        }
        binding.backbtn.setOnClickListener {
        }
    }
}
