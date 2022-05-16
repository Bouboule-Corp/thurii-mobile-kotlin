package com.bouboulecorp.thurii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bouboulecorp.thurii.databinding.ActivityMainBinding
import com.bouboulecorp.thurii.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
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
        val btn_female = findViewById<ImageButton>(R.id.btn_female)
        val btn_male = findViewById<ImageButton>(R.id.btn_male)
        val progress = findViewById<ProgressBar>(R.id.step_bar)

        btn_female.setOnClickListener {
            btn_female.setAlpha(1.0f)
            btn_male.setAlpha(0.4f)
            con_button.setBackgroundColor(ContextCompat.getColor(this, R.color.color_logo));
        }

        btn_male.setOnClickListener {
            btn_male.setAlpha(1.0f)
            btn_female.setAlpha(0.4f)
            con_button.setBackgroundColor(ContextCompat.getColor(this, R.color.color_logo));
        }
        con_button.setOnClickListener {
            var i = progress.progress
            progress.setProgress(i + 25)
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