package com.alex.morgan.bearlist.list

import com.alex.morgan.bearlist.Bear
import java.util.*
import javax.inject.Inject

class BearCache @Inject constructor() {

    var bears: Collection<Bear> = emptySet()

    fun putBears(bears: Collection<Bear>) {
        this.bears = ArrayList(bears)
    }
}
