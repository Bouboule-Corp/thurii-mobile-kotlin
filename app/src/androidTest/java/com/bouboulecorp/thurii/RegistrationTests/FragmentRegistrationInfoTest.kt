package com.bouboulecorp.thurii.RegistrationTests

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.bouboulecorp.thurii.R
import com.bouboulecorp.thurii.Registration.RegistrationFragment.FragmentRegistrationInfo
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class FragmentRegistrationInfoTest {
    @Test
    fun test_isFragmentInfoTitleCorrect() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.info_title)).check(
            matches(
                withText(R.string.register_info_title)
            )
        )
    }

    @Test
    fun test_isFragmentInfoDesCorrect() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.info_des)).check(
            matches(
                withText(R.string.register_info_des)
            )
        )
    }

    @Test
    fun test_isDateLayoutDisplayed() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.date_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isBirthdayTxtDisplayed() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.date_txt)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isBirthdayTxtCorrect() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.date_txt)).check(matches(withText(R.string.birthday)))
    }

    @Test
    fun test_isBirthdayResDisplayed() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.date_res)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isBirthdayBtnDisplayed() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.date_btn)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isLayoutWeightDisplayed() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.weightLayout)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isWeightTxtDisplayed() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.poids)).check(matches(isDisplayed()))
        onView(withId(R.id.poids)).check(matches(withText(R.string.weight)))
    }

    @Test
    fun test_isWeightSpinnerDisplayed() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.weight_spinner)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isLayoutHeightDisplayed() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.heightLayout)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isHeightTxtDisplayed() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.height)).check(matches(isDisplayed()))
        onView(withId(R.id.height)).check(matches(withText(R.string.size)))
    }

    @Test
    fun test_isHeightSpinnerDisplayed() {
        launchFragmentInContainer<FragmentRegistrationInfo>(
            fragmentArgs = null
        )
        onView(withId(R.id.height_spinner)).check(matches(isDisplayed()))
    }
}