package com.bouboulecorp.thurii
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTests {

    @Test
    fun test_isBottomBar() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.bottom_navigation)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isFragmentLayout() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.Fragment_layout)).check(matches(isDisplayed()))
    }
}