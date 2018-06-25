package com.alex.morgan.bearlist.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alex.morgan.bearlist.BearListFragment
import com.alex.morgan.bearlist.R

class BearListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

        this.setSupportActionBar(this.findViewById(R.id.toolbar))
        val actionBar = this.supportActionBar
        actionBar?.setTitle(R.string.title)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, BearListFragment(), "bear_list")
            .commit()
    }
}
