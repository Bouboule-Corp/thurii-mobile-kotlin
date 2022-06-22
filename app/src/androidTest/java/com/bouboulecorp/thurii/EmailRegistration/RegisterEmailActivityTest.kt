package com.bouboulecorp.thurii.EmailRegistration

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.bouboulecorp.thurii.DoubleAuth.DoubleAuthActivity
import com.bouboulecorp.thurii.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class RegisterEmailActivityTest {
    @Test
    fun test_isBacktnDisplayed() {
        ActivityScenario.launch(RegisterEmailActivity::class.java)
        onView(withId(R.id.backbtn))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isProcessBarDisplayed() {
        ActivityScenario.launch(RegisterEmailActivity::class.java)
        onView(withId(R.id.step_bar))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isGgBtnDisplayed() {
        ActivityScenario.launch(RegisterEmailActivity::class.java)
        onView(withId(R.id.regi_google))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isNoShareCorrect() {
        ActivityScenario.launch(RegisterEmailActivity::class.java)
        onView(withId(R.id.no_share_info))
            .check(matches(isDisplayed()))
        onView(withId(R.id.no_share_info))
            .check(matches(withText(R.string.no_share_info)))
    }

    @Test
    fun test_isPseudoDisplayed() {
        ActivityScenario.launch(RegisterEmailActivity::class.java)
        onView(withId(R.id.et_pseudo))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isprenomDisplayed() {
        ActivityScenario.launch(RegisterEmailActivity::class.java)
        onView(withId(R.id.et_prenom))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isNomDisplayed() {
        ActivityScenario.launch(RegisterEmailActivity::class.java)
        onView(withId(R.id.et_nom))
            .check(matches(isDisplayed()))
    }
    @Test
    fun test_isEmaiclDisplayed() {
        ActivityScenario.launch(RegisterEmailActivity::class.java)
        onView(withId(R.id.et_email))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isPswDisplayed() {
        ActivityScenario.launch(RegisterEmailActivity::class.java)
        onView(withId(R.id.et_password))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isContinueBtnEmailDisplayed() {
        ActivityScenario.launch(RegisterEmailActivity::class.java)
        onView(withId(R.id.continueBtnEmail))
            .check(matches(withText(R.string.btn_continue)))
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
