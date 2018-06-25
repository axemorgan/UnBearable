package com.alex.morgan.bearlist.list

import com.alex.morgan.bearlist.Bear

import java.util.ArrayList
import java.util.Collections

import javax.inject.Inject
import javax.inject.Singleton

class BearCache @Inject constructor() {

    var bears: Collection<Bear> = emptySet()

    fun putBears(bears: Collection<Bear>) {
        this.bears = ArrayList(bears)
    }
}
