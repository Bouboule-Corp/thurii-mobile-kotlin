package com.bouboulecorp.thurii.Map

import android.view.View
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.bouboulecorp.thurii.HomePage.HomePageFragments.MapFragment
import com.bouboulecorp.thurii.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.Matcher
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)

class MapFragmentTest {
    @Test
    fun isMapInView() {
        launchFragmentInContainer<MapFragment>(
            fragmentArgs = null
        )
        val selfMatcher: Matcher<View> = withClassName(containsString("MapView"))
        onView(allOf(withId(R.id.mapView), selfMatcher)).check(matches(isDisplayed()))
    }
}
