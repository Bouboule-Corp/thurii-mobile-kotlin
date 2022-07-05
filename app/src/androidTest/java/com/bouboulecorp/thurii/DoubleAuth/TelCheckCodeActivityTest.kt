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
class TelCheckCodeActivityTest {
    @Test
    fun test_isTitleDisplayed() {
        ActivityScenario.launch(TelCheckCodeActivity::class.java)
        onView(withId(R.id.title_my_code))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isTitleCorrect() {
        ActivityScenario.launch(TelCheckCodeActivity::class.java)
        onView(withId(R.id.title_my_code))
            .check(matches(withText(R.string.my_code)))
    }

    @Test
    fun test_isPhoneNumberDisplayed() {
        ActivityScenario.launch(TelCheckCodeActivity::class.java)
        onView(withId(R.id.numero_title))
            .check(matches(isDisplayed()))
        onView(withId(R.id.numero_title))
            .check(matches(withText(R.string.numero)))
    }

    @Test
    fun test_isEditTextOneDisplay() {
        ActivityScenario.launch(TelCheckCodeActivity::class.java)
        onView(withId(R.id.code_first))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isEditTextTwoDisplay() {
        ActivityScenario.launch(TelCheckCodeActivity::class.java)
        onView(withId(R.id.code_second))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isEditTextThreeDisplay() {
        ActivityScenario.launch(TelCheckCodeActivity::class.java)
        onView(withId(R.id.code_third))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isEditTextFourDisplay() {
        ActivityScenario.launch(TelCheckCodeActivity::class.java)
        onView(withId(R.id.code_fourth))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isEditTextFiveDisplay() {
        ActivityScenario.launch(TelCheckCodeActivity::class.java)
        onView(withId(R.id.code_fifth))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isEditTextSixDisplay() {
        ActivityScenario.launch(TelCheckCodeActivity::class.java)
        onView(withId(R.id.code_sixth))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isBtnResendDisplay() {
        ActivityScenario.launch(TelCheckCodeActivity::class.java)
        onView(withId(R.id.resend_code_btn))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isBtnContinueDisplay() {
        ActivityScenario.launch(TelCheckCodeActivity::class.java)
        onView(withId(R.id.continueBtnTelAuth))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isConditionPoliticDisplay() {
        ActivityScenario.launch(TelCheckCodeActivity::class.java)
        onView(withId(R.id.condition_politic))
            .check(matches(isDisplayed()))
        onView(withId(R.id.condition_politic))
            .check(matches(withText(R.string.condition_politic)))
    }
}
