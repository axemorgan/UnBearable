package com.alex.morgan.bearlist.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alex.morgan.bearlist.Bear
import com.alex.morgan.bearlist.BearListFragment
import com.alex.morgan.bearlist.R
import com.morgan.alex.beardetail.BearDetailFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class BearListActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var widget: Widget

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        require(widget != null)

        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

        this.setSupportActionBar(this.findViewById(R.id.toolbar))
        val actionBar = this.supportActionBar
        actionBar?.setTitle(R.string.title)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, BearListFragment(), "bear_list")
            .commit()
    }

    fun showBearDetail(bear: Bear) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, BearDetailFragment.forBear(bear))
            .addToBackStack("DetailFragment")
            .commit()
    }

    override fun androidInjector(): AndroidInjector<Any> = fragmentInjector
}
