package com.alex.morgan.bearlist.list

import com.alex.morgan.bearlist.Bear

interface BearSource {
    val allBears: Collection<Bear>
}
