package com.alex.morgan.bearlist

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.alex.morgan.MockApplication
import com.alex.morgan.bearlist.list.*
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    // Rules like this can't be supported because they create the Activity before anything in this test file
    // has a chance to act.
//    @get:Rule
//    val activityRule = ActivityScenarioRule(BearListActivity::class.java)

    @Before
    fun setup() {
        val mockApplication =
            InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as MockApplication
        mockApplication.interceptingInjector.addCustomInjection(BearListActivity::class) {
            val activity = it as BearListActivity
            activity.widget = Widget()
            activity.fragmentInjector = mockApplication.interceptingInjector
        }
        mockApplication.interceptingInjector.addCustomInjection(BearListFragment::class) {
            val mockBearSource = MockBearSource()
            val fragment = it as BearListFragment
            fragment.presenter =
                BearListPresenter(BearFetcher(mockBearSource, BearCache()), { RubeGoldbergMachine() })
        }
    }

    @Test
    fun useAppContext() {
        ActivityScenario.launch(BearListActivity::class.java)

        onView(withId(R.id.bear_recycler))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<BearAdapter.BearViewHolder>(
                    0,
                    ViewActions.click()
                )
            )

        onView(allOf(withId(R.id.bear_detail_name), withText("Paw Rudd"))).check(matches(isDisplayed()))
    }
}

class MockBearSource : BearSource {
    override val allBears: Collection<Bear>
        get() = listOf(Bear("Paw Rudd", "https://placebear.com/40/40.jpg"))
}
