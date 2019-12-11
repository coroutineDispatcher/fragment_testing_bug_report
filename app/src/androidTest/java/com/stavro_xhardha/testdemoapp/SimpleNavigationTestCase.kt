package com.stavro_xhardha.testdemoapp

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class SimpleNavigationTestCase {
    private lateinit var navController: NavController

    @Before
    fun setUp() {
        navController = mock(NavController::class.java)
        val fragmentScenario = launchFragmentInContainer<StartDestinationFragment>()
        fragmentScenario.onFragment {
            Navigation.setViewNavController(it.requireView(), navController)
        }
    }

    @After
    fun tearDown() {

    }

    @Test
    fun testButtonClick() {
        onView(withId(R.id.button)).perform(click())
        verify(navController).navigate(R.id.destinationFragment)
    }
}