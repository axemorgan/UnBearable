package com.alex.morgan.bearlist

import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alex.morgan.bearlist.list.BearAdapter
import com.alex.morgan.bearlist.list.BearListActivity

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
    val activityRule = ActivityScenarioRule(BearListActivity::class.java)

    @Test
    fun useAppContext() {

        onView(withId(R.id.bear_recycler))
            .perform(
                RecyclerViewActions.actionOnItem<BearAdapter.BearViewHolder>(
                    withText("Paw Rudd"),
                    ViewActions.click()
                )
            )

        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.alex.morgan.bearlist", appContext.packageName)
    }
}
