package fr.iim.myapplication

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import fr.iim.myapplication.presentation.views.LoginActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<LoginActivity>
            = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun loginDefaultNav() {

        Espresso.onView(ViewMatchers.withId(R.id.main_email))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.main_email))
            .perform(ViewActions.replaceText("antoine@gmail.com"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.main_password))
            .perform(ViewActions.replaceText("1234"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.main_button_login))
            .perform(ViewActions.click())


    }
}