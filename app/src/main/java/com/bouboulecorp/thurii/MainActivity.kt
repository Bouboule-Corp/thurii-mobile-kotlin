package com.bouboulecorp.thurii
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bouboulecorp.thurii.HomePage.HomePageFragments.SessionFragment
import com.bouboulecorp.thurii.HomePage.HomePageFragments.HomeFragment
import com.bouboulecorp.thurii.HomePage.HomePageFragments.ProfileFragment
import com.bouboulecorp.thurii.HomePage.HomePageFragments.MapFragment
import com.bouboulecorp.thurii.Settings.SettingsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val profileFragment = ProfileFragment()
    private val sessionFragment = SessionFragment()
    private val mapFragment = MapFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(HomeFragment())
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_map -> replaceFragment(mapFragment)
                R.id.ic_session -> replaceFragment(sessionFragment)
                R.id.ic_profile -> replaceFragment(profileFragment)
            }
            true
        }
    }

    fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.addToBackStack(null)
        transaction.replace(R.id.Fragment_layout, fragment)
        transaction.commit()
    }

    fun goToSettings(view: View) {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}
