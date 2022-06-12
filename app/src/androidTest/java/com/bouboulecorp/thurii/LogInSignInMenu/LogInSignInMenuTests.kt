package com.bouboulecorp.thurii.LogInSignInMenu
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
class LogInSignInMenuTests {

    @Test
    fun test_isButtonSignIn() {
        ActivityScenario.launch(LogInSignInMenuActivity::class.java)
        onView(withId(R.id.sign_in_menu_button)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isButtonLogIn() {
        ActivityScenario.launch(LogInSignInMenuActivity::class.java)
        onView(withId(R.id.sign_in_menu_button)).check(matches(isDisplayed()))
    }

    @Test
    fun test_goToLoginActivtiy() {
        ActivityScenario.launch(LogInSignInMenuActivity::class.java)
        onView(withId(R.id.sign_in_menu_button)).check(matches(isDisplayed()))
        onView(withId(R.id.text_link)).check(matches(ViewMatchers.withText(R.string.link)))
    }
}
