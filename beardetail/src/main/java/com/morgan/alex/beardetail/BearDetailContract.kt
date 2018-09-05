package com.morgan.alex.beardetail

import com.alex.morgan.bearlist.Bear

interface BearDetailContract {
    interface View {
        fun showName(name: String)

        fun showImage(url: String)

        fun getBearArgument(): Bear
    }

    interface Presenter {
        fun attachView(view: View)

        fun detachView()
    }
}