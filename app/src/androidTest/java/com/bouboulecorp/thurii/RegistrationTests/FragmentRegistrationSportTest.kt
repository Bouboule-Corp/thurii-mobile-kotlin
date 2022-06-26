package com.bouboulecorp.thurii.RegistrationTests
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.bouboulecorp.thurii.R
import com.bouboulecorp.thurii.Registration.RegistrationFragment.FragmentRegistrationSport
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class FragmentRegistrationSportTest {

    @Test
    fun test_isFragmentSportTitleCorrect() {
        launchFragmentInContainer<FragmentRegistrationSport>(
            fragmentArgs = null
        )
        onView(withId(R.id.sport_title)).check(
            matches(
                withText(R.string.register_sport_title)
            )
        )
    }

    @Test
    fun test_isFragmentSportDesCorrect() {
        launchFragmentInContainer<FragmentRegistrationSport>(
            fragmentArgs = null
        )
        onView(withId(R.id.sport_des)).check(
            matches(
                withText(R.string.register_sport_des)
            )
        )
    }

    @Test
    fun test_isRandoImgisDislayed() {
        launchFragmentInContainer<FragmentRegistrationSport>(
            fragmentArgs = null
        )
        onView(withId(R.id.btn_rando)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isSnowImgisDislayed() {
        launchFragmentInContainer<FragmentRegistrationSport>(
            fragmentArgs = null
        )
        onView(withId(R.id.btn_escalade)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isEscaladeImgisDislayed() {
        launchFragmentInContainer<FragmentRegistrationSport>(
            fragmentArgs = null
        )
        onView(withId(R.id.btn_escalade)).check(matches(isDisplayed()))
    }
}
