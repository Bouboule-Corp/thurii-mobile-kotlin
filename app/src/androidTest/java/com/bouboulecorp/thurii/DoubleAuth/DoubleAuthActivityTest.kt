package com.bouboulecorp.thurii.DoubleAuth

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.bouboulecorp.thurii.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DoubleAuthActivityTest {
    @Test
    fun test_isBackBtnDisplayed() {
        ActivityScenario.launch(DoubleAuthActivity::class.java)
        onView(withId(R.id.backbtn))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isTitleCorrect() {
        ActivityScenario.launch(DoubleAuthActivity::class.java)
        onView(withId(R.id.double_title))
            .check(matches(isDisplayed()))
        onView(withId(R.id.double_title))
            .check(matches(withText(R.string.double_auth_title)))
    }

    @Test
    fun test_isNumbreTitleCorrect() {
        ActivityScenario.launch(DoubleAuthActivity::class.java)
        onView(withId(R.id.numero_title))
            .check(matches(isDisplayed()))
        onView(withId(R.id.numero_title))
            .check(matches(withText(R.string.numero)))
    }

    @Test
    fun test_isTelLayoutDisplayed() {
        ActivityScenario.launch(DoubleAuthActivity::class.java)
        onView(withId(R.id.tel_connect))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isTelSpinnerDisplayed() {
        ActivityScenario.launch(DoubleAuthActivity::class.java)
        onView(withId(R.id.tel_spinner))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isTelNumberDisplayed() {
        ActivityScenario.launch(DoubleAuthActivity::class.java)
        onView(withId(R.id.tel_number))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isDoubleResCorrect() {
        ActivityScenario.launch(DoubleAuthActivity::class.java)
        onView(withId(R.id.double_des))
            .check(matches(isDisplayed()))
        onView(withId(R.id.double_des))
            .check(matches(withText(R.string.double_auth_des)))
    }

    @Test
    fun test_isContinueBtnDisplayed() {
        ActivityScenario.launch(DoubleAuthActivity::class.java)
        onView(withId(R.id.continueBtn))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isConditionPoResCorrect() {
        ActivityScenario.launch(DoubleAuthActivity::class.java)
        onView(withId(R.id.condition_politic))
            .check(matches(isDisplayed()))
        onView(withId(R.id.condition_politic))
            .check(matches(withText(R.string.condition_politic)))
    }
}
