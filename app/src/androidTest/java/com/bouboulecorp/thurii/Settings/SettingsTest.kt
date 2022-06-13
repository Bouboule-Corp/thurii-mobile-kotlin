package com.bouboulecorp.thurii.Settings

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.bouboulecorp.thurii.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SettingsTest {

    @Test
    fun test_iEditTextEmail() {
        ActivityScenario.launch(SettingsActivity::class.java)
        Espresso.onView(ViewMatchers.withId(R.id.log_in_button))
    }
}
