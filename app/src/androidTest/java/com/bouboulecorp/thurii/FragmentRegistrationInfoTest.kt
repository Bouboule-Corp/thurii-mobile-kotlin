package com.bouboulecorp.thurii

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class FragmentRegistrationInfoTest{
    @Test
    fun test_isFragmentInfoTitleCorrect() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.info_title)).check(matches(withText(R.string.register_info_title)))
    }

    @Test
    fun test_isFragmentInfoDesCorrect() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.info_des)).check(matches(withText(R.string.register_info_des)))
    }

    @Test
    fun test_isFragmentDropBirthdayDisplayed() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.date_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isFragmentDropWeightDisplayed() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.weight)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isFragmentDropHeightDisplayed() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.height_layout)).check(matches(isDisplayed()))
    }
}