package com.morgan.alex.beardetail

import javax.inject.Inject

class BearDetailPresenter @Inject constructor() : BearDetailContract.Presenter {

    var view: BearDetailContract.View? = null

    override fun attachView(view: BearDetailContract.View) {
        this.view = view
        val bear = view.getBearArgument()
        view.showName(bear.name)
        view.showImage(bear.profileImageUrl)
    }

    override fun detachView() {
        this.view = null
    }

}