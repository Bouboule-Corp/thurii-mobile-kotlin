package com.bouboulecorp.thurii

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class FragmentRegistrationGenderTest{

    @Test
    fun test_isActivityInView() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.fragmentContainer)).check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_title() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.gender_title))
            .check(matches(isDisplayed()))
        onView(withId(R.id.gender_des))
            .check(matches(isDisplayed()))

    }

    @Test
    fun test_isFragmentTitleCorrect() {
        launchFragmentInContainer<FragmentRegistrationGender>(
            fragmentArgs = null
        )
        onView(withId(R.id.gender_title)).check(matches(withText(R.string.register_gender_title)))
    }

    @Test
    fun test_isFragmentDesCorrect() {
        launchFragmentInContainer<FragmentRegistrationGender>(
            fragmentArgs = null
        )
        onView(withId(R.id.gender_des)).check(matches(withText(R.string.register_first_des)))
    }
}