package com.bouboulecorp.thurii.LogIn
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.bouboulecorp.thurii.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class LogInTests {

    @Test
    fun test_iEditTextEmail() {
        ActivityScenario.launch(LogInActivity::class.java)
        onView(withId(R.id.editTextTextEmailAddress_login)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isEditTextPassword() {
        ActivityScenario.launch(LogInActivity::class.java)
        onView(withId(R.id.editTextTextPassword_login)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isImagePassword() {
        ActivityScenario.launch(LogInActivity::class.java)
        onView(withId(R.id.state_password)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isButtonToMainActivity() {
        ActivityScenario.launch(LogInActivity::class.java)
        onView(withId(R.id.log_in_button)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isTextLink() {
        ActivityScenario.launch(LogInActivity::class.java)
        onView(withId(R.id.text_link)).check(matches(ViewMatchers.withText(R.string.link)))
    }
}

